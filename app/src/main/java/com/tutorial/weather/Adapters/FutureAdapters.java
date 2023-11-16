package com.tutorial.weather.Adapters;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tutorial.weather.Domains.FutureDomain;
import com.tutorial.weather.Domains.Hourly;
import com.tutorial.weather.R;

import java.util.ArrayList;

public class FutureAdapters extends RecyclerView.Adapter<FutureAdapters.viewholder> {
    ArrayList<FutureDomain> items;
    Context context;

    public FutureAdapters(ArrayList<FutureDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FutureAdapters.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.viewholder_future,
                parent,
                false
        );

        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.dayTxt.setText(items.get(position).getDay());
        holder.statusTxt.setText(items.get(position).getStatus());
        holder.highTxt.setText(items.get(position).getHighTemp()+"°");
        holder.lowTxt.setText(items.get(position).getLowTemp()+"°");

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(
                        items.get(position).getPicPath(),
                        "drawable",
                        holder.itemView.getContext().getPackageName()
                );

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView dayTxt, statusTxt, highTxt, lowTxt;
        ImageView pic;


        public viewholder(@NonNull View itemView) {
            super(itemView);

            dayTxt = itemView.findViewById(R.id.dayTxt);
            statusTxt = itemView.findViewById(R.id.statusTxt);

            highTxt = itemView.findViewById(R.id.highTxt);
            lowTxt = itemView.findViewById(R.id.lowTxt);

            pic = itemView.findViewById(R.id.pic);
        }
    }
}
