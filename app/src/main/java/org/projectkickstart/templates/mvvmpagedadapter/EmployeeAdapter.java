package org.projectkickstart.templates.mvvmpagedadapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import org.projectkickstart.templates.databinding.EmployeeListItemBinding;

public class EmployeeAdapter extends PagedListAdapter<EmployeeModel, EmployeeViewHolder> {

    private static DiffUtil.ItemCallback<EmployeeModel> itemCallback = new DiffUtil.ItemCallback<EmployeeModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull EmployeeModel oldItem, @NonNull EmployeeModel newItem) {
            return oldItem.getId() == newItem.getId();//TODO
        }

        @Override
        public boolean areContentsTheSame(@NonNull EmployeeModel oldItem, @NonNull EmployeeModel newItem) {
            return oldItem.getId().equals(newItem.getId());//TODO
        }
    };
    private LayoutInflater inflater;
    private OnItemClickListener clickListener;


/*
    private MutableLiveData<PagingState> pagedListStateLiveData = new MutableLiveData<>();
    private EmployeeDataSourceFactory employeeDataSourceFactory;
    private LiveData<PagedList<PostModel>> pagedListLiveData;

    MutableLiveData<PagingState> getPagedListStateLiveData() {
        return pagedListStateLiveData;
    }

    LiveData<PagedList<EmployeeModel>> getPagedListLiveData() {
        return pagedListLiveData;
    }

    void invalidateListData() {
        feedDataSourceFactory.invalidate();
    }

    void prepare(){
        employeeDataSourceFactory = new EmployeeDataSourceFactory(disposable, pagedListStateLiveData);

        PagedList.Config build = new PagedList.Config.Builder().setPrefetchDistance(20).build();

        pagedListLiveData = new LivePagedListBuilder<>(employeeDataSourceFactory, build).build();
    }

    viewModel.getPagedListStateLiveData().observe(this, pagingState -> {
        if (pagingState.getState() == PagingState.Loading) {
           // binding.swipeRefresh.setRefreshing(true);
           // binding.noFeeds.setVisibility(View.GONE);
           //todo
        } else if (pagingState.getState() == PagingState.Success) {

            // binding.swipeRefresh.setRefreshing(false);
            // binding.recycler.setVisibility(View.VISIBLE);
            //todo

        } else if (pagingState.getState() == PagingState.Error) {
            binding.swipeRefresh.setRefreshing(false);
            //todo
        }
    });

     viewModel.getPagedListLiveData().observe(this, EmployeeModels -> {
            adapter.submitList(employeeModels);
            if (employeeModels.isEmpty()) {
              // binding.recycler.setVisibility(View.GONE);
              // binding.noFeeds.setVisibility(View.VISIBLE);
              
            } else {
              //  binding.recycler.setVisibility(View.VISIBLE);
              //  binding.noFeeds.setVisibility(View.GONE);
                
            }
        });

    @Provides
    //TODO@Scope
    EmployeeAdapter employeeAdapter() {
        return new ShowAdapter();
    }
*/

    public EmployeeAdapter() {
        super(itemCallback);
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        EmployeeListItemBinding binding = EmployeeListItemBinding.inflate(inflater, parent, false);
        return new EmployeeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        final EmployeeModel model = getItem(position);

        holder.getBinding().setModel(model);
        holder.bindTo(model);

        holder.itemView.setOnClickListener(view -> {
            if (clickListener != null) {
                clickListener.onClick(model);
            }
        });
    }

    public interface OnItemClickListener {
        void onClick(EmployeeModel employeeModel);
    }
}

