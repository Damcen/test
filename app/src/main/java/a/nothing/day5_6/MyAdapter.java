package a.nothing.day5_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import a.nothing.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/22.
 */

public class MyAdapter extends BaseAdapter
{
    private Context context;
    private List<Qb> list;
    private int pager;

    public MyAdapter(Context context, List<Qb> list, int pager)
    {
        this.context = context;
        this.list = list;
        this.pager = pager;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int i)
    {
        return list.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder holder = null;
        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.item5, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.tvUserId.setText(list.get(pager).getItems().get(i).getUser().getLogin());
        holder.tvText.setText(list.get(pager).getItems().get(i).getContent());
        new MyImage(holder.iv).execute(list.get(pager).getItems().get(i).getUser().getIcon());

        return view;
    }

    static class ViewHolder
    {
        @BindView(R.id.tv_userId)
        TextView tvUserId;
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv_text)
        TextView tvText;

        ViewHolder(View view)
        {
            ButterKnife.bind(this, view);
        }
    }
}
