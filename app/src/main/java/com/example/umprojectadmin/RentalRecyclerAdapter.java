package com.example.umprojectadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RentalRecyclerAdapter extends RecyclerView.Adapter<RentalRecyclerAdapter.ViewHolder> {

    private List<Rental> rentalList;

    public RentalRecyclerAdapter(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rental_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rental rental = rentalList.get(position);
        holder.rent_name.setText(rental.getRent_name());
        holder.rent_umb.setText(rental.getRent_umb());
        holder.rent_num.setText(String.valueOf(rental.getRent_num()));
        holder.rent_state.setText(rental.getRent_state());
        holder.rent_date.setText(rental.getRent_date());
        holder.rent_time.setText(rental.getRent_time());
    }

    @Override
    public int getItemCount() {
        return rentalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView rent_name;
        public TextView rent_umb;
        public TextView rent_num;
        public TextView rent_state;
        public TextView rent_date;
        public TextView rent_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rent_name = itemView.findViewById(R.id.rent_name);
            rent_umb = itemView.findViewById(R.id.rent_umb);
            rent_num = itemView.findViewById(R.id.rent_num);
            rent_state = itemView.findViewById(R.id.text_rent_state);
            rent_date = itemView.findViewById(R.id.text_rent_date);
            rent_time = itemView.findViewById(R.id.text_rent_time);
        }
    }
}