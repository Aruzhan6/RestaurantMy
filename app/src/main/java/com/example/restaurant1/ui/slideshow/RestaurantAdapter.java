package com.example.restaurant1.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restaurant1.R;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    Context context;
    List<Restaurant> data;

    public RestaurantAdapter(List<Restaurant> data, Context context) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_res, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant restaurant = data.get(position);

        Glide.with(context)
                .load(restaurant.getImage_id())
                .into(holder.imageViewRes);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Restaurant> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewRes;
        public TextView TV;
        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewRes = (ImageView) itemView.findViewById(R.id.imageViewRes);
            TV = (TextView) itemView.findViewById(R.id.TV);

        }
    }
}
