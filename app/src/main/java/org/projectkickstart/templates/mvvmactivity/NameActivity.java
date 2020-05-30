package org.projectkickstart.templates.mvvmactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import org.projectkickstart.templates.R;
import org.projectkickstart.templates.databinding.ActivityNameBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */


/*
    TODO register this to your AndroidManifest.xml
*/

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

        viewModel = new ViewModelProvider(this, viewModelFactory).get(NameActivityViewModel.class);
        activityModel = viewModel.getActivityModel();
        binding.setModel(activityModel);
        binding.setHandler(this);
    }
}
