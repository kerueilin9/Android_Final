package com.example.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class mRecycleAdapter_edit extends RecyclerView.Adapter<mRecycleAdapter_edit.ViewHolder>{

    List<mRoomItem> allItem = new ArrayList<>();
    Context context;
    RoomViewModel roomViewModel;
    List<mRoomItem> selectedItem = new ArrayList<>();

    public List<mRoomItem> getSelectedItem() {
        return selectedItem;
    }

    public void setAllItem(Context context, List<mRoomItem> allItem) {
        this.context = context;
        this.allItem = allItem;
        roomViewModel = ViewModelProviders.of((FragmentActivity) context).get(RoomViewModel.class);
    }

    @NonNull
    @Override
    public mRecycleAdapter_edit.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ((MainActivity_edit)context).setTitle(context.getString(R.string.My_Document) + " (" + (selectedItem.size()) + ")");
        ((MainActivity_edit)context).setImageButtonBackground();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_edit, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mRoomItem roomItem = allItem.get(position);
        holder.imageView.setImageURI(Uri.parse(roomItem.getImgResource()));
        holder.textView_title.setText(String.valueOf(roomItem.getTitle()));

        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(context.getApplicationContext(), String.valueOf(roomItem.getId()), Toast.LENGTH_SHORT).show();
            if(holder.checkBox.isChecked()){
                if (selectedItem.size() != 0){
                    selectedItem.remove(removeItem(roomItem.getId()));
                }
                holder.checkBox.setChecked(false);
            } else {
                selectedItem.add(roomItem);
                holder.checkBox.setChecked(true);
            }
            ((MainActivity_edit)context).setImageButtonBackground();
            ((MainActivity_edit)context).setTitle(context.getString(R.string.My_Document) + " (" + (selectedItem.size()) + ")");
        });
    }

    @Override
    public int getItemCount() {
        return allItem.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        TextView textView_title;
        ImageView imageView;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.title_edit);
            imageView = itemView.findViewById(R.id.imageView_edit);
            checkBox = itemView.findViewById(R.id.checkBox);
        }

        @Override
        public void onClick(View view) {
        }
    }

    public int removeItem(int elementToBeDeleted){
        int i;
        for (i = 0; i < selectedItem.size(); i++)
        {
            if (selectedItem.get(i).getId() == elementToBeDeleted) {
                break;
            }
        }
        return i;
    }
}
