package org.projectkickstart.templates.mvvmadapter;

import androidx.recyclerview.widget.RecyclerView;

import org.projectkickstart.templates.databinding.NameListItemBinding;

/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */

public class NameViewHolder extends RecyclerView.ViewHolder {

    private NameListItemBinding binding;

    NameViewHolder(NameListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindTo(NameModel nameModel) {
        binding.setModel(nameModel);
    }

    public void handleWith(NameHandler handler) {
        binding.setHandler(handler);
    }
}
