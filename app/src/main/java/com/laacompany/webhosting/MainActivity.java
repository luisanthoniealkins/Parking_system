package com.laacompany.webhosting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.id_text);

        handler.postDelayed(runnable, 3000);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //Do your refreshing
            refresh();
            //This basically reruns this runnable in 5 seconds
            handler.postDelayed(this, 300);
        }
    };

    private void refresh(){

        Ion.with(getApplicationContext()).load("https://alkinswebhosting.000webhostapp.com").asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                tv.setText(result);
            }
        });
    }

}
