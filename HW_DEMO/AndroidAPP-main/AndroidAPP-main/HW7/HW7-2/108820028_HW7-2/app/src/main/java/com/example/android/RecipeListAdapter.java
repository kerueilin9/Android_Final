package com.example.android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>  {
    private final LinkedList<String> mRecipeList;
    private final LinkedList<String> mDescriptionList;
    private LayoutInflater mInflater;

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView listItemTitleView;
        public final TextView listItemContentView;
        final RecipeListAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            listItemTitleView = itemView.findViewById(R.id.listItemTitle);
            listItemContentView = itemView.findViewById(R.id.listItemContent);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            Intent intent = new Intent(view.getContext(), DescriptionActivity.class);
            String message = String.valueOf(mPosition);
            intent.putExtra("com.example.android.extra.MESSAGE", message);
            view.getContext().startActivity(intent);
        }
    }

    public RecipeListAdapter(Context context, LinkedList<String> recipeList, LinkedList<String> descriptionList) {
        mInflater = LayoutInflater.from(context);
        mRecipeList = recipeList;
        mDescriptionList = descriptionList;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.listItemTitleView.setText(mRecipeList.get(position));
        holder.listItemContentView.setText(mDescriptionList.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}