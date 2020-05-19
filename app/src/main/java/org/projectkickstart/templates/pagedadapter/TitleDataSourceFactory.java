package org.projectkickstart.templates.pagedadapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;


import org.projectkickstart.templates.responsemodel.PagingState;

import io.reactivex.disposables.CompositeDisposable;

public class TitleDataSourceFactory extends DataSource.Factory<Integer, TitleModel> {

    private CompositeDisposable disposable;
    private MutableLiveData<PagingState> stateLiveData;

    private TitleDataSource dataSource;

    TitleDataSourceFactory(CompositeDisposable disposable,
                           MutableLiveData<PagingState> stateLiveData
    ) {
        this.disposable = disposable;
        this.stateLiveData = stateLiveData;
    }

    @NonNull
    @Override
    public DataSource<Integer, TitleModel> create() {
        dataSource = new TitleDataSource(disposable, stateLiveData);
        return dataSource;
    }

    void invalidate() {
        dataSource.invalidate();
    }
}
