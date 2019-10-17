package com.sagar.templates.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.sagar.templates.R;
import com.sagar.templates.databinding.FragmentProfileBinding;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class ProfileFragment extends Fragment implements ProfileFragmentHandler {

    @Inject
    ProfileFragmentViewModelFactory viewModelFactory;

    private ProfileFragmentViewModel viewModel;

    private FragmentProfileBinding binding;

    private ProfileFragmentModel fragmentModel;

    private FragmentActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        activity = ((FragmentActivity) context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProfileFragmentViewModel.class);
        fragmentModel = viewModel.getFragmentModel();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        binding.setModel(fragmentModel);
        binding.setHandler(this);
        return binding.getRoot();

    }

}