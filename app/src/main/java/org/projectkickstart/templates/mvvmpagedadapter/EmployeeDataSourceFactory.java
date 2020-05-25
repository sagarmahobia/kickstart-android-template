package org.projectkickstart.templates.mvvmpagedadapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import org.projectkickstart.templates.mvvmpagedadapter.PagingState;

import io.reactivex.disposables.CompositeDisposable;

public class EmployeeDataSourceFactory extends DataSource.Factory<Integer, EmployeeModel> {

    private CompositeDisposable disposable;
    private MutableLiveData<PagingState> stateLiveData;

    private EmployeeDataSource dataSource;

    public EmployeeDataSourceFactory(CompositeDisposable disposable,
                                     MutableLiveData<PagingState> stateLiveData
    ) {
        this.disposable = disposable;
        this.stateLiveData = stateLiveData;
    }

    @NonNull
    @Override
    public DataSource<Integer, EmployeeModel> create() {
        dataSource = new EmployeeDataSource(disposable, stateLiveData);
        return dataSource;
    }

    public void invalidate() {
        dataSource.invalidate();
    }
}
