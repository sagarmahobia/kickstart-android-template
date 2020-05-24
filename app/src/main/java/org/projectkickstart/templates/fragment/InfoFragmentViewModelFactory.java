package org.projectkickstart.templates.fragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

@InfoFragmentScope
public class InfoFragmentViewModelFactory implements ViewModelProvider.Factory {


    @Inject
    InfoFragmentViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(InfoFragmentViewModel.class)) {
            return (T) new InfoFragmentViewModel();
        } else {
            throw new IllegalArgumentException("Can not find view model class " + InfoFragmentViewModel.class.getName());
        }
    }
}

/*

@ContributesAndroidInjector(modules = {InfoFragmentModule.class})
@InfoFragmentScope
abstract InfoFragment bindInfoFragment();


*/