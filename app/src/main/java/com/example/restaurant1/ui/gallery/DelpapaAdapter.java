package com.example.restaurant1.ui.gallery;


import android.content.Context;
import android.util.Log;
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

public class DelpapaAdapter extends RecyclerView.Adapter<DelpapaAdapter.DelpapaViewHoler> {
    Context context;
    List<Delpapa> data;

    public DelpapaAdapter(List<Delpapa> data,Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public DelpapaViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_slider, parent, false);
        return new DelpapaViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DelpapaViewHoler holder, int position) {
        Delpapa delpapa = data.get(position);

        Log.d("fggfgf", delpapa.getImg());

        Glide.with(context)
                .load(delpapa.getImg())
                .into(holder.imageViewG);

    }
    public void setData(  List<Delpapa> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class DelpapaViewHoler extends RecyclerView.ViewHolder {
        public ImageView imageViewG;
        public TextView TVslider;
        public DelpapaViewHoler(@NonNull View itemView) {
            super(itemView);
            imageViewG = (ImageView) itemView.findViewById(R.id.imageViewG);
            TVslider = (TextView) itemView.findViewById(R.id.TVslider);
        }
    }
}
