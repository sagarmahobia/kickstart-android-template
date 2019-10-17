package com.sagar.templates.activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

@NameActivityScope
public class NameActivityViewModelFactory implements ViewModelProvider.Factory {


    @Inject
    NameActivityViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NameActivityViewModel.class)) {
            return (T) new NameActivityViewModel();
        } else {
            throw new IllegalArgumentException("Can not find ViewModel class " + modelClass.getName());
        }
    }
}
//@ContributesAndroidInjector(modules = {NameActivityModule.class})
//@NameActivityScope
//abstract NameActivity bindNameActivity();

