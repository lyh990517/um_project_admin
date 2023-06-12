package com.example.umprojectadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReturnRecyclerAdapter extends RecyclerView.Adapter<ReturnRecyclerAdapter.ViewHolder> {

    private List<Rental> returnList;

    public ReturnRecyclerAdapter(List<Rental> returnList) {
        this.returnList = returnList;
    }

    @NonNull
    @Override
    public ReturnRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.return_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rental rental = returnList.get(position);
        holder.rtn_name.setText(rental.getRent_name());
        holder.rtn_umb.setText(rental.getRent_umb());
        holder.rtn_num.setText(String.valueOf(rental.getRent_num()));
        holder.rtn_state.setText(rental.getRent_state());
        holder.rtn_date.setText(rental.getRent_date());
        holder.rtn_time.setText(rental.getRent_time());
    }

    @Override
    public int getItemCount() {
        return returnList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView rtn_name;
        public TextView rtn_umb;
        public TextView rtn_num;
        public TextView rtn_state;
        public TextView rtn_date;
        public TextView rtn_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rtn_name = itemView.findViewById(R.id.rtn_name);
            rtn_umb = itemView.findViewById(R.id.rtn_umb);
            rtn_num = itemView.findViewById(R.id.rtn_num);
            rtn_state = itemView.findViewById(R.id.text_rtn_state);
            rtn_date = itemView.findViewById(R.id.text_rtn_date);
            rtn_time = itemView.findViewById(R.id.text_rtn_time);
        }
    }
}

