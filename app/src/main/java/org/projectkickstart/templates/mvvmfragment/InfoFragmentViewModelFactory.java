package org.projectkickstart.templates.mvvmfragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */

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

//TODO Add this to your Fragment Provider.

@ContributesAndroidInjector(modules = {InfoFragmentModule.class})
@InfoFragmentScope
abstract InfoFragment bindInfoFragment();

*/