package com.project.cams.fragments.teacherfragmnet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.AllStudents;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.Utility.Global;
import com.project.cams.databinding.StudentsFragmentBinding;

import java.util.ArrayList;
import java.util.List;


public class StudentsFragment  extends Fragment {
    StudentsFragmentBinding binding;
    Spinner spinner;
    Context mContext;
    DataBaseCAMS dataBase;
    List< AllCourse > list;
    ArrayList<String> newList;
    ArrayAdapter aa;
    // required***************//
    public StudentsFragment() {
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        binding = StudentsFragmentBinding.inflate(getLayoutInflater());
        initView();
        setSpiner();
        return binding.getRoot();
    }
   private void setSpiner(){
        list = dataBase.daoData().getAllCourses();
        newList = new ArrayList<>();
        for(AllCourse allCourse: list){
            newList.add(allCourse.getCourseCode());
        }
        aa = new ArrayAdapter(mContext,android.R.layout.simple_spinner_item,newList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       //Setting the ArrayAdapter data on the Spinner
       spinner.setAdapter(aa);
   }
    private void initView() {
      spinner = binding.spinnerselectCourse;
        binding.btGetStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.spinnerselectCourse.getSelectedItem().toString().equalsIgnoreCase("Select Course")){
                    Toast.makeText(getActivity(),"Please Select Course",Toast.LENGTH_SHORT).show();
                }
                else {
                    Global.changeFragment(getActivity(),new StudentListFragment());
                }
            }
        });
    }

}
