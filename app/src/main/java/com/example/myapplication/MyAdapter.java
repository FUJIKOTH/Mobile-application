package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Meat;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Meat> meatList;
    private Context context;

    public MyAdapter(List<Meat> meatList, Context context) {
        this.meatList = meatList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_meat_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meat meat = meatList.get(position);
        holder.meatName.setText(meat.getMeat_name());
        holder.meatType.setText(meat.getMeat_type());
        holder.meatOrigin.setText(meat.getMeat_origin());
        holder.meatPrice.setText(String.format("฿%.2f", meat.getMeat_price()));

        Glide.with(context)
                .load(meat.getMeat_image())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.meatImage);

        holder.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("meat_name", meat.getMeat_name());
                intent.putExtra("meat_type", meat.getMeat_type());
                intent.putExtra("meat_origin", meat.getMeat_origin());
                intent.putExtra("meat_price", meat.getMeat_price());
                intent.putExtra("meat_image", meat.getMeat_image());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meatList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView meatName;
        public TextView meatType;
        public TextView meatOrigin;
        public TextView meatPrice;
        public ImageView meatImage;
        public Button orderButton;

        public ViewHolder(View itemView) {
            super(itemView);
            meatName = itemView.findViewById(R.id.meat_name);
            meatType = itemView.findViewById(R.id.meat_type);
            meatOrigin = itemView.findViewById(R.id.meat_origin);
            meatPrice = itemView.findViewById(R.id.meat_price);
            meatImage = itemView.findViewById(R.id.icon);
            orderButton = itemView.findViewById(R.id.order_button);
        }
    }
}
