package org.projectkickstart.templates.fragment;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class InfoFragmentViewModel extends ViewModel {


    private CompositeDisposable disposable = new CompositeDisposable();
    private InfoFragmentModel fragmentModel = new InfoFragmentModel();

    InfoFragmentViewModel() {
    }

    InfoFragmentModel getFragmentModel() {
        return fragmentModel;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
