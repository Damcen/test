package a.nothing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity
{
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Log.i("AAA", "这是创建");
        btn = ((Button) findViewById(R.id.btn));

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(Main4Activity.this, "blabla", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i("AAA", "这是开始");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i("AAA", "这是获取焦点");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i("AAA", "这是失去焦点");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i("AAA", "这是停止");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.i("AAA", "这是重启页面，你看不到");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i("AAA", "这是页面被销毁了");
    }
}
