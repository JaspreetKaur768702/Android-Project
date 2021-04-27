package com.project.cams.fragments.teacherfragmnet;

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
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.MainActivity;
import com.project.cams.Utility.Global;
import com.project.cams.adapter.adminadapter.CourseAdapter;
import com.project.cams.databinding.CourseFragmentBinding;
import com.project.cams.databinding.TeacherHomeFragmentBinding;
import com.project.cams.fragments.adminfrag.AddCourseFragment;
import java.util.ArrayList;
import java.util.List;

public class TeacherHomeFragment extends Fragment {
    TeacherHomeFragmentBinding binding;
    CourseAdapter courseAdapter;
    DataBaseCAMS dataBase;
    Context mContext;
    List< AllCourse > mListCourse;
    RecyclerView mRecylerview;
    // required***************//
    public TeacherHomeFragment() {
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        binding =  TeacherHomeFragmentBinding.inflate(getLayoutInflater());
        initView();
        SetCourse();
        return binding.getRoot();
    }
    private void initView() {
        mRecylerview = binding.teacherHomeRecycler;
        MainActivity.floatingActionButton.bringToFront();
        MainActivity.floatingActionButton.setOnClickListener(v -> Global.changeFragment(getActivity(),new AddCourseFragment()));
    }
    private  void  SetCourse(){
        mListCourse = new ArrayList<>();
        mListCourse = dataBase.daoData().getAllCourses();
        LinearLayoutManager layoutManager  = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecylerview.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(mListCourse,mContext);
        mRecylerview.setAdapter(courseAdapter);
    }
}
