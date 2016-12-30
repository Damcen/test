package a.nothing.contentProvider;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import a.nothing.R;

public class Main7Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_cp_sms:
                showFragSms();
                break;

            case R.id.btn_cp_phone:
                showFragCallLog();
                break;

            case R.id.btn_cp_person:
                showFragPerson();
                break;
        }
    }

    private void showFragSms()
    {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_cp, new FragSms());
        transaction.commit();
    }

    private void showFragCallLog()
    {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_cp, new FragCallLog());
        transaction.commit();
    }

    private void showFragPerson()
    {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_cp, new FragPerson());
        transaction.commit();
    }
}
