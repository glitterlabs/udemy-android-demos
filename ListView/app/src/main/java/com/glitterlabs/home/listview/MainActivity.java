package com.glitterlabs.home.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView friendsList = (ListView) findViewById(R.id.friendsList);
        final ArrayList<String> myfriends = new ArrayList<String>(asList("ABC", "PQR", "LMN", "XYZ"));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myfriends);
        friendsList.setAdapter(arrayAdapter);
        friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Hello " + myfriends.get(position),Toast.LENGTH_LONG).show();
            }
        });

        /*ListView myListView = (ListView)findViewById(R.id.myListView);
        final ArrayList<String> myFamily = new ArrayList<String>();
        myFamily.add("XYZ");
        myFamily.add("ABC");
        myFamily.add("PQR");
        myFamily.add("LMN");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);
        myListView.setAdapter(arrayAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){

                Log.i("Person tapped:", myFamily.get(position));

            }
        });*/
    }
}
