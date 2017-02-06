package com.github.apro.androidmvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class VMActivity<T> extends AppCompatActivity {
    protected StateFragment<T> stateFragment;
    protected T viewModel;
    private String stateFragTag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //noinspection unchecked
        stateFragment = (StateFragment<T>) getSupportFragmentManager()
                .findFragmentByTag(StateFragment.TAG);

        if (stateFragment == null) {
            stateFragment = new StateFragment<>();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(stateFragment, StateFragment.TAG)
                    .commit();
            stateFragment.setViewModel(provideViewModel());
        }
        viewModel = stateFragment.getViewModel();
    }

    public abstract T provideViewModel();

}
