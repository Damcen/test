package a.nothing.menu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import a.nothing.R;

public class Menu1 extends AppCompatActivity
{
    private List<String> list = new ArrayList<>();
    private ListView lv;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        lv = ((ListView) findViewById(R.id.lv));
        for (int i = 0; i < 20; i++)
        {
            list.add("chua  " + i);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Menu1.this);
        switch (item.getItemId())
        {
            case R.id.menu_bla1:
                builder.setTitle("FBI WARNING");
                builder.setMessage("你成年了吗？");
                builder.setPositiveButton("成年了", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("没有", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        builder.setMessage("那再见");
                        builder.show();
                    }
                });
                builder.show();
                break;

            case R.id.menu_bla2:
                builder.setTitle("chua");
                builder.setMessage("tua");
                builder.setNegativeButton("b", null);
                builder.setPositiveButton("a", null);
                builder.setNeutralButton("c", null);
                builder.show();
                break;

            case R.id.menu_bla3:
                builder.setTitle("复选框");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMultiChoiceItems(new String[]{"a", "b", "c"}, null, new DialogInterface.OnMultiChoiceClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked)
                    {
                    }
                });
                builder.setPositiveButton("OK", null);
                builder.show();
                break;

            case R.id.menu_bla4:
                builder.setTitle("单选框");
                builder.setSingleChoiceItems(new String[]{"a", "b", "c"}, 0, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });
                builder.setPositiveButton("单选", null);
                builder.show();
                break;

            case R.id.menu_bla5:
                builder.setTitle("列表框");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setItems(new String[]{"卖饼中单", "颜值上单"}, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });
                builder.show();
                break;

            case R.id.menu_bla6:
                builder.setTitle("自定义");
                builder.setView(new EditText(Menu1.this));
                builder.setNegativeButton("ok", null);
                builder.show();
                break;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.context_menu1:
                Toast.makeText(Menu1.this, "这是1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.context_menu2:
                Toast.makeText(Menu1.this, "这是2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.context_menu3:
                Toast.makeText(Menu1.this, "这是3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
