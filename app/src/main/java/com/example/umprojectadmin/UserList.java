package com.example.umprojectadmin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {
    private List<User> listUser;

    public UserList() {
        // 기본 생성자
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);

        listUser = generateUserList();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserRecyclerAdapter userRecyclerAdapter = new UserRecyclerAdapter(listUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userRecyclerAdapter);

        userRecyclerAdapter.setOnItemClickListener(new UserRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User user) {
                Intent intent = new Intent(UserList.this, UserDetail.class);
                intent.putExtra("userName", user.getName());
                startActivity(intent);
            }

            @Override
            public void onDetailClick(User user) {
                Intent intent = new Intent(UserList.this, UserDetail.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }


    // 사용자 데이터 생성
    private List<User> generateUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("김지훈", 28, "경기도 의정부시", "SVIP", 3, R.drawable.jihoon));
        userList.add(new User("윤재욱", 25, "강원도 철원군", "VVIP", 1, R.drawable.wook));
        userList.add(new User("김소영", 23, "서울시", "RVIP", 0, R.drawable.yeong));
        userList.add(new User("김장현", 28, "인천광역시 강화군", "VIP", 0, R.drawable.hyeon));
        userList.add(new User("이윤호", 25, "서울시", "일반", 0, R.drawable.ho));
        userList.add(new User("서성준", 25, "서울시", "일반", 0, R.drawable.jun));
        userList.add(new User("김영진", 30, "서울시", "SVIP", 0, R.drawable.user_img));

        return userList;
    }
}
