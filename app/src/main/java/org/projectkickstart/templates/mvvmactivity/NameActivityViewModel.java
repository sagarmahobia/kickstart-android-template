package org.projectkickstart.templates.mvvmactivity;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class NameActivityViewModel extends ViewModel {

    private final CompositeDisposable disposable = new CompositeDisposable();

    private NameActivityModel activityModel = new NameActivityModel();
    ;

    public NameActivityViewModel() {
    }

    public NameActivityModel getActivityModel() {
        return activityModel;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
