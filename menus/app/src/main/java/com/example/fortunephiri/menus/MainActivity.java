package com.example.fortunephiri.menus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

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
                    Toast.makeText(getApplicationContext(),"Context is working", Toast.LENGTH_LONG);
                    return true;
                default: return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null ;
        }
    };

    private ArrayList<String> data = new ArrayList<>();     //lists can not be hard coded. are added from data structure
    //lists are created from adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.layout).setOnClickListener(this);

        data.add("item1");
        data.add("item2");
        data.add("item3");
        data.add("item4");
        ArrayAdapter<String>  adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        ListView listView =findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(actionMode !=null){
                    return false;
                }
                actionMode = startActionMode(callback);
                v.setSelected(true);
                return true;
            }
        });

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                //action when adding it to other list
            }

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
                switch (item.getItemId()){
                    case R.id.popup1 :
                        Toast.makeText(getParent(),"Context is working", Toast.LENGTH_LONG);
                        return true;
                    default: return false;
                }
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
                Intent i = new Intent(this, myListActivity.class);
                startActivity(i);
                return true;
            case R.id.maps :
                Intent mapIntent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?query=CN+Tower"));
                startActivity(mapIntent);
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
