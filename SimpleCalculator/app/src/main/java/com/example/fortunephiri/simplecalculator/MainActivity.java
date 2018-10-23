package com.example.fortunephiri.simplecalculator;

import android.media.VolumeShaper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //defining the variables
    Button btn0 ,btn1, btn2, btn3, btn4,btn5, btn6, btn7, btn8, btn9, btnComma ,btnPlus, btnMinus , btnMultiply, btnDivide,btnEqual, btnClear;
    TextView tv ;
    float val1, val2;
    enum Operation {none , plus , minus, multiply , divide}     //this is an objcet used for storing constants
    Operation op = Operation.none;

    private float calculate(){
        switch (op){
            case plus: return val1 + val2;
            case minus: return val1 - val2;
            case multiply: return val1 * val2;
            case divide: if(val1 !=0){
                return val1/val2;
            }
            else{
                return Float.NaN;
            }
            default: return Float.NaN;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting access to the buttons in the view
        tv = findViewById(R.id.textView);
        btn0 =findViewById(R.id.btn0);
        btn1 =findViewById(R.id.btn1);
        btn2 =findViewById(R.id.btn2);
        btn3 =findViewById(R.id.btn3);
        btn4 =findViewById(R.id.btn4);
        btn5 =findViewById(R.id.btn5);
        btn6 =findViewById(R.id.btn6);
        btn7 =findViewById(R.id.btn7);
        btn8 =findViewById(R.id.btn8);
        btn9 =findViewById(R.id.btn9);

        View.OnClickListener numListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button)v;    //having a reference to the button that is passed from the view
                String digit = b.getText().toString();

                if(tv.getText().toString().equals("0")){
                    tv.setText(digit);
                }else{
                    tv.setText(tv.getText().toString() + digit);
                }
            }
        };

        btn0.setOnClickListener(numListener);
        btn1.setOnClickListener(numListener);
        btn2.setOnClickListener(numListener);
        btn3.setOnClickListener(numListener);
        btn4.setOnClickListener(numListener);
        btn5.setOnClickListener(numListener);
        btn6.setOnClickListener(numListener);
        btn7.setOnClickListener(numListener);
        btn8.setOnClickListener(numListener);
        btn9.setOnClickListener(numListener);

        btnComma =findViewById(R.id.btnComma);
        btnComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv.getText().toString().contains(".")){
                    return;
                }
                else{
                    tv.setText(tv.getText().toString() + ".");

                }
            }
        });
        btnClear =findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op= Operation.none;
                tv.setText("0");
            }
        });
        btnPlus =findViewById(R.id.btnPlus);
        btnMinus =findViewById(R.id.btnMinus);
        btnMultiply =findViewById(R.id.btnMultiply);
        btnDivide =findViewById(R.id.btnDivide);

        View.OnClickListener opListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if (op==Operation.none)
                  //when we have made any selection
                  {
                      val1 =Float.parseFloat(tv.getText().toString());
                      tv.setText("0");//resetting the display to let the user set another operrand
                  }else{
                        val2 =Float.parseFloat(tv.getText().toString());
                        val1 =calculate();
                        tv.setText("0");
                        switch (v.getId()){
                            case R.id.btnPlus: op=Operation.plus;
                                break;
                            case R.id.btnMinus: op=Operation.minus;
                                break;
                            case R.id.btnMultiply: op=Operation.multiply;
                                break;
                            case R.id.btnDivide: op=Operation.divide;
                                break;
                        }
                  }
            }
        };

        //btn listeners
        btnPlus.setOnClickListener(opListner);
        btnMinus.setOnClickListener(opListner);
        btnMultiply.setOnClickListener(opListner);
        btnDivide.setOnClickListener(opListner);

        btnEqual =findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op != Operation.none){
                    val2 =Float.parseFloat(tv.getText().toString());
                    val1=calculate();   //we store the result in val1 so that we can keep calculating
                    tv.setText(val1 + "");
                }
            }
        });


    }
}
