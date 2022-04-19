package com.example.android;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MyRecycle extends RecyclerView.Adapter<MyRecycle.WordViewHolder> {

    private LinkedList<String> mRecipeList;
    private LayoutInflater inflater;
    private Context context;

    public MyRecycle(Context context, LinkedList<String> Title){
        this.mRecipeList = Title;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        public TextView textView;
        final MyRecycle mAdapter;

        public WordViewHolder(View itemView, MyRecycle adapter) {
            super(itemView);
            textView = itemView.findViewById(R.id.Title);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public MyRecycle.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mlayout = inflater.inflate(R.layout.content_item, parent, false);
        return new WordViewHolder(mlayout, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String txList = mRecipeList.get(position);
        holder.textView.setText(txList);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}