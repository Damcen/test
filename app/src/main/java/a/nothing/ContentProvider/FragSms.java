package a.nothing.ContentProvider;

import android.app.Fragment;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import a.nothing.R;


/**
 * Created by Administrator on 2016/12/27.
 */

public class FragSms extends Fragment
{
    private SimpleCursorAdapter adapter;
    private Cursor cursor;
    private ListView lv;
    private Uri uri = Uri.parse("content://sms");
    private String[] from = new String[]{"address", "body"};
    private int[] to = new int[]{R.id.tv_cp_head, R.id.tv_cp_body};
    private ContentResolver resolver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.item_cp_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        resolver = getActivity().getContentResolver();
        cursor = resolver.query(uri, new String[]{"_id", "address", "body"}, null, null, null);
        lv = ((ListView) view.findViewById(R.id.lv_cp));

        adapter = new SimpleCursorAdapter(getActivity(), R.layout.item_content_provider, cursor, from, to);
        lv.setAdapter(adapter);
    }
}
