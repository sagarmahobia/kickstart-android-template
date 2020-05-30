package org.projectkickstart.templates;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */

public class BaseViewModel extends ViewModel {

    protected final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
