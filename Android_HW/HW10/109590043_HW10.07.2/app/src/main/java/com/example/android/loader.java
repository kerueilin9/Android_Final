package com.example.android;


import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class loader extends AsyncTaskLoader<String> {

    private String resource;

    loader(Context context, String content) {
        super(context);
        resource = content;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }
    @Nullable
    @Override
    public String loadInBackground() {
        return GetSourceCode.getSourceCode(resource);

    }
}
