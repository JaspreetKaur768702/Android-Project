package com.project.cams.fragments.student;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.DBhelperclasses.AllStudents;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.DBhelperclasses.StudentSelectedCourse;
import com.project.cams.adapter.adminadapter.CourseAdapter;
import com.project.cams.adapter.studentAdapter.StudentHomeAdapter;
import com.project.cams.databinding.StudentHomeFragmentBinding;
import com.project.cams.databinding.TeacherHomeFragmentBinding;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.project.cams.Contstant.USERPREF;
import static com.project.cams.LoginActivity.emailstudents;

public class StudentHomeFragment extends Fragment {
    StudentHomeFragmentBinding binding;
    StudentHomeAdapter adapter;
    Context mContext;
    DataBaseCAMS dataBase;
    TextView TVcontact,TVname;
    RecyclerView mRecylerview;
    List< AllStudents > mList;
    List< StudentSelectedCourse >  mListCourse;
    String sname, scontact,sCoursecod,sCourseName;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = StudentHomeFragmentBinding.inflate(getLayoutInflater());
        dataBase = DataBaseCAMS.getInstance(mContext);
        initView();
        setData();
        SetCourse();
      //  SavedValueInSharedPref();
        getSharedPrefrence();
        return binding.getRoot();
    }

    private void initView() {
        TVcontact =binding.studentcontactnumber;
        TVname = binding.studentNameId;
        mRecylerview = binding.studentHomeRecycler;
        binding.studentHomeRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.studentHomeRecycler.setAdapter(adapter);
    }
    private void setData(){
        mList = new ArrayList<>();
        mList = dataBase.daoData().getAllStudents();
        for(AllStudents allStudents : mList){
            if(allStudents.getEmailS().equalsIgnoreCase(emailstudents))
            sname = allStudents.getFirstnamestudents();
            scontact =allStudents.getContact();
            TVname.setText(sname);
            TVcontact.setText(scontact);
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        getSharedPrefrence();
    }
    private void getSharedPrefrence(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(USERPREF,MODE_PRIVATE);
        emailstudents = sharedPreferences.getString("email", "email");
    }
    private  void  SetCourse(){
        mListCourse = new ArrayList<>();
        mListCourse = dataBase.daoData().getAllCoursesStudent();
        LinearLayoutManager  layoutManager  = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecylerview.setLayoutManager(layoutManager);
       adapter=new StudentHomeAdapter(mListCourse,mContext);
        mRecylerview.setAdapter(adapter);
    }

}