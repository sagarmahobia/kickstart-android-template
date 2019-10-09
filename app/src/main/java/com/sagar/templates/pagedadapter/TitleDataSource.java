package com.sagar.templates.pagedadapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;

import com.sagar.templates.responsemodel.PagingState;

import io.reactivex.disposables.CompositeDisposable;

public class TitleDataSource extends ItemKeyedDataSource<Integer, TitleModel> {
    private CompositeDisposable disposable;

    private MutableLiveData<PagingState> stateLiveData;

    private int page = 0;

    TitleDataSource(
            @NonNull CompositeDisposable disposable,
            @NonNull MutableLiveData<PagingState> stateLiveData
    ) {

        this.disposable = disposable;
        this.stateLiveData = stateLiveData;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<TitleModel> callback) {
        stateLiveData.postValue(PagingState.loading());
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<TitleModel> callback) {
        stateLiveData.postValue(PagingState.loading());
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<TitleModel> callback) {
        // do nothing
    }

    @NonNull
    @Override
    public Integer getKey(@NonNull TitleModel item) {
        return item.getId();
    }
}
