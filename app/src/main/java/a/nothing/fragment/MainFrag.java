package a.nothing.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;

import a.nothing.R;

public class MainFrag extends AppCompatActivity
{
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ListFrag listFrag;
    private DialogFrag dialogFrag;
    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frag);

        listFrag = new ListFrag();
        dialogFrag = new DialogFrag();

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_ListFragment:
                transaction.replace(R.id.fl, listFrag);
                transaction.commit();
                break;

            case R.id.btn_DialogFragment:
                dialogFrag.show(manager, "bla");
                break;

            case R.id.btn_popup:
                popupMenu = new PopupMenu(this, v);
                getMenuInflater().inflate(R.menu.context_menu, popupMenu.getMenu());
                popupMenu.show();
                break;
        }
    }
}
