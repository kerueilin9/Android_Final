package com.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Button button_Home, button_Page1, button_Page2, button_popup;
    TextView textView1, textView2, textView3;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        button_Home = findViewById(R.id.button2);
        button_Page1 = findViewById(R.id.button3);
        button_Page2 = findViewById(R.id.button4);
        button_popup = findViewById(R.id.button);

        textView1 = findViewById(R.id.textView4);
        textView2 = findViewById(R.id.textView5);
        textView3 = findViewById(R.id.textView6);

        registerForContextMenu(textView1);
        registerForContextMenu(textView3);
        registerForContextMenu(textView2);

        button_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity_home.class);
                intent.putExtra("key", "12");
                MainActivity.this.startActivity(intent);
            }
        });

        button_Page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity_page1.class);
                MainActivity.this.startActivity(intent);
            }
        });

        button_Page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity_page2.class);
                MainActivity.this.startActivity(intent);
            }
        });

        button_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, button_popup);
                popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.item1:
                                display("item1");
                                return true;
                            case R.id.item2:
                                display("item2");
                                return true;
                            case R.id.item3:
                                display("item3");
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                display("item1");
                return true;
            case R.id.item2:
                display("item2");
                return true;
            case R.id.item3:
                display("item3");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                display("item1");
                return true;
            case R.id.item2:
                display("item2");
                return true;
            case R.id.item3:
                display("item3");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void display(String x){
        Toast.makeText(getApplication(), x, Toast.LENGTH_SHORT).show();
    }
}