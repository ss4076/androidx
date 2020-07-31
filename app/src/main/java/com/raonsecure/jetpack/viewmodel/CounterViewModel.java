package com.raonsecure.jetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    // LiveData 사용
    public MutableLiveData<Integer> count = new MutableLiveData<>();

    public CounterViewModel() {

        count.setValue(0);
    }

    public void increase() {

        count.setValue(count.getValue() + 1);
    }

    public void decrease() {

        count.setValue(count.getValue() - 1);
    }

}
