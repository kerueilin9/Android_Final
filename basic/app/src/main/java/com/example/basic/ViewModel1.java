package com.example.basic;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModel1 extends ViewModel {
    private MutableLiveData<Integer> Num;

    public MutableLiveData<Integer> getNum(){
        if (Num == null){
            Num = new MutableLiveData<>();
            Num.setValue(0);
        }
        return Num;
    }
}
