package a.nothing.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import a.nothing.R;

public class Main10Activity extends AppCompatActivity
{
    private TextView tv;
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    tv.setText("chua");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        tv = ((TextView) findViewById(R.id.tv_handler));

    }

    public void onClick(View view)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                handler.sendEmptyMessage(1);
                Message msg = Message.obtain();

                handler.sendMessage(msg);
//                msg.what = 2;
            }
        }).start();
    }
}
