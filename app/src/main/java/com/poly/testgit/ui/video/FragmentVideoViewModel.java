package com.poly.testgit.ui.video;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmentVideoViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> mText;

    public FragmentVideoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is  fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}