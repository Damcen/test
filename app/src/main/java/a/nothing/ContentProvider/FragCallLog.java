package a.nothing.ContentProvider;

import android.app.Fragment;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import a.nothing.R;

/**
 * Created by Administrator on 2016/12/27.
 */

public class FragCallLog extends Fragment
{
    private ListView lv;
    private Cursor cursor;
    private ContentResolver resolver;
    private MyAdapter adapter;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
    private List<Calllog> list = new ArrayList<>();

    private Uri uri = CallLog.Calls.CONTENT_URI;
    private String[] colums = new String[]{CallLog.Calls._ID, CallLog.Calls.NUMBER, CallLog.Calls.DATE};

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
        cursor = resolver.query(uri, colums, null, null, null);
        lv = ((ListView) view.findViewById(R.id.lv_cp));
        initList();
        adapter = new MyAdapter();
        lv.setAdapter(adapter);
    }

    private void initList()
    {
        ContentResolver contentResolver = getActivity().getContentResolver();
        cursor = contentResolver.query(uri, colums, null, null, null);

        while (cursor.moveToNext())
        {
            Long id = cursor.getLong(cursor.getColumnIndex(CallLog.Calls._ID));
            String phoneNum = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
            Long date = cursor.getLong(cursor.getColumnIndex(CallLog.Calls.DATE));
            String dateText = simpleDateFormat.format(new Date(date));

            list.add(new Calllog(id, phoneNum, dateText));
        }
    }

    class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return list.size();
        }

        @Override
        public Object getItem(int position)
        {
            return list.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            Item it = null;
            if (convertView == null)
            {
                it = new Item();
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.item_content_provider, null);
                it.tvNum = (TextView) convertView.findViewById(R.id.tv_cp_head);
                it.tvBody = (TextView) convertView.findViewById(R.id.tv_cp_body);

                convertView.setTag(it);
            } else
            {
                it = (Item) convertView.getTag();
            }
            it.tvNum.setText(list.get(position).getNumber());
            it.tvBody.setText(list.get(position).getData());

            return convertView;
        }

        class Item
        {
            TextView tvNum;
            TextView tvBody;
        }
    }
}
