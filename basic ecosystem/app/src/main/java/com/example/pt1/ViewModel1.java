package com.example.pt1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModel1 extends ViewModel {
    private MutableLiveData<Integer>num;

    public MutableLiveData<Integer>getNum(){
        if (num == null){
            num = new MutableLiveData<>();
            num.setValue(0);
        }
        return num;
    }

    public void add(int x){
        num.setValue(num.getValue() + x);
        if (num.getValue()<0) {
            num.setValue(0);
        }
    }
}
