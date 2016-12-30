package a.nothing.load;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import a.nothing.R;

public class Main8Activity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<Cursor>
{
    private EditText et;
    private ListView lv;

    private SimpleCursorAdapter adapter;
    private Uri uri = Uri.parse("content://sms");
    private String[] path = new String[]{"_id", "address", "body"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        et = ((EditText) findViewById(R.id.et_load));
        lv = ((ListView) findViewById(R.id.lv_load));

        adapter = new SimpleCursorAdapter(this,
                R.layout.item_content_provider,
                null,
                new String[]{"address", "body"},
                new int[]{R.id.tv_cp_head, R.id.tv_cp_body},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        lv.setAdapter(adapter);

        getLoaderManager().initLoader(1, null, Main8Activity.this);

        et.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Bundle bundle = new Bundle();
                bundle.putString("key", s.toString());
                getLoaderManager().restartLoader(1, bundle, Main8Activity.this);
            }
        });
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args)
    {
        String selection = null;
        String[] selectionArgs = null;
        if (args != null)
        {
            selection = "body like ?";
            selectionArgs = new String[]{"%" + args.getString("key") + "%"};
        }
        CursorLoader cursorLoader = new CursorLoader(this, uri, path, selection, selectionArgs, null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data)
    {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader)
    {
        adapter.swapCursor(null);
    }
}
