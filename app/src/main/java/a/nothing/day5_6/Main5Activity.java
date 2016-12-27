package a.nothing.day5_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import a.nothing.R;

public class Main5Activity extends AppCompatActivity
{
    private ListView lv;
    private MyAdapter adapter;
    private List<Qb> list;
    private Qb qb;
    private int pager = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        lv = ((ListView) findViewById(R.id.lv));
        list = new ArrayList<>();
        adapter = new MyAdapter(this, list, pager);
        lv.setAdapter(adapter);
    }

    public void pagerJump(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_up:
                pager--;
                if (pager <= 0)
                    pager = 0;
                adapter.notifyDataSetChanged();
                break;

            case R.id.btn_down:
                pager++;
                adapter.notifyDataSetChanged();
                break;
        }
    }
}