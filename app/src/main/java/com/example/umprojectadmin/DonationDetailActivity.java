package com.example.umprojectadmin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DonationDetailActivity extends AppCompatActivity {

    TextView nameText;
    TextView ageText;
    TextView adressText;
    TextView gradeText;
    TextView umbrellaNumText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_detail);

        nameText = (TextView) findViewById(R.id.name);
        ageText = (TextView) findViewById(R.id.age);
        adressText = (TextView) findViewById(R.id.adress);
        gradeText = (TextView) findViewById(R.id.grade);
        umbrellaNumText = (TextView) findViewById(R.id.umbrella_num);

        Intent intent = getIntent();
        Donation donation = (Donation) intent.getSerializableExtra("donation");

        nameText.setText(donation.getName());
        ageText.setText(Integer.toString(donation.getAge()));
        adressText.setText(donation.getAdress());
        gradeText.setText(donation.getGrade());
        umbrellaNumText.setText(donation.getUnbrellaNum());
    }


}