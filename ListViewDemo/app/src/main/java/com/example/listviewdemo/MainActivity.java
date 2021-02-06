package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView myListView = findViewById(R.id.myListView);
        ArrayList<String> bts = new ArrayList<String>();
        bts.add("Kim Namjoon");
        bts.add("Kim Seokjin");
        bts.add("Min Yoongi");
        bts.add("Jung Hoseok");
        bts.add("Park Jimin");
        bts.add("Kim Taehyung");
        bts.add("Jeon Jungkook");

        //bridge to connect the array to the list view
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bts);

        //set the arrayadapter to listview
        myListView.setAdapter(arrayAdapter);

        //if clicked on a list item
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               //in our onItemClick method int position specifies the position of item clicked thus using that we can "get" an array item from that position
                //Log.i("Person Selected: ", bts.get(position));
                Toast.makeText(MainActivity.this, bts.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}