package com.example.final_project;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModel1 extends ViewModel {
    private MutableLiveData<Integer> n;

    public MutableLiveData<Integer> getN() {
        if(n == null){
            n = new MutableLiveData<>();
            n.setValue(0);
        }
        return n;
    }

    public void addN(int num){
        n.setValue(n.getValue() + num);
    }
}
