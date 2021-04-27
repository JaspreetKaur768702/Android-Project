package com.project.cams.fragments.teacherfragmnet;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.AttendanceMarked;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.MainActivity;
import com.project.cams.Utility.Global;
import com.project.cams.adapter.Attendence_Adpater;
import com.project.cams.adapter.adminadapter.StudentAdapter;
import com.project.cams.databinding.TakeAttendanceFragmentBinding;
import com.project.cams.databinding.ViewAttendanceFragmentBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ViewAttendanceFragment extends Fragment {
    List<String> course_names=new ArrayList<>();
    ViewAttendanceFragmentBinding binding;
    DataBaseCAMS dataBase;
    DatePickerDialog.OnDateSetListener setListener;
    List< AllCourse > list;
    static String course_name;
    static String start_date1;
    static String start_date2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ViewAttendanceFragmentBinding.inflate(getLayoutInflater());
        dataBase = DataBaseCAMS.getInstance(getContext());
        list=dataBase.daoData().getAllCourses();
        List<String> courses=new ArrayList<>();
        Spinner spinner=binding.simpleSpinner;

        for (int i=0;i<list.size();i++){
            if (i==0){
                course_name=list.get(0).getCourseCode();
            }
            courses.add(list.get(i).getCourseCode());
            if (i==list.size()-1){
                ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,courses);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(aa);

            }
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                course_name=list.get(position).getCourseCode();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.markedStudents.setLayoutManager(layoutManager);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        binding.edstartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String months = String.valueOf((month+1));
                        String days = String.valueOf((day));
                        if (Integer.parseInt(months)<10)
                        {
                            months="0"+months;
                        }
                        if (Integer.parseInt(days)<10)
                        {
                            days="0"+days;
                        }
                        start_date1=(year+"-"+months+"-"+days).trim();

                        binding.edstartDate.setText((new StringBuilder()
                                .append(year).append("-").append(months)
                                .append("-").append(days).append(" ")));
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        , setListener, year, month, day);

                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.getDatePicker().setMinDate(2020);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        binding.edendDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String months = String.valueOf((month+1));
                        String days = String.valueOf((day));
                        if (Integer.parseInt(months)<10)
                        {
                            months="0"+months;
                        }
                        if (Integer.parseInt(days)<10)
                        {
                            days="0"+days;
                        }
                        start_date2=(year+"-"+months+"-"+days).trim();
                        binding.edendDate.setText((new StringBuilder()
                                .append(year).append("-").append(months)
                                .append("-").append(days).append(" ")));
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        , setListener, year, month, day);

                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.getDatePicker().setMinDate(2020);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        binding.getstudentbydate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<AttendanceMarked> attendanceMarkeds=dataBase.daoData().getMarkedAttendence(start_date1,course_name);
                List<AttendanceMarked> attendanceMarkeds1=dataBase.daoData().getMarkedAttendence(start_date2,course_name);
                if (attendanceMarkeds!=null&&attendanceMarkeds1!=null){
                    attendanceMarkeds.addAll(attendanceMarkeds1);
                    Attendence_Adpater attendence_adpater = new Attendence_Adpater(attendanceMarkeds, getContext());
                    binding.markedStudents.setAdapter(attendence_adpater);
                }
                else {
                    Attendence_Adpater attendence_adpater = new Attendence_Adpater(attendanceMarkeds, getContext());
                    binding.markedStudents.setAdapter(attendence_adpater);
                }

            }
        });
        return binding.getRoot();
    }

}