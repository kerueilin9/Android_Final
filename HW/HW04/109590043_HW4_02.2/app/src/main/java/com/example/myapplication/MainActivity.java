package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity<string> extends AppCompatActivity {

    private static final String TAG = "123";
    Button button;
    TextView TextView;
    EditText editText;
    int count = 0;
    string edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        TextView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);

        TextView.setText(Integer.toString(count));

        if (savedInstanceState != null){
            String temp = savedInstanceState.getString("KEY");
            //String temp1 = savedInstanceState.getString("KEY1");
            TextView.setText(temp);
            //editText.setText(temp1);
            count = Integer.valueOf(temp);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                TextView.setText(Integer.toString(count));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY", Integer.toString(count));
        //outState.putString("KEY1", editText.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}


