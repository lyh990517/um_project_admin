package com.example.umprojectadmin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InquiryDetailActivity extends AppCompatActivity {

    TextView writerText;
    TextView titleText;
    TextView contentText;
    TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry_detail);

        writerText = (TextView) findViewById(R.id.writer);
        titleText = (TextView) findViewById(R.id.title);
        contentText = (TextView) findViewById(R.id.content);
        dateText = (TextView) findViewById(R.id.date);


        Intent intent = getIntent();
        Inquiry inquiry = (Inquiry) intent.getSerializableExtra("inquiry");
        writerText.setText(inquiry.getWriter());
        titleText.setText(inquiry.getTitle());
        contentText.setText(inquiry.getContent());
        dateText.setText(inquiry.getDate());
    }


}