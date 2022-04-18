package com.example.midproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt1;
    EditText edt2;
    Button btn;
    TextView tx1;
    private int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.editTextNumberSigned);
        edt2 = findViewById(R.id.editTextNumberSigned2);
        btn = findViewById(R.id.button);
        tx1 = findViewById(R.id.textView3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt1.getText().toString().matches("")){
                    num1 = 0;
                } else{
                    num1 = Integer.parseInt(String.valueOf(edt1.getText()));
                }
                if (edt2.getText().toString().matches("")){
                    num2 = 0;
                } else{
                    num2 = Integer.parseInt(String.valueOf(edt2.getText()));
                }
                tx1.setText(String.valueOf(num1 + num2));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.result:
                Intent intent = new Intent(this, MainActivity2.class);
                String temp = tx1.getText().toString();
                intent.putExtra("key", temp);
                startActivity(intent);
                return true;
            case R.id.item1:
            case R.id.item2:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}