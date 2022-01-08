package com.example.quiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRv extends RecyclerView.Adapter<AdapterRv.ViewHolder> {

    private ArrayList<ItemModel> dataItem;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textHead;
        TextView textSubhead;
        ImageView imageIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textHead = itemView.findViewById(R.id.tvname);
            textSubhead = itemView.findViewById(R.id.tvnumber);
            imageIcon = itemView.findViewById(R.id.imagelist);
        }
    }

    AdapterRv(ArrayList<ItemModel> dataItem){
        this.dataItem = dataItem;

    }
    @NonNull
    @Override
    public AdapterRv.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRv.ViewHolder holder, int position) {

        TextView texthead = holder.textHead;
        TextView textSubhead = holder.textSubhead;
        ImageView imageicon = holder.imageIcon;

        texthead.setText(dataItem.get(position).getName());
        textSubhead.setText(dataItem.get(position).getType());
        imageicon.setImageResource(dataItem.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }


}
