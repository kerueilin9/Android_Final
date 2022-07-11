package com.example.android.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.DB.mRoomItem;
import com.example.android.DB.mRoomViewModel;
import com.example.android.R;

import java.util.ArrayList;
import java.util.List;

public class main_adapter extends RecyclerView.Adapter<main_adapter.WordViewHolder> {

    private List<mRoomItem> allItem = new ArrayList<>();
    private Context context;
    mRoomViewModel roomViewModel;

    public void setAllItem(Context context, List<mRoomItem> allItem) {
        this.context = context;
        this.allItem = allItem;
        roomViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(mRoomViewModel.class);
    }

    public void insertDB(mRoomItem item) {
        roomViewModel.insertR(item);
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder
                implements View.OnClickListener, View.OnLongClickListener {

        public TextView title;
        public TextView content;
        public TextView time;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_item);
            content = itemView.findViewById(R.id.content_item);
            time = itemView.findViewById(R.id.time_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
           return false;
        }
    }


    @NonNull
    @Override
    public main_adapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull main_adapter.WordViewHolder holder, int position) {
        mRoomItem roomItem = allItem.get(position);
        holder.title.setText(roomItem.getTitle());
        holder.content.setText(roomItem.getContent());
        holder.time.setText(Long.toString(roomItem.getTime()));
    }

    @Override
    public int getItemCount() {
        return allItem.size();
    }
}
