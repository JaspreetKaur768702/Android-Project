package com.project.cams.fragments.adminfrag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.MainActivity;
import com.project.cams.Utility.Global;
import com.project.cams.adapter.adminadapter.CourseAdapter;
import com.project.cams.databinding.CourseFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment {
    CourseFragmentBinding binding;
    CourseAdapter courseAdapter;
    DataBaseCAMS dataBase;
    Context mContext;
    List<AllCourse>  mListCourse;
    RecyclerView mRecylerview;
   // required***************//
    public CourseFragment() {
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        binding = CourseFragmentBinding.inflate(getLayoutInflater());
        initView();
        SetCourse();
        return binding.getRoot();
    }
    private void initView() {
        mRecylerview = binding.courseRecycler;
        MainActivity.floatingActionButton.bringToFront();
        MainActivity.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.changeFragment(getActivity(),new AddCourseFragment());
            }
        });
    }
     private  void  SetCourse(){
        mListCourse = new ArrayList<>();
        mListCourse = dataBase.daoData().getAllCourses();
        LinearLayoutManager  layoutManager  = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecylerview.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(mListCourse,mContext);
        mRecylerview.setAdapter(courseAdapter);
     }

}
