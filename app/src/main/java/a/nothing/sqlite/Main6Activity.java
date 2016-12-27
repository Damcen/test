package a.nothing.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import a.nothing.R;


public class Main6Activity extends AppCompatActivity
{
    private DBService dbService;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        tv = ((TextView) findViewById(R.id.tv_sql));
        dbService = new DBService(this, tv);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_create:
                dbService.insertDB();
                break;

            case R.id.btn_select:
                dbService.selectDB();
                break;
        }
    }
}
