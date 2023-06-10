package com.example.umprojectadmin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DonationListActivity extends AppCompatActivity {
    ImageButton addBtn;

    ImageButton searchBtn;
    EditText searchText;

    ListView donationListView;

    public ArrayList<Donation> donationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);

        addBtn = (ImageButton) findViewById(R.id.donation_add_btn);
        searchText = (EditText) findViewById(R.id.search_text);
        searchBtn = (ImageButton) findViewById(R.id.search_btn);
        donationListView = (ListView) findViewById(R.id.donation_list_view);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DonationAddActivity.class);
                startActivity(intent);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donationList = ( (GlobalValApp) getApplication() ).getDonationList();
                //int index = donationList.indexOf(searchText.getText());
                //ArrayList<Donation> temp = new ArrayList<>();
                //Donation tempDonation = donationList.get(index);
                ArrayList<Donation> temp = new ArrayList<>();
                temp.add(donationList.get(0));
                final MyAdapter myAdapter = new MyAdapter(getApplicationContext(), temp);
                donationListView.setAdapter(myAdapter);
            }
        });

        donationList = ( (GlobalValApp) getApplication() ).getDonationList();
        final MyAdapter myAdapter = new MyAdapter(this, donationList);
        donationListView.setAdapter(myAdapter);
        donationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                final Donation donation = (Donation) myAdapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), DonationDetailActivity.class);
                intent.putExtra("donation", donation);
                startActivity(intent);
            }
        });

    }



}