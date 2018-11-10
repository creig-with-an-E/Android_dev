package com.example.fortunephiri.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , PopupMenu.OnMenuItemClickListener{

    private ActionMode actionMode = null;   //this type of menu is created when using lists or grid
    private ActionMode.Callback callback = new ActionMode.Callback(){
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater i = mode.getMenuInflater();
            i.inflate(R.menu.popup_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //this is the handler for the menu
            switch (item.getItemId()){
                case R.id.popup1 :
                    Toast.makeText(getParent(),"Context is working", Toast.LENGTH_LONG);
                    return true;
                default: return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null ;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.layout).setOnClickListener(this);

        ListView listView =findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                //action when adding it to other list
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i  = getMenuInflater();    //this instantiates the menu
        i.inflate(R.menu.main_menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handles the selection for the menu
        switch (item.getItemId()){
            case R.id.main1 :
                //toast is a small bubble that appears then disappears
                Toast.makeText(this,"It is working",Toast.LENGTH_LONG).show();
                return true;
                default: return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onClick(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater i = popupMenu.getMenuInflater();       //all menus need to be inflated
        i.inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.popup1 :
                //toast is a small bubble that appears then disappears
                Toast.makeText(this,"Popup is working",Toast.LENGTH_LONG).show();
                return true;
            default: return false;
        }
    }
}
