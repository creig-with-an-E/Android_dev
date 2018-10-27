package com.example.fortunephiri.multipleactvities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        finish();   //implementation of the back button, taking the activity off the stack
        //should be implemented by creating a new Activity as this will add it to the stack
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d("TEST","OnCreate ****SECOND *****");
        findViewById(R.id.btnBack).setOnClickListener(this);
    }

}
