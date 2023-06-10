package com.example.umprojectadmin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DonationAddActivity extends AppCompatActivity {

    Button insertBtn;
    TextView nameText;
    TextView ageText;
    TextView adressText;
    TextView gradeText;
    TextView umbrellaNumText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_add);

        insertBtn = (Button) findViewById(R.id.insert_btn);
        nameText = (TextView) findViewById(R.id.name);
        ageText = (TextView) findViewById(R.id.age);
        adressText = (TextView) findViewById(R.id.adress);
        gradeText = (TextView) findViewById(R.id.grade);
        umbrellaNumText = (TextView) findViewById(R.id.umbrella_num);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Donation donation = new Donation();

                donation.setName(nameText.getText().toString());
                donation.setAge(Integer.parseInt(ageText.getText().toString()));
                donation.setAdress(adressText.getText().toString());
                donation.setGrade(gradeText.getText().toString());
                donation.setUnbrellaNum(umbrellaNumText.getText().toString());

                GlobalValApp global = (GlobalValApp) getApplicationContext();
                global.addData(donation);

                Intent intent = new Intent(getApplicationContext(), DonationListActivity.class);
                startActivity(intent);
            }
        });
    }
}