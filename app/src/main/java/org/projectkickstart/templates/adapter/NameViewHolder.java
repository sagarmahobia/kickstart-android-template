package org.projectkickstart.templates.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.sagar.templates.databinding.NameListItemBinding;

public class NameViewHolder extends RecyclerView.ViewHolder {

    private NameListItemBinding binding;

    NameViewHolder(NameListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public NameListItemBinding getBinding() {
        return binding;
    }

    public void bindTo(NameModel nameModel) {
        binding.setModel(nameModel);
    }
}
