package com.glitterlabs.home.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(1000,1000){

            public void onTick(long millisecondsUntillDone){

                //countdown is counting down (every second)
                Log.i("Second left",String.valueOf(millisecondsUntillDone));
            }
            public void onFinish(){
                //Counter is finished(after 10 second).
                Log.i("done", "Countdown timer finished");
            }
        }.start();

        /*final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {

                //hander Code to be run Every second

                Log.i("Runable has run","a second must have passed....");

                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);*/
    }

}
