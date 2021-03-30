package com.example.lemparcoinirvan;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LemparCoin extends Activity implements View.OnClickListener {
    private Button buttonlempar;
    private Button buttonulang;
    private Button buttonkeluar;
    private Random acak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acak = new Random();
        setContentView(R.layout.activity_lemparcoin);
        buttonlempar = (Button) findViewById(R.id.buttonlempar);
        buttonulang = (Button) findViewById(R.id.buttonulang);
        buttonkeluar = (Button) findViewById(R.id.buttonkeluar);
        buttonlempar.setOnClickListener(this);
        buttonulang.setOnClickListener(this);
        buttonkeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==buttonlempar) {
            Log.d("CLICK_EVENT", "Lempar button Clicked!");
            TextView tw=(TextView)findViewById(R.id.textView1);
            ImageView iw=(ImageView)findViewById(R.id.imageView);

            if (acak.nextDouble() <0.5) {
                tw.setText("Head");
                iw.setImageResource(R.drawable.head);
            }else {
                tw.setText("Tail");
                iw.setImageResource(R.drawable.tail);
            }
            buttonlempar.setVisibility(View.INVISIBLE);
            buttonulang.setVisibility(View.VISIBLE);
            buttonkeluar.setVisibility(View.VISIBLE);
        }
        else if (view==buttonulang) {
            TextView tw=(TextView)findViewById(R.id.textView1);
            ImageView iw=(ImageView)findViewById(R.id.imageView);

            buttonlempar.setVisibility(View.VISIBLE);
            buttonulang.setVisibility(View.INVISIBLE);
            buttonkeluar.setVisibility(View.INVISIBLE);
            tw.setText("");
            iw.setImageResource(R.drawable.question);
        }else if (view==buttonkeluar){
            this.finish();
        }
    }
}
