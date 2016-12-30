package a.nothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import a.nothing.contentProvider.Main7Activity;
import a.nothing.contentProvider.self.Main9Activity;
import a.nothing.day5_6.Main5Activity;
import a.nothing.fragment.MainFrag;
import a.nothing.handler.Main10Activity;
import a.nothing.load.Main8Activity;
import a.nothing.menu.Menu1;
import a.nothing.sharePreferences.MainSPActivity;
import a.nothing.single.Main2Activity;
import a.nothing.single.Main4Activity;
import a.nothing.single.MainActivity;
import a.nothing.sqlite.Main6Activity;

public class Mainly extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainly);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_main1:
                startActivity(new Intent(Mainly.this, MainActivity.class));
                break;

            case R.id.btn_main2:
                startActivity(new Intent(Mainly.this, Main2Activity.class));
                break;

            case R.id.btn_main3:
                startActivity(new Intent(Mainly.this, Main3Activity.class));
                break;

            case R.id.btn_main4:
                startActivity(new Intent(Mainly.this, Main4Activity.class));
                break;

            case R.id.btn_main5:
//                startActivity(new Intent(Mainly.this, Main5Activity.class));
                Toast.makeText(Mainly.this, "有问题", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_main6:
                startActivity(new Intent(Mainly.this, Menu1.class));
                break;

            case R.id.btn_main7:
                startActivity(new Intent(Mainly.this, MainSPActivity.class));
                break;

            case R.id.btn_main8:
                startActivity(new Intent(Mainly.this, MainFrag.class));
                break;

            case R.id.btn_main9:
                startActivity(new Intent(Mainly.this, Main6Activity.class));
                break;

            case R.id.btn_main10:
                startActivity(new Intent(Mainly.this, Main7Activity.class));
                break;

            case R.id.btn_main11:
                //                startActivity(new Intent(Mainly.this, Main9Activity.class));
                Toast.makeText(Mainly.this, "有问题", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_main12:
                startActivity(new Intent(Mainly.this, Main8Activity.class));
                break;

            case R.id.btn_main13:
                startActivity(new Intent(Mainly.this, Main10Activity.class));
                break;


        }
    }
}
