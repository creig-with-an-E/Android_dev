package com.example.fortunephiri.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class myListActivity extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        data.add("Main");
        data.add("Maps");
        data.add("Screen 3");
        data.add("item4");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        //simple_list_item_1 -> defines one row with one item
        ListView list =findViewById(R.id.myList);
        list.setAdapter(adapter); //this will link the items to the Listview

    }
}
