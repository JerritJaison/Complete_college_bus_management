package com.example.collegebusmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityHome extends AppCompatActivity {
    CardView profileCard,busDetails,feesPayment,passList,Query,location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profileCard = findViewById(R.id.profileCard);
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        busDetails = findViewById(R.id.busdetails);
        busDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, BusActivity.class);
                startActivity(intent);
            }
        });

        feesPayment = findViewById(R.id.feespayment);
        feesPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, FeesActivity.class);
                startActivity(intent);
            }
        });

        passList = findViewById(R.id.passlist);
        passList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, PassengerActivity.class);
                startActivity(intent);
            }
        });

        Query = findViewById(R.id.query);
        Query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, QueryActivity.class);
                startActivity(intent);
            }
        });
        location = findViewById(R.id.clothingCard);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, MapsActivity.class);
                startActivity(intent);
            }
        });

    }
}