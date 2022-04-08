package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edt = findViewById(R.id.editTextTextPersonName);
        TextView tx = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int num = Integer.parseInt(edt.getText().toString());
                //Toast.makeText(getApplication(),"Error",Toast.LENGTH_LONG).show();
                String str = edt.getText().toString();
                boolean x = edt.getText().toString().matches("");
                //Toast.makeText(getApplication(),str,Toast.LENGTH_LONG).show();
//                tx.setText(String.valueOf(num));
                if (x){
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_LONG).show();
                }
                tx.setText(str);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.first:
                Toast.makeText(getApplication(), "first", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sacend:
                Toast.makeText(getApplication(), "second", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.third:
                Toast.makeText(getApplication(), "third", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}