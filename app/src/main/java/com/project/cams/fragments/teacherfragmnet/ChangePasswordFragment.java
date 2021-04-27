package com.project.cams.fragments.teacherfragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.project.cams.databinding.ChangePasswordFragmentBinding;

public class ChangePasswordFragment extends Fragment {
    ChangePasswordFragmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ChangePasswordFragmentBinding.inflate(getLayoutInflater());
        initView();
        return binding.getRoot();
    }

    private void initView() {
    }

}