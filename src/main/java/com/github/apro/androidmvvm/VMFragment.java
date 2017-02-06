package com.github.apro.androidmvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class VMFragment<T> extends Fragment {
    protected com.github.apro.androidmvvm.StateFragment<T> stateFragment;
    protected T viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //noinspection unchecked
        stateFragment = (com.github.apro.androidmvvm.StateFragment<T>) getChildFragmentManager()
                .findFragmentByTag(com.github.apro.androidmvvm.StateFragment.TAG);

        if (stateFragment == null) {
            stateFragment = new StateFragment<>();

            getChildFragmentManager()
                    .beginTransaction()
                    .add(stateFragment, StateFragment.TAG)
                    .commit();
            stateFragment.setViewModel(provideViewModel());
        }
        viewModel = stateFragment.getViewModel();
    }

    public abstract T provideViewModel();
}
