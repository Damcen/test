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
        db.execSQL("create table user(_id integer primary key autoincrement,name,pwd,money)");

        db.execSQL("insert into user (name,pwd,money) values('tua',123,10086)");
        db.execSQL("insert into user (name,pwd,money) values('chua',321,10010)");
//        db.execSQL("insert into user (name,pwd,money) values('rua',213,10000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
