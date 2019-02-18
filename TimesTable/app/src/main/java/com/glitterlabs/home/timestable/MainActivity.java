package com.glitterlabs.home.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timeTableListView;

    public void genrateTimeTable(int timeTable){

        ArrayList<String> timeTableArrayList = new ArrayList<String>();

        for(int i = 1; i<20 ;i++){
            timeTableArrayList.add(Integer.toString(i*timeTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeTableArrayList);
        timeTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSeekBar = (SeekBar)findViewById(R.id.timeTableSeekBar);
        timeTableListView = (ListView)findViewById(R.id.timeTableListView);

        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timetable;

                if (progress<min){
                    timetable = min;
                    timeTableSeekBar.setProgress(min);
                }else {
                    timetable = progress;
                }
                genrateTimeTable(timetable);
                Log.i("SeekBar Value",Integer.toString(timetable));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        genrateTimeTable(10);
    }
}
