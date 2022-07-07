package com.example.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private ActivityMainBinding binding;
    private String hp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(spnOnItemSelected);

        MainActivity context = this;
        if (LoaderManager.getInstance(this).getLoader(0) != null) {
            LoaderManager.getInstance(this).initLoader(0,null,this);
        }
//        if (getSupportLoaderManager().getLoader(0) != null) {
//            getSupportLoaderManager().initLoader(0, null, this);
//        }
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String url = hp + binding.editTextTextPersonName.getText().toString();
//                //binding.textView2.setText(url);
//
//                InputMethodManager inputManager = (InputMethodManager)
//                        getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (inputManager != null) {
//                    inputManager.hideSoftInputFromWindow(view.getWindowToken(),
//                            InputMethodManager.HIDE_NOT_ALWAYS);
//                }
//
//                // Check the status of the network connection.
//                ConnectivityManager connMgr = (ConnectivityManager)
//                        getSystemService(Context.CONNECTIVITY_SERVICE);
//                NetworkInfo networkInfo = null;
//                if (connMgr != null) {
//                    networkInfo = connMgr.getActiveNetworkInfo();
//                }
//
//                if (networkInfo != null && networkInfo.isConnected()
//                        && url.length() != 0) {
//
//                    Bundle queryBundle = new Bundle();
//                    queryBundle.putString("url", url);
////                    LoaderManager.getInstance(context).restartLoader(0, queryBundle, context);
//                    getSupportLoaderManager().restartLoader(0, queryBundle, this);
//                    binding.textView2.setText("Loading…");
//                }
//                // Otherwise update the TextView to tell the user there is no
//                // connection, or no search term.
//                else {
//                    if (url.length() == 0) {
//                        binding.textView2.setText("");
//                    } else {
//                        binding.textView2.setText("Please check your network connection and try again.");
//                    }
//                }
//            }
//        });
    }

    public void search(View view){
        String url = hp + binding.editTextTextPersonName.getText().toString();
        //binding.textView2.setText(url);

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        // Check the status of the network connection.
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()
                && url.length() != 0) {

            Bundle queryBundle = new Bundle();
            queryBundle.putString("url", url);
            LoaderManager.getInstance(this).restartLoader(0, queryBundle, this);
            //getSupportLoaderManager().restartLoader(0, queryBundle, this);
            binding.textView2.setText("Loading…");
        }
        // Otherwise update the TextView to tell the user there is no
        // connection, or no search term.
        else {
            if (url.length() == hp.length()) {
                binding.textView2.setText("Please enter something");
            } else {
                binding.textView2.setText("Please check your network connection and try again.");
            }
        }
    }

    public AdapterView.OnItemSelectedListener spnOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            hp = adapterView.getItemAtPosition(i).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String url = "";

        if (args != null) {
            url = args.getString("url");
        }

        return new loader(this, url);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try{
            if(data.length() != 0){
                binding.textView2.setText(data);
            } else{
                binding.textView2.setText("The page isn't found");
            }
        } catch (Exception e) {
            binding.textView2.setText("The page isn't found");
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}