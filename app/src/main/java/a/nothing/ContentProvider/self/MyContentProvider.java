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
    final static String AUTHORITY = "a.nothing.contentProvider.self.zz";
    public static final int USER_DIR = 0;
    public static final int USER = 1;

    private static UriMatcher mUriMatcher;

    static
    {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(AUTHORITY, "user", USER_DIR);
    }

    private MySqlite mySqlite;

    @Override
    public boolean onCreate()
    {
        mySqlite = new MySqlite(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {
        SQLiteDatabase database = mySqlite.getReadableDatabase();
        Cursor c = null;
        switch (mUriMatcher.match(uri))
        {
            case USER_DIR:
                c = database.query("user", projection, selection, selectionArgs, null, null, sortOrder);
                break;
        }
        return c;
    }

    @Nullable
    @Override
    public String getType(Uri uri)
    {
//        switch (mUriMatcher.match(uri))
//        {
//            case USER_DIR:
//                return "vnd.android.cursor.dir/" + AUTHORITY + ".users";
//
//            case USER:
//                return "vnd.android.cursor.item/" + AUTHORITY + ".user";
//
//            default:
//                throw new IllegalArgumentException("unknown uri" + uri.toString());
//        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        SQLiteDatabase database = mySqlite.getWritableDatabase();
        long rowID = -1;

        if (mUriMatcher.match(uri) == 0)
        {
            rowID = database.insert("user", null, values);
            return ContentUris.withAppendedId(uri, rowID);
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        SQLiteDatabase database = mySqlite.getWritableDatabase();
        int count = -1;
        switch (mUriMatcher.match(uri))
        {
            case USER_DIR:
                count = database.delete("user", null, null);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        SQLiteDatabase database = mySqlite.getWritableDatabase();
        int count = -1;
        if (mUriMatcher.match(uri) == 0)
        {
            count = database.update("user", values, null, null);
        }
        return count;
    }
}
