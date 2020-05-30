package org.projectkickstart.templates.mvvmpagedadapter;

import androidx.recyclerview.widget.RecyclerView;

import org.projectkickstart.templates.databinding.EmployeeListItemBinding;

import lombok.Getter;

/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    @Getter
    private EmployeeListItemBinding binding;

    EmployeeViewHolder(EmployeeListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void bindTo(EmployeeModel employeeModel) {
        binding.setModel(employeeModel);
    }
}
