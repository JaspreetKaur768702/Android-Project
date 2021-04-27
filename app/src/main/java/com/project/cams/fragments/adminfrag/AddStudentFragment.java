package com.project.cams.fragments.adminfrag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.AllStudents;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.MainActivity;
import com.project.cams.adapter.adminadapter.CourseAdapter;
import com.project.cams.adapter.adminadapter.SelectCourseAdapter;
import com.project.cams.databinding.AddStudentFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class AddStudentFragment  extends Fragment {
    AddStudentFragmentBinding binding;
    SelectCourseAdapter courseAdapter;
    TextInputEditText ETfirstname;
    TextInputEditText ETlastname;
    TextInputEditText ETcontact;
    TextInputEditText ETemail;
    MaterialButton addButton;
    String mFirstname, mLastname, mContact;
    public static String  mEmail;
    Context mContext;
    DataBaseCAMS dataBase;
    List< AllCourse > mListCourse;
    RecyclerView mRecylerview;
   public static String course_code;
    public AddStudentFragment() {

    }
    //*****************************//
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = AddStudentFragmentBinding.inflate(getLayoutInflater());
        dataBase = DataBaseCAMS.getInstance(mContext);
        initView();
        SetCourse();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(IsNotEmpty())
              {
                  dataBase.daoData().InsertStudents(new AllStudents(mFirstname,mLastname,mContact,mEmail,SelectCourseAdapter.course_code,SelectCourseAdapter.course_title));
                  courseAdapter.AddCourse();
                  Toast.makeText(mContext, "adeded", Toast.LENGTH_SHORT).show();
              }
            }
        });
        return binding.getRoot();
    }
    private void initView() {
        ETcontact = binding.edcontactNumbers;
        ETfirstname = binding.edFirstNAmeS;
        ETlastname = binding.edlastNAmeS;
        ETemail = binding.edemailids;
        mRecylerview =binding.courseRecycler;
        addButton = binding.addstudentsid;
        MainActivity.setNavigationDrawerState(false);
        MainActivity.toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        MainActivity.floatingActionButton.setVisibility(View.GONE);
    }
    /*********Validation*********/
    private Boolean IsNotEmpty() {
        mFirstname = ETfirstname.getText().toString();
        mLastname = ETlastname.getText().toString();
        mEmail = ETemail.getText().toString();
        mContact = ETcontact.getText().toString();
        if (mFirstname.isEmpty()) {
            Toast.makeText(mContext, "Enter FirstName", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mLastname.isEmpty()) {
            Toast.makeText(mContext, "Enter LastName", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mContact.isEmpty()) {
            Toast.makeText(mContext, "Enter Contact", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (mEmail.isEmpty()) {
            Toast.makeText(mContext, "Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private  void  SetCourse(){
        mListCourse = new ArrayList<>();
        mListCourse = dataBase.daoData().getAllCourses();
        LinearLayoutManager layoutManager  = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecylerview.setLayoutManager(layoutManager);
        courseAdapter = new SelectCourseAdapter(mListCourse,mContext);
        mRecylerview.setAdapter(courseAdapter);
    }
}
