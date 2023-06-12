package com.example.umprojectadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button usr_list_button = (Button) findViewById(R.id.btn_user_list);
        Button rental_button = (Button) findViewById(R.id.btn_rental_list);
        Button return_button = (Button) findViewById(R.id.btn_return_list);

        usr_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserList.class);
                startActivity(intent);
            }
        });

        rental_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RentalList.class);
                startActivity(intent);
            }
        });

        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReturnList.class);
                startActivity(intent);
            }
        });
    }
}