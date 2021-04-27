package com.project.cams.fragments.adminfrag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.AllTeacher;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.MainActivity;
import com.project.cams.Utility.Global;
import com.project.cams.adapter.adminadapter.CourseAdapter;
import com.project.cams.adapter.adminadapter.TeacherAdapter;
import com.project.cams.databinding.TeacherFragmentBinding;
import com.project.cams.fragments.adminfrag.AddTeacherFragment;

import java.util.ArrayList;
import java.util.List;

public class TeacherFragment extends Fragment {
    TeacherFragmentBinding binding;
    TeacherAdapter teacherAdapter;
    RecyclerView mRecyclerView;
    DataBaseCAMS dataBase;
    Context mContext;
    List< AllTeacher > mList;
    // required***************//
    public TeacherFragment() {
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = TeacherFragmentBinding.inflate(getLayoutInflater());
        dataBase = DataBaseCAMS.getInstance(mContext);
        initView();
        SetCourse();
        return binding.getRoot();
    }
    private void initView() {
        //teacherAdapter = new TeacherAdapter();
        mRecyclerView = binding.teacherRecycler;
        MainActivity.floatingActionButton.bringToFront();
        MainActivity.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.changeFragment(getActivity(),new AddTeacherFragment());
            }
        });
    }
    private  void  SetCourse(){
        mList = new ArrayList<>();
        mList = dataBase.daoData().getAllTeacher();
        LinearLayoutManager layoutManager  = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        teacherAdapter = new TeacherAdapter(mList,mContext);
        mRecyclerView.setAdapter(teacherAdapter);
    }

}
