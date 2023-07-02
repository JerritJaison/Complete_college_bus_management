package com.example.collegebusmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PassengerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);


        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Bus NO:1");
        list.add("Bus NO:2");
        list.add("Bus NO:3");
        list.add("Bus NO:4");
        list.add("Bus NO:5");
        list.add("Bus NO:6");
        list.add("Bus NO:7");
        list.add("Bus NO:8");
        list.add("Bus NO:9");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus1Activity.class));

                }
                if(position==1){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus2Activity.class));

                }

                if(position==2){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus3Activity.class));

                }

                if(position==3){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus4Activity.class));

                }

                if(position==4){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus5Activity.class));

                }

                if(position==5){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus6Activity.class));

                }

                if(position==6){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus7Activity.class));

                }

                if(position==7){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus8Activity.class));

                }

                if(position==8){
                    //clicked apple

                    startActivity(new Intent(PassengerActivity.this,Passengerbus9Activity.class));

                }
                else{

                }
            }
        });


    }
}