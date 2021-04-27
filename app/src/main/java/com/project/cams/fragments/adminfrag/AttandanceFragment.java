package com.project.cams.fragments.adminfrag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.project.cams.MainActivity;
import com.project.cams.Utility.Global;
import com.project.cams.databinding.AttandanceFragmentBinding;


public class AttandanceFragment extends Fragment {
    AttandanceFragmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = AttandanceFragmentBinding.inflate(getLayoutInflater());
       initView();
        return binding.getRoot();
    }

    private void initView() {

    }
}
