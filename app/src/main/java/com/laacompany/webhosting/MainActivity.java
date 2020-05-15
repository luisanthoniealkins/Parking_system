package com.laacompany.webhosting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.id_text1);
        tv2 = findViewById(R.id.id_text2);
        tv3 = findViewById(R.id.id_text3);

        handler.postDelayed(runnable, 300);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //Do your refreshing
            refresh();
            //This basically reruns this runnable in 0.3 seconds
            handler.postDelayed(this, 300);
        }
    };

    private void refresh(){

        Ion.with(getApplicationContext()).load("https://alkinswebhosting.000webhostapp.com").asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
//                tv.setText(result);
                if (result == null || result.isEmpty()) return;
                String[] texts = result.split("#");
                if (texts.length == 4){
                    tv1.setText(texts[1]);
                    tv2.setText(texts[2]);
                    tv3.setText(texts[3]);
                }
//                tv1.setText(result);
            }
        });
    }

}
