package com.project.cams.fragments.adminfrag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.MainActivity;
import com.project.cams.databinding.AddCourseFragmentBinding;

public class AddCourseFragment extends Fragment {
    AddCourseFragmentBinding binding;
    MaterialButton addCourseButton;
    TextInputEditText ETcoursecode;
    TextInputEditText ETcourseName;
    TextInputEditText ETcoursTeacher;
    String mCourseName, mCourseCode, mCourseTeacher;
    Context mContext;
    DataBaseCAMS dataBase;
           // empty required
    public AddCourseFragment() {

    }
    //*****************************//
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        binding = AddCourseFragmentBinding.inflate(getLayoutInflater());
        initView();
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(IsNotEmpty()){
                   //
               dataBase.daoData().InsertCourse(new AllCourse(mCourseCode,mCourseName,mCourseTeacher));
                   Toast.makeText(mContext, "Added", Toast.LENGTH_SHORT).show();
               }
            }
        });
        return binding.getRoot();
    }
    private void initView() {
        addCourseButton = binding.courseaddbuttonId;
        ETcoursecode = binding.edCourseCode;
        ETcourseName = binding.edCourseName;
        ETcoursTeacher = binding.edTeacher;
        MainActivity.setNavigationDrawerState(false);
        MainActivity.toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        MainActivity.floatingActionButton.setVisibility(View.GONE);
    }
    // validation of addcourse form
    private Boolean IsNotEmpty() {
        mCourseCode = ETcoursecode.getText().toString();
        mCourseName = ETcourseName.getText().toString();
        mCourseTeacher = ETcoursTeacher.getText().toString();
        if (mCourseCode.isEmpty()) {
            Toast.makeText(mContext, "Enter The Code", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mCourseName.isEmpty()) {
            Toast.makeText(mContext, "Enter Name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mCourseTeacher.isEmpty()) {
            Toast.makeText(mContext, "Enter Teacher", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}