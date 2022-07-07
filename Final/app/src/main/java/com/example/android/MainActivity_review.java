package com.example.android;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModelProviders;

import com.ablanco.zoomy.Zoomy;
import com.example.android.databinding.ActivityMainReviewBinding;


import java.io.File;

public class MainActivity_review extends AppCompatActivity {

    
    ActivityMainReviewBinding binding;
    ImageView imageView;
    Intent intent;
    String image_string, title;
    int id;
    RoomViewModel roomViewModel;
    MenuItem item;
    MenuItem register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_review);
        binding = ActivityMainReviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        imageView = binding.imageViewReview;

        Zoomy.Builder builder = new Zoomy.Builder(this)
                .target(imageView)
                .animateZooming(true)
                .enableImmersiveMode(false)
                .tapListener(v -> {

                });
        builder.register();

        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
        intent = getIntent();
        item = findViewById(R.id.ok_review);

        if(intent.getIntExtra("key_id", 0)!= 0)
        {
            this.id = intent.getIntExtra("key_id", 0);
        }
        if(intent.getStringExtra("key_title")!= null)
        {
            this.title = intent.getStringExtra("key_title");
            this.setTitle(title);
        }
        if(intent.getStringExtra("key_image")!= null)
        {
            this.image_string = intent.getStringExtra("key_image");
            imageView.setImageURI(Uri.parse(image_string));
        }

    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.review_menu, menu);
        register = menu.findItem(R.id.ok_review);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        register.setVisible(true);
        if (resultCode == -1 && requestCode == 101) {
            assert data != null;
            String result = data.getStringExtra("RESULT");
            Uri resultUri;
            if (result != null) {
                resultUri = Uri.parse(result);
                Log.d("Tag", resultUri.toString());
                image_string = result;
                imageView.setImageURI(Uri.parse(result));
            }
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.rename_review:
                AlertDialog.Builder alert_rename = new AlertDialog.Builder(this);
                final EditText editText = new EditText(this);
                FrameLayout container = new FrameLayout(this);
                FrameLayout.LayoutParams params = new  FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.leftMargin = params.rightMargin = this.getResources().getDimensionPixelSize(R.dimen.dialog_margin);
                editText.setSingleLine();
                editText.setLayoutParams(params);
                container.addView(editText);
                alert_rename.setTitle(R.string.rename);
                alert_rename.setView(container);
                alert_rename.setPositiveButton("OK", (dialog, which) -> {
                    mRoomItem roomItem1 = new mRoomItem(image_string, editText.getText().toString());
                    roomItem1.setId(id);
                    roomViewModel.updateR(roomItem1);
                    this.title = editText.getText().toString();
                    this.setTitle(title);
                    //Toast.makeText(context.getApplicationContext(), String.valueOf(roomItem.getId()), Toast.LENGTH_SHORT).show();
                });
                alert_rename.setNegativeButton("CANCEL", (dialogInterface, i) -> {

                });
                alert_rename.show();
                return true;
            case R.id.edit_review:
                Intent intent = new Intent(this, CropperActivity.class);
                intent.putExtra("DATA",image_string);
                startActivityForResult(intent,101);
                return true;
            case R.id.ok_review:
                AlertDialog.Builder alert_ok = new AlertDialog.Builder(this);
                alert_ok.setTitle(R.string.Replace_or_keep_old_files);
                alert_ok.setMessage(R.string.Replace_or_keep_old_files_content);
                alert_ok.setPositiveButton("KEEP", (dialog, which) -> {
                    mRoomItem roomItem = new mRoomItem(image_string, title + "(Edited)");
                    roomViewModel.insertR(roomItem);
                    super.onBackPressed();
                });
                alert_ok.setNegativeButton("REPLACE", (dialog, which) -> {
                    mRoomItem roomItem = new mRoomItem(image_string, title);
                    roomItem.setId(id);
                    roomViewModel.updateR(roomItem);
                    super.onBackPressed();
                });
                alert_ok.setNeutralButton("CANCEL", (dialogInterface, i) -> {});
                alert_ok.show();
                return true;
            case R.id.delete_review:
                AlertDialog.Builder alert_delete = new AlertDialog.Builder(this);
                alert_delete.setIcon(R.drawable.ic_baseline_error_24);
                alert_delete.setTitle(R.string.Delete);
                alert_delete.setMessage(R.string.Delete_this_item);
                alert_delete.setPositiveButton("OK", (dialog, which) -> {
                    mRoomItem roomItem = new mRoomItem();
                    roomItem.setId(id);
                    roomViewModel.deleteR(roomItem);
                    super.onBackPressed();
                });
                alert_delete.setNeutralButton("CANCEL", (dialogInterface, i) -> {});
                alert_delete.show();
                return true;
            case R.id.share_review:
                Uri imgUri = Uri.parse(image_string);
                File temp1 = new File(imgUri.getPath());
                Uri screenshotUri = FileProvider.getUriForFile(this, this.getApplicationContext().getPackageName() + ".provider", temp1);
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                startActivity(Intent.createChooser(sharingIntent, "Share image using"));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void display(String str){
        Toast.makeText(getApplication(), str, Toast.LENGTH_SHORT).show();
    }
}

