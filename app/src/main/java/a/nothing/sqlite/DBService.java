package a.nothing.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/12/26.
 */

public class DBService
{
    private Context context;
    private DBOpenHelper dbOpenHelper;
    private TextView tv;

    public DBService(Context context, TextView tv)
    {
        this.context = context;
        this.tv = tv;
        dbOpenHelper = new DBOpenHelper(context, "bb", null, 1);
    }

    public void insertDB()
    {
        //插入数据
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("insert into user(age) values(10)");
    }

    public void selectDB()
    {
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select age from user", null);
        while (c.moveToNext())
        {
            int age1 = c.getInt(c.getColumnIndex("age"));
            tv.setText(age1+"");
//            Log.i("AAA", age1 + "");
        }
    }
}
