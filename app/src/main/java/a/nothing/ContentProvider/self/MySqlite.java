package a.nothing.contentProvider.self;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/12/28.
 */

public class MySqlite extends SQLiteOpenHelper
{
    public MySqlite(Context context)
    {
        super(context, "zz", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table user(_id Integer primary key autoincrement,name varchar(50))");
        db.execSQL("alter table user add age Integer");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
