package a.nothing.contentProvider.self;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import a.nothing.R;


/*需要在配置文件设置属性   */
public class Main9Activity extends AppCompatActivity
{
    private ListView lv;
    private SimpleCursorAdapter adapter;
    MyContentProvider provider;
    private Cursor cursor;
    private List<User> users = new ArrayList<>();
    private String[] names = new String[]{"bla", "chua", "tua"};
    private int[] ages = new int[]{1, 2, 3};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        lv = ((ListView) findViewById(R.id.lv_self_cp));
        provider = new MyContentProvider(this);
        cursor = provider.query(
                MyContentProvider.CONTENT_URI,
                new String[]{"name", "age"},
                null, null, null);

        adapter = new SimpleCursorAdapter(
                this,
                R.layout.item_content_provider,
                cursor,
                new String[]{"name", "age"},
                new int[]{R.id.tv_cp_head, R.id.tv_cp_body});
        lv.setAdapter(adapter);
    }

    public void onClick(View v)
    {
        users.add(addUser());
        adapter.notifyDataSetChanged();
    }

    private User addUser()
    {
        int i = (int) (Math.random() * 3);
        int j = (int) (Math.random() * 3);
        User user = new User(names[i], ages[j]);
        return user;
    }
}
