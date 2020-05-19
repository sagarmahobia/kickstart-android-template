package org.projectkickstart.templates.fragment;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class ProfileFragmentViewModel extends ViewModel {


    private CompositeDisposable disposable = new CompositeDisposable();
    private ProfileFragmentModel fragmentModel = new ProfileFragmentModel();

    ProfileFragmentViewModel() {
    }

    ProfileFragmentModel getFragmentModel() {
        return fragmentModel;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
