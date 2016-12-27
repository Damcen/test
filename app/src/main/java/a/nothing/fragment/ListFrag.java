package a.nothing.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import a.nothing.R;

/**
 * Created by Administrator on 2016/12/24.
 */

public class ListFrag extends ListFragment
{
    private ArrayAdapter<String> adapter;
    private List<String> list = new ArrayList<>();
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, addList(list));
        this.setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        ListFragReplace listFragReplace = new ListFragReplace();

        transaction.replace(R.id.fl, listFragReplace);
        transaction.commit();
    }

    private List<String> addList(List<String> list)
    {
        for (int i = 0; i < 20; i++)
        {
            list.add("item  " + i);
        }
        return list;
    }
}
