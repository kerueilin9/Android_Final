package com.example.android;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class mRecycleAdapter extends RecyclerView.Adapter<mRecycleAdapter.roomViewHolder> {

    private List<mRoomItem> allItem = new ArrayList<>();
    private Context context;
    RoomViewModel roomViewModel;

    public void setAllItem(Context context, List<mRoomItem> allItem) {
        this.context = context;
        this.allItem = allItem;
        roomViewModel = ViewModelProviders.of((FragmentActivity) context).get(RoomViewModel.class);
    }

    static class roomViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener{

        public TextView textView_title;
        public ImageView imageView;
        public ImageButton imageButton;
        public mRecycleAdapter adapter;

        public roomViewHolder(View itemView, mRecycleAdapter adapter) {
            super(itemView);
            textView_title = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.imageView2);
            imageButton = itemView.findViewById(R.id.imageButton);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            int item_pos = getLayoutPosition();
            mRoomItem roomItem = adapter.allItem.get(item_pos);
            Intent intent = new Intent(adapter.context, MainActivity_review.class);
            intent.putExtra("key_id", adapter.allItem.get(item_pos).getId());
            intent.putExtra("key_title", adapter.allItem.get(item_pos).getTitle());
            intent.putExtra("key_image", adapter.allItem.get(item_pos).getImgResource());
            adapter.context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public mRecycleAdapter.roomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new roomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false), this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onBindViewHolder(@NonNull roomViewHolder holder, int position) {
        mRoomItem roomItem = allItem.get(position);
        holder.imageView.setImageURI(Uri.parse(roomItem.getImgResource()));
        holder.textView_title.setText(String.valueOf(roomItem.getTitle()));

        holder.imageButton.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(context, holder.imageButton);
            popupMenu.inflate(R.menu.item_control_menu);

            popupMenu.setOnMenuItemClickListener(menuItem -> {
                switch (menuItem.getItemId()){
                    case R.id.rename:
                        AlertDialog.Builder alert_rename = new AlertDialog.Builder(context);
                        final EditText editText = new EditText(context);
                        FrameLayout container = new FrameLayout(context);
                        FrameLayout.LayoutParams params = new  FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        params.leftMargin = params.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.dialog_margin);
                        editText.setSingleLine();
                        editText.setLayoutParams(params);
                        container.addView(editText);
                        alert_rename.setTitle(R.string.rename);
                        alert_rename.setView(container);
                        alert_rename.setPositiveButton("OK", (dialog, which) -> {
                            mRoomItem roomItem1 = new mRoomItem(roomItem.getImgResource(), editText.getText().toString());
                            roomItem1.setId(roomItem.getId());
                            roomViewModel.updateR(roomItem1);
                            //Toast.makeText(context.getApplicationContext(), String.valueOf(roomItem.getId()), Toast.LENGTH_SHORT).show();
                        });
                        alert_rename.setNegativeButton("CANCEL", (dialogInterface, i) -> {});
                        alert_rename.show();
                        return true;
                    case R.id.share:
                        Uri imgUri = Uri.parse(roomItem.getImgResource());
                        File temp1 = new File(imgUri.getPath());
                        Uri screenshotUri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", temp1);
                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        sharingIntent.setType("image/jpeg");
                        sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                        context.startActivity(Intent.createChooser(sharingIntent, "Share image using"));
                        return true;
                    case R.id.delete:
                        AlertDialog.Builder alert_delete = new AlertDialog.Builder(context);
                        alert_delete.setIcon(R.drawable.ic_baseline_error_24);
                        alert_delete.setTitle(R.string.Delete_this_item);
                        alert_delete.setMessage(R.string.This_action_will_delete_this_item);
                        alert_delete.setPositiveButton("OK", (dialog, which) -> roomViewModel.deleteR(roomItem));
                        alert_delete.setNegativeButton("CANCEL", (dialogInterface, i) -> {});
                        alert_delete.show();
                        return true;
                    default:
                        return false;
                }
            });

            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return allItem.size();
    }

}
