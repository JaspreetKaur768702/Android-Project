package com.project.cams.fragments.teacherfragmnet;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.AllStudents;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.MainActivity;
import com.project.cams.Utility.Global;
import com.project.cams.adapter.adminadapter.StudentAdapter;
import com.project.cams.adapter.teacheradaper.MarkerAttendanceAdapter;
import com.project.cams.databinding.MarkAttendanceFragmentBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarkAttendanceFragment extends Fragment {
    MarkAttendanceFragmentBinding binding;
    MarkerAttendanceAdapter adapter;
    DataBaseCAMS dataBase;
    RecyclerView mRecyclerView;
    Context mContext;
    List<AllStudents> mList;
    Button submit;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        binding = MarkAttendanceFragmentBinding.inflate(getLayoutInflater());
        initView();
        SetStudents();

        return binding.getRoot();
    }
    private void initView() {
        mRecyclerView=binding.markAttendnceRecycler;
        submit=binding.submit;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Global.changeFragment(getActivity(),new ViewAttendanceFragment());
            }
        });
        MainActivity.setNavigationDrawerState(false);
        MainActivity.toggle.setToolbarNavigationClickListener(v -> getActivity().onBackPressed());

    }
    private void SetStudents() {
        String selected_course_code=TakeAttendanceFragment.getSelected_course_code;
        mList = new ArrayList<>();
        mList = dataBase.daoData().getAllStudents_fromCourse(selected_course_code);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new MarkerAttendanceAdapter(mList, mContext);
        mRecyclerView.setAdapter(adapter);
    }

}