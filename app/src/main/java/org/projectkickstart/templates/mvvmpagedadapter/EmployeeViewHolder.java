package org.projectkickstart.templates.mvvmpagedadapter;

import androidx.recyclerview.widget.RecyclerView;

import org.projectkickstart.templates.databinding.EmployeeListItemBinding;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private EmployeeListItemBinding binding;

    EmployeeViewHolder(EmployeeListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public EmployeeListItemBinding getBinding() {
        return binding;
    }

    public void bindTo(EmployeeModel employeeModel) {
        binding.setModel(employeeModel);
    }
}
