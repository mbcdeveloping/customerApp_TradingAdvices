package com.google.example.adinaranayaragh;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.firebase.database.Query;

import java.util.ArrayList;

public class MyAdapter extends FirebaseRecyclerAdapter<MyAdapter.ViewHolder, MyItem> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemTitleTextView;
        TextView itemTitleTextView2;
        TextView buyBellowTextView;
        TextView buyDateTextView;
        TextView buyTareg1TextView;
        TextView buyTareg2TextView;
        TextView buyStopLossTextView;
        TextView sellAboveTextView;
        TextView sellDateTextView;
        TextView sellTarget1TextView;
        TextView sellTarget2TextView;
        TextView sellStopLossTextView;

        public ViewHolder(View view) {
            super(view);
            itemTitleTextView = view.findViewById(R.id.ItemTitle);
            itemTitleTextView2 = view.findViewById(R.id.ItemTitle2);
            buyBellowTextView = view.findViewById(R.id.buyBellow);
            buyDateTextView = view.findViewById(R.id.buyDate);
            buyTareg1TextView  = view.findViewById(R.id.buyTarget1);
            buyTareg2TextView = view.findViewById(R.id.buyTarget2);
            buyStopLossTextView = view.findViewById(R.id.buyStoploss);
            sellAboveTextView = view.findViewById(R.id.sellAbove);
            sellDateTextView = view.findViewById(R.id.sellDate);
            sellTarget1TextView = view.findViewById(R.id.sellTarget1);
            sellTarget2TextView = view.findViewById(R.id.sellTarget2);
            sellStopLossTextView = view.findViewById(R.id.sellStoploss);

        }
    }

    public MyAdapter(Query query, @Nullable ArrayList<MyItem> items,
                     @Nullable ArrayList<String> keys) {
        super(query, items, keys);
    }

    @Override public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        MyItem object = getItem(position);
        holder.itemTitleTextView.setText(object.getTitleOfItem());
        holder.itemTitleTextView2.setText(object.getTitleOfItem());
        holder.buyDateTextView.setText(object.getBuy().getDate());
        holder.buyBellowTextView.setText(object.getBuy().getBuyBellow());
        holder.buyTareg1TextView.setText(object.getBuy().getTarget1());
        holder.buyTareg2TextView.setText(object.getBuy().getTarget2());
        holder.buyStopLossTextView.setText(object.getBuy().getStoploss());
        holder.sellDateTextView.setText(object.getSell().getDate());
        holder.sellAboveTextView.setText(object.getSell().getSellAbove());
        holder.sellTarget1TextView.setText(object.getSell().getTarget1());
        holder.sellTarget2TextView.setText(object.getSell().getTarget2());
        holder.sellStopLossTextView.setText(object.getSell().getStoploss());


    }

    @Override protected void itemAdded(MyItem item, String key, int position) {
        Log.d("MyAdapter", "Added a new item to the adapter.");
    }

    @Override protected void itemChanged(MyItem oldItem, MyItem newItem, String key, int position) {
        Log.d("MyAdapter", "Changed an item.");
    }

    @Override protected void itemRemoved(MyItem item, String key, int position) {
        Log.d("MyAdapter", "Removed an item from the adapter.");
    }

    @Override protected void itemMoved(MyItem item, String key, int oldPosition, int newPosition) {
        Log.d("MyAdapter", "Moved an item.");
    }
}