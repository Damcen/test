package a.nothing.single;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;

import a.nothing.R;

public class Main2Activity extends AppCompatActivity
{

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cb1 = ((CheckBox) findViewById(R.id.cb1));
        cb2 = ((CheckBox) findViewById(R.id.cb2));
        cb3 = ((CheckBox) findViewById(R.id.cb3));

        tb = ((ToggleButton) findViewById(R.id.tb));
        tb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(Main2Activity.this, "ToggleButton", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void bla(View v)
    {
        Toast.makeText(this, "你按了按钮", Toast.LENGTH_SHORT).show();
    }

    public void rg(View v)
    {
        switch (v.getId())
        {
            case R.id.rb1:
                Toast.makeText(this, "你按了按钮1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb2:
                Toast.makeText(this, "你按了按钮2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb3:
                Toast.makeText(this, "你按了按钮3", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void cb(View v)
    {
        boolean flag1 = false, flag2 = false, flag3 = false;
        switch (v.getId())
        {
            case R.id.cb1:
                flag1=!flag1;
                cb1.setFocusable(flag1);
                break;

            case R.id.cb2:
                flag2=!flag2;
                cb2.setFocusable(flag2);
                break;

            case R.id.cb3:
                flag3=!flag3;
                cb3.setFocusable(flag3);
                break;
        }
    }
}
