package com.example.umprojectadmin;

import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GlobalValApp extends Application {

    private ArrayList<Donation> donationList;

    public ArrayList<Donation> getDonationList() {
        return donationList;
    }

    public void setDonationList(ArrayList<Donation> donationList) {
        this.donationList = donationList;
    }

    public void addData(Donation donation) {
        donationList.add(donation);
    }

    @Override
    public void onCreate() {

        getgetDonationList();
        super.onCreate();
    }



    public ArrayList<Donation> getgetDonationList() {
        try {
            donationList = new ArrayList<>();
            String jsonStr = loadJSONFromAsset();
            JSONObject jjj = new JSONObject(jsonStr);
            JSONArray jsonArray = jjj.getJSONArray("donations");
            Donation donation;

            int a = 1;
            for (int i = 0; i < jsonArray.length(); i++) {
                donation = new Donation();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                donation.setName(jsonObject.getString("name"));
                donation.setAge(Integer.parseInt(jsonObject.getString("age")));
                donation.setAdress(jsonObject.getString("adress"));
                donation.setGrade(jsonObject.getString("grade"));
                donation.setUnbrellaNum(jsonObject.getString("umbrella_num"));
                donationList.add(donation);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return donationList;
    }


    private String loadJSONFromAsset() {
        String jsonData = "";
        try {
            // json 파일에서 데이터 읽어옴
            InputStream is = getAssets().open("jsons/donation_data.json");
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
