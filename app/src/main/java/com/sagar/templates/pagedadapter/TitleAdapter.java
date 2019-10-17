package com.sagar.templates.pagedadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.sagar.templates.databinding.TitleListItemBinding;

import java.util.List;

public class TitleAdapter extends PagedListAdapter<TitleModel, TitleViewHolder> {

    private LayoutInflater inflater;
    private List<TitleModel> titleModels;
    private OnItemClickListener clickListener;

    private static DiffUtil.ItemCallback<TitleModel> itemCallback = new DiffUtil.ItemCallback<TitleModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull TitleModel oldItem, @NonNull TitleModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull TitleModel oldItem, @NonNull TitleModel newItem) {
            return oldItem.getId().equals(newItem.getId());//todo
        }
    };

    TitleAdapter() {
        super(itemCallback);
    }

    public void setTitleModels(List<TitleModel> titleModels) {
        this.titleModels = titleModels;
        notifyDataSetChanged();
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        TitleListItemBinding binding = TitleListItemBinding.inflate(inflater, parent, false);

        return new TitleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleViewHolder holder, int position) {
        final TitleModel model = titleModels.get(position);

        holder.getBinding().setModel(model);
        holder.bindTo(model);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    clickListener.onClick(model);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titleModels != null ? titleModels.size() : 0;
    }

    public interface OnItemClickListener {
        void onClick(TitleModel titleModel);
    }
}

