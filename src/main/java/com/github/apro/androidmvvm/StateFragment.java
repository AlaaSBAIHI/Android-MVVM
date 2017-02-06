package com.github.apro.androidmvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public final class StateFragment<T> extends Fragment {
    public static final String TAG = StateFragment.class.getSimpleName();

    private T viewModel;
    private Class<T> clazz;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public String getGenTag() {
        return clazz.getSimpleName() + ":" +
                getClass().getSimpleName();
    }

    public T getViewModel() {
        return viewModel;
    }

    public void setViewModel(T viewModel) {
        this.viewModel = viewModel;
    }
}
