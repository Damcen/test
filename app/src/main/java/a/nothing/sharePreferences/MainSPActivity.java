package a.nothing.sharePreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import a.nothing.R;

public class MainSPActivity extends AppCompatActivity
{
    private TextView tv;
    private ImageView iv;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private int r, g, b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sp);

        tv = ((TextView) findViewById(R.id.tv_sp));
        iv = ((ImageView) findViewById(R.id.iv_sp));
        sp = getSharedPreferences("test", Context.MODE_PRIVATE);
        editor = sp.edit();

        r = sp.getInt("r", 0);
        g = sp.getInt("g", 0);
        b = sp.getInt("b", 0);

        iv.setBackgroundColor(Color.rgb(r, g, b));
        tv.setText("r=" + r + ",g=" + g + ",b=" + b);
    }

    public void onClick(View v)
    {
        r = (int) (Math.random() * 255);
        g = (int) (Math.random() * 255);
        b = (int) (Math.random() * 255);

        editor.putInt("r", r);
        editor.putInt("g", g);
        editor.putInt("b", b);
        editor.commit();

        iv.setBackgroundColor(Color.rgb(r, g, b));
        tv.setText("r=" + r + "\ng=" + g + "\nb=" + b);
    }
}

/*class PopupAdapter extends ArrayAdapter<String> {

    PopupAdapter(ArrayList<String> items) {
        super(getActivity(), R.layout.list_item, android.R.id.text1, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        // Let ArrayAdapter inflate the layout and set the text
        View view = super.getView(position, convertView, container);

        // BEGIN_INCLUDE(button_popup)
        // Retrieve the popup button from the inflated view
        View popupButton = view.findViewById(R.id.button_popup);

        // Set the item as the button's tag so it can be retrieved later
        popupButton.setTag(getItem(position));

        // Set the fragment instance as the OnClickListener
        popupButton.setOnClickListener(PopupListFragment.this);
        // END_INCLUDE(button_popup)

        // Finally return the view to be displayed
        return view;
    }
}
而后是点击事件的代码




@Override
public void onClick(final View view) {
    // We need to post a Runnable to show the popup to make sure that the PopupMenu is
    // correctly positioned. The reason being that the view may change position before the
    // PopupMenu is shown.
    view.post(new Runnable() {
        @Override
        public void run() {
            showPopupMenu(view);
        }
    });
}
// BEGIN_INCLUDE(show_popup)
private void showPopupMenu(View view) {
    final PopupAdapter adapter = (PopupAdapter) getListAdapter();

    // Retrieve the clicked item from view's tag
    final String item = (String) view.getTag();

    // Create a PopupMenu, giving it the clicked view for an anchor
    PopupMenu popup = new PopupMenu(getActivity(), view);

    // Inflate our menu resource into the PopupMenu's Menu
    popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

    // Set a listener so we are notified if a menu item is clicked
    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_remove:
                    // Remove the item from the adapter
                    adapter.remove(item);
                    return true;
            }
            return false;
        }
    });

    // Finally show the PopupMenu
    popup.show();
}
*/