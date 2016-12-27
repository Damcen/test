package a.nothing.single;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import a.nothing.R;
import a.nothing.single.MyFragment;
import a.nothing.single.MyFragment2;


public class MainActivity extends AppCompatActivity
{
    private Button btn1;
    private Button btn2;
    private FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = ((Button) findViewById(R.id.btn1));
        btn2 = ((Button) findViewById(R.id.btn2));
        fl = ((FrameLayout) findViewById(R.id.fl));

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn1:
                changeFragment(1);
                break;

            case R.id.btn2:
                changeFragment(2);
                break;
        }
    }

    //改变整个Fragment
    private void changeFragment(int flag)
    {
        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        if (flag == 1)
            transaction.replace(R.id.fl, new MyFragment());
        else if (flag == 2)
            transaction.replace(R.id.fl, new MyFragment2());
        transaction.commit();
    }

}
