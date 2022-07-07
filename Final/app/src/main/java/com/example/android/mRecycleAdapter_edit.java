package com.example.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import java.util.LinkedList;
import java.util.List;

public class mRecycleAdapter_edit extends RecyclerView.Adapter<mRecycleAdapter_edit.ViewHolder> {

    List<mRoomItem> allItem = new ArrayList<>();
    Context context;
    RoomViewModel roomViewModel;
    List<mRoomItem> selectedItem = new ArrayList<>();
    List<Boolean> checked = new ArrayList<>();

    public List<mRoomItem> getSelectedItem() {
        return selectedItem;
    }

    public void setAllItem(Context context, List<mRoomItem> allItem) {
        this.context = context;
        this.allItem = allItem;
        for (int i = 0; i < allItem.size(); i++){
            checked.add(false);
        }
        roomViewModel = ViewModelProviders.of((FragmentActivity) context).get(RoomViewModel.class);
    }

    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        TextView textView_title;
        ImageView imageView;
        CheckBox checkBox;


        public ViewHolder(View itemView) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.title_edit);
            imageView = itemView.findViewById(R.id.imageView_edit);
            checkBox = itemView.findViewById(R.id.checkBox);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            mRoomItem roomItem = allItem.get(position);
            if(checkBox.isChecked()){
                if (selectedItem.size() != 0){
                    selectedItem.remove(removeItem(roomItem.getId()));
                }
                checkBox.setChecked(false);
                checked.set(position, false);
            } else {
                selectedItem.add(roomItem);
                checkBox.setChecked(true);
                checked.set(position, true);
            }
            ((MainActivity_edit)context).setImageButtonBackground();
            ((MainActivity_edit)context).setTitle(context.getString(R.string.My_Document) + " (" + (selectedItem.size()) + ")");
        }

    }

    @NonNull
    @Override
    public mRecycleAdapter_edit.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ((MainActivity_edit)context).setTitle(context.getString(R.string.My_Document) + " (" + (selectedItem.size()) + ")");
        ((MainActivity_edit)context).setImageButtonBackground();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_edit, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mRoomItem roomItem = allItem.get(position);
        Boolean checkedItem = checked.get(position);
        holder.imageView.setImageURI(Uri.parse(roomItem.getImgResource()));
        holder.textView_title.setText(String.valueOf(roomItem.getTitle()));
        holder.checkBox.setChecked(checkedItem);
    }

    @Override
    public int getItemCount() {
        return allItem.size();
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


