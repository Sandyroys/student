package com.example.snackapp.ui.place;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlaceViewModel extends ViewModel {
//ViewModel 类让数据可在发生屏幕旋转等配置更改后继续留存   数据持久化
    private MutableLiveData<String> mText;

    public PlaceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("下单页面");
    }

    public LiveData<String> getText() {
        return mText;
    }
}