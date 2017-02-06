package a.nothing.contentProvider.self;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import a.nothing.R;


/*需要在配置文件设置属性   */
public class Main9Activity extends AppCompatActivity
{
    private ListView lv;
    private Uri uri = Uri.parse("content://a.nothing.contentProvider.self.zz/user");
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        lv = ((ListView) findViewById(R.id.lv_self_cp));
    }

    public void onClick(View v)
    {
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri,
                new String[]{"_id", "name", "pwd"},
                null, null, null);

        adapter = new SimpleCursorAdapter(this,
                R.layout.item_content_provider,
                cursor,
                new String[]{"name", "pwd"},
                new int[]{R.id.tv_cp_head, R.id.tv_cp_body});
        lv.setAdapter(adapter);
    }
}
