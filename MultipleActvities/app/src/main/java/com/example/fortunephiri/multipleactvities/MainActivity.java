package com.example.fortunephiri.multipleactvities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Test","onCreate");

        findViewById(R.id.btnSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),SecondActivity.class);    //this can be used to start an activity
                                            //intent takes two params, context and
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Test","OnStart");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Test","OnResume");
    }

    @Override
    protected void onPause() {
        //will be triggered when switching to a different activity
        super.onPause();
        Log.d("Test","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Test","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Test","onDestroy");
    }
}
