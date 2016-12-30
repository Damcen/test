package a.nothing.contentProvider.self;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by Administrator on 2016/12/28.
 */

public class MyContentProvider extends ContentProvider
{
    private MySqlite mySqlite;
    private SQLiteDatabase userDB;

    private Context context;

    public MyContentProvider(Context context)
    {
        this.context = context;
    }

    final static String AUTHORITY = "a.nothing.contentProvider.self.test";
    static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/users");
    private static UriMatcher mUriMatcher;
    public static final int USER_DIR = 0;
    public static final int USER = 1;

    static
    {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(AUTHORITY, "user", USER_DIR);
        mUriMatcher.addURI(AUTHORITY, "person/#", USER);
    }

    @Override
    public boolean onCreate()
    {
//        Context context = getContext();
        mySqlite = new MySqlite(context);
        userDB = mySqlite.getWritableDatabase();
        return userDB == null ? false : true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables("user");

        if (mUriMatcher.match(uri) == USER)
            builder.appendWhere("_id = " + uri.getPathSegments().get(1));

        if (sortOrder == null || sortOrder == "")
            sortOrder = "name";

        Cursor c = builder.query(
                userDB,
                projection,
                selection,
                selectionArgs,
                null, null,
                sortOrder);

        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(Uri uri)
    {
        switch (mUriMatcher.match(uri))
        {
            case USER_DIR:
                return "vnd.android.cursor.dir/" + AUTHORITY + ".users";

            case USER:
                return "vnd.android.cursor.item/" + AUTHORITY + ".user";

            default:
                throw new IllegalArgumentException("unknown uri" + uri.toString());
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        long rowID = userDB.insert("user", "name,age", values);

        if (rowID > 0)
        {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        int count = 0;
        switch (mUriMatcher.match(uri))
        {
            case USER_DIR:
                count = userDB.delete("user", selection, selectionArgs);
                break;

            case USER:
                String id = uri.getPathSegments().get(1);
                count = userDB.delete("user",
                        "_id" + "=" + id + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : ""),
                        selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        return 0;
    }
}
