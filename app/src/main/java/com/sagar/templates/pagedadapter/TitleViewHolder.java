package com.sagar.templates.pagedadapter;

import androidx.recyclerview.widget.RecyclerView;

import com.sagar.templates.databinding.TitleListItemBinding;

public class TitleViewHolder extends RecyclerView.ViewHolder {

    private TitleListItemBinding binding;

    TitleViewHolder(TitleListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public TitleListItemBinding getBinding() {
        return binding;
    }

    public void bindTo(TitleModel titleModel) {
        binding.setModel(titleModel);
    }
}
