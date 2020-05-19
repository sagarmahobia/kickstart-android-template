package org.projectkickstart.templates.fragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

@ProfileFragmentScope
public class ProfileFragmentViewModelFactory implements ViewModelProvider.Factory {


    @Inject
    ProfileFragmentViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProfileFragmentViewModel.class)) {
            return (T) new ProfileFragmentViewModel();
        } else {
            throw new IllegalArgumentException("Can not find view model class " + ProfileFragmentViewModel.class.getName());
        }
    }
}
