package com.example.hw7_2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipesRecycle extends RecyclerView.Adapter<RecipesRecycle.WordViewHolder> {

    private LinkedList<Integer> mRecipeImage;
    private LinkedList<String> mRecipeList;
    private LinkedList<String> mRecipeList1;
    private LayoutInflater inflater;
    private Context context;

    public RecipesRecycle(Context context, LinkedList<String> Title, LinkedList<String> Content, LinkedList<Integer> Image){
        this.mRecipeList = Title;
        this.mRecipeList1 = Content;
        this.mRecipeImage = Image;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        public TextView textView;
        public TextView textView1;
        public ImageView imagePng;
        final RecipesRecycle mAdapter;

        public WordViewHolder(View itemView, RecipesRecycle adapter) {
            super(itemView);
            textView = itemView.findViewById(R.id.Title);
            textView1 = itemView.findViewById(R.id.content);
            imagePng = itemView.findViewById(R.id.imageView);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int mposition = getLayoutPosition();
            Intent intent = null;
            if (mposition == 0){
                intent = new Intent(context, MainActivity_recipe1.class);
            } else if (mposition == 1){
                intent = new Intent(context, MainActivity_recipe2.class);
            } else if (mposition == 2){
                intent = new Intent(context, MainActivity_recipe3.class);
            } else if (mposition == 3){
                intent = new Intent(context, MainActivity_recipe4.class);
            } else if (mposition == 4){
                intent = new Intent(context, MainActivity_recipe5.class);
            } else {
                intent = new Intent(context, MainActivity_recipe6.class);
            }
            context.startActivity(intent);

        }
    }

    @Override
    public RecipesRecycle.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mlayout = inflater.inflate(R.layout.recipes_list, parent, false);
        return new WordViewHolder(mlayout, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String txList = mRecipeList.get(position);
        String txList1 = mRecipeList1.get(position);
        Integer image = mRecipeImage.get(position);
        holder.textView.setText(txList);
        holder.textView1.setText(txList1);
        holder.imagePng.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}
