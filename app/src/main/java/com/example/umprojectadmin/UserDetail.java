package com.example.umprojectadmin;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetail extends AppCompatActivity {
    private TextView nameTextView;
    private TextView ageTextView;
    private TextView addressTextView;
    private TextView ratingTextView;
    private TextView warningTextView;
    private ImageView userImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail);

        nameTextView = findViewById(R.id.name);
        ageTextView = findViewById(R.id.age);
        addressTextView = findViewById(R.id.address);
        ratingTextView = findViewById(R.id.rating);
        warningTextView = findViewById(R.id.warning);
        userImageView = findViewById(R.id.image1);

        // 전달된 User 객체 받기
        User user = getIntent().getParcelableExtra("user");

        if (user != null) {
            // User 객체의 데이터를 TextView와 ImageView에 설정
            nameTextView.setText(user.getName());
            ageTextView.setText(String.valueOf(user.getAge()));
            addressTextView.setText(user.getAddress());
            ratingTextView.setText(user.getRating());
            warningTextView.setText(String.valueOf(user.getWarningCount()));
            userImageView.setImageResource(user.getImageResId());
        }
    }
}
