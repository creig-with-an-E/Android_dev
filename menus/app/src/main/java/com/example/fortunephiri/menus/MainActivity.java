package com.example.fortunephiri.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.layout).setOnClickListener(this);
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
