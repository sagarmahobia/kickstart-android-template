package org.projectkickstart.templates.mvvmactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;


import org.projectkickstart.templates.R;
import org.projectkickstart.templates.databinding.ActivityNameBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class NameActivity extends AppCompatActivity implements NameActivityHandler {

    @Inject
    NameActivityViewModelFactory viewModelFactory;

    private ActivityNameBinding binding;

    private NameActivityViewModel viewModel;

    private NameActivityModel activityModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_name);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NameActivityViewModel.class);
        activityModel = viewModel.getActivityModel();
        binding.setModel(activityModel);
        binding.setHandler(this);
    }
}
