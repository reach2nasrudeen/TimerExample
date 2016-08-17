package com.nasrudeen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView hTextView;
    ViewFlipper viewFlipper;
    private String[] values;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipperSpecialNews);
        values = new String[]{"Test 1","Test 2","Test 3","Test 4","Test 5"};
        hTextView = (TextView)findViewById(R.id.txtspecialview);
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask, 3000, 5000);
    }
    class MyTimerTask extends TimerTask {
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(position >= values.length){
                        position = 0;
                    }
                    AnimationFactory.flipTransition(viewFlipper, AnimationFactory.FlipDirection.LEFT_RIGHT);
                    hTextView.setText("\n"+values[position]);
                    position = position+1;
                }
            });
        }
    }
}