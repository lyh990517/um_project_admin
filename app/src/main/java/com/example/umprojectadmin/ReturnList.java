package com.example.umprojectadmin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReturnList extends AppCompatActivity {
    private List<Rental> listReturn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.return_list);

        listReturn = generateReturnList();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ReturnRecyclerAdapter returnRecyclerAdapter = new ReturnRecyclerAdapter(listReturn);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(returnRecyclerAdapter);
    }

    private List<Rental> generateReturnList(){
        List<Rental> returnList = new ArrayList<>();
        returnList.add(new Rental("김지훈","umb_3",1,"반납","2023/05/25","17:30"));
        returnList.add(new Rental("윤재욱","umb_45",2,"반납","2023/06/04","22:01"));
        returnList.add(new Rental("김소영","umb_71",3,"반납","2023/05/15","08:32"));
        returnList.add(new Rental("김장현","umb_33",4,"반납","2023/05/31","09:51"));
        returnList.add(new Rental("이윤호","umb_25",5,"반납","2023/06/03","19:21"));
        returnList.add(new Rental("서성준","umb_5",6,"반납","2023/05/02","12:41"));
        return returnList;
    }
}
