package com.example.fortunephiri.multipleactvities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int MY_TAG =1;
    static final int  MY_CONTACT_TAG =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Test","onCreate");

        findViewById(R.id.btnSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i = new Intent(v.getContext(),SecondActivity.class);    //this can be used to start an activity
                                            //intent takes two params, context and
                //startActivity(i);

                // start for results
                Intent i =new Intent(v.getContext(),SecondActivity.class);
                startActivityForResult(i, MY_TAG);

            }
        });
        findViewById(R.id.btnMaps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=160+kendal+ave+Toronto"));
                startActivity(i);

            }
        });

        findViewById(R.id.btnContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,Uri.parse("content://contacts"));
                i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(i,MY_CONTACT_TAG);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_TAG){
            //if equal means this is a message from second activity
            if(resultCode == RESULT_OK){
                String msg = data.getStringExtra("MSG");
                ((TextView)findViewById(R.id.textView)).setText(msg);

            }
        }else if(requestCode == MY_CONTACT_TAG){
            if(resultCode == RESULT_OK){
                Uri  uri = data.getData();  //works like url in browser
                String [] projection  = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor c = getContentResolver().query(uri, projection, null,null,null);  //content resolver lets you transform data to string
                c.moveToFirst();    //this runs the query

                int col = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = c.getString(col);
                ((TextView)findViewById(R.id.textView)).setText(number);
            }
        }
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
