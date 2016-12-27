package a.nothing.ContentProvider;

import android.app.Fragment;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import a.nothing.R;

/**
 * Created by Administrator on 2016/12/27.
 */

public class FragPerson extends Fragment
{
    private ListView lv;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> list = new ArrayList<>();

    private Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
    private Uri phoneuri = Uri.parse("content://com.android.contacts/data");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.item_cp_list, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        lv = ((ListView) view.findViewById(R.id.lv_cp));
        initList();
        adapter = new SimpleAdapter(getActivity(), list, R.layout.item_content_provider,
                new String[]{"name", "phone"}, new int[]{R.id.tv_cp_head, R.id.tv_cp_body});
        lv.setAdapter(adapter);
    }

    private void initList()
    {
        Cursor cursor = getActivity().getContentResolver().query(uri, new String[]{"_id", "display_name"},
                null, null, null);

        while (cursor.moveToNext())
        {
            Map<String, Object> map = new HashMap<>();
            long id = cursor.getLong(cursor.getColumnIndex("_id"));
            map.put("id", id);
            map.put("name", cursor.getString(cursor.getColumnIndex("display_name")));

            Cursor phoneC = getActivity().getContentResolver().query(phoneuri,
                    new String[]{"data1"},
                    "mimetype_id=5 and raw_contact_id=" + id,
                    null, null);
            if (phoneC.moveToNext())
            {
                String phone = phoneC.getString(phoneC.getColumnIndex("data1"));
                map.put("phone", phone);
            }
            list.add(map);
        }
    }
}
