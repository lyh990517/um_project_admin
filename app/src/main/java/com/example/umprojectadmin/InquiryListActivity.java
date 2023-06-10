package com.example.umprojectadmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import java.util.ArrayList;

public class InquiryListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry_list);

        listView = (ListView) findViewById(R.id.inquiry_list_view);

        ArrayList<Inquiry> inquiryList = getInquiryList();
        final InquiryAdapter adapter = new InquiryAdapter(this, inquiryList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                final Inquiry inquiry = (Inquiry) adapter.getItem(position);
                Intent intent = new Intent(getApplicationContext(), InquiryDetailActivity.class);
                intent.putExtra("inquiry", inquiry);
                startActivity(intent);
            }
        });

    }

    public ArrayList<Inquiry> getInquiryList() {
        ArrayList<Inquiry> inquiryList = null;
        try {
            inquiryList = new ArrayList<>();
            String jsonStr = loadJSONFromAsset();
            JSONObject jjj = new JSONObject(jsonStr);
            JSONArray jsonArray = jjj.getJSONArray("inquirys");
            Inquiry inquiry;

            int a = 1;
            for (int i = 0; i < jsonArray.length(); i++) {
                inquiry = new Inquiry();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                inquiry.setWriter(jsonObject.getString("writer"));
                inquiry.setTitle(jsonObject.getString("title"));
                inquiry.setContent(jsonObject.getString("content"));
                inquiry.setDate(jsonObject.getString("date"));
                inquiryList.add(inquiry);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return inquiryList;
    }


    private String loadJSONFromAsset() {
        String jsonData = "";
        try {
            // json 파일에서 데이터 읽어옴
            InputStream is = getAssets().open("jsons/inquiry_data.json");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();
            while (line != null){
                buffer.append(line + "\n");
                line = reader.readLine();
            }
            jsonData = buffer.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

}