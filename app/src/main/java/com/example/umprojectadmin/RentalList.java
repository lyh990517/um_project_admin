package com.example.umprojectadmin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RentalList extends AppCompatActivity {

    private List<Rental> listRental;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_list);

        listRental = generateRentalList();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RentalRecyclerAdapter rentalRecyclerAdapter = new RentalRecyclerAdapter(listRental);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rentalRecyclerAdapter);
    }

    private List<Rental> generateRentalList(){
        List<Rental> rentalList = new ArrayList<>();
        rentalList.add(new Rental("김지훈","umb_3",1,"대여","2023/05/21","09:31"));
        rentalList.add(new Rental("윤재욱","umb_45",2,"대여","2023/06/02","19:25"));
        rentalList.add(new Rental("김소영","umb_71",3,"대여","2023/05/09","06:58"));
        rentalList.add(new Rental("김장현","umb_33",4,"대여","2023/05/30","08:12"));
        rentalList.add(new Rental("이윤호","umb_25",5,"대여","2023/06/01","18:12"));
        rentalList.add(new Rental("서성준","umb_5",6,"대여","2023/04/30","20:47"));
        return rentalList;
    }
}

