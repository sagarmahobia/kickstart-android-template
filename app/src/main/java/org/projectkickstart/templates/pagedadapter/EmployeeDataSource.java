package org.projectkickstart.templates.pagedadapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;


import io.reactivex.disposables.CompositeDisposable;

public class EmployeeDataSource extends ItemKeyedDataSource<Integer, EmployeeModel> {

    private CompositeDisposable disposable;
    private MutableLiveData<PagingState> stateLiveData;

    private int page = 0;

    EmployeeDataSource(
            @NonNull CompositeDisposable disposable,
            @NonNull MutableLiveData<PagingState> stateLiveData
    ) {

        this.disposable = disposable;
        this.stateLiveData = stateLiveData;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<EmployeeModel> callback) {
        stateLiveData.postValue(PagingState.loading());
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<EmployeeModel> callback) {
        stateLiveData.postValue(PagingState.loading());
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<EmployeeModel> callback) {
        // do nothing
    }

    @NonNull
    @Override
    public Integer getKey(@NonNull EmployeeModel item) {
        return item.getId();
    }
}
