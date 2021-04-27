package com.project.cams.adapter.teacheradaper;

import android.content.Context;
import android.icu.util.Calendar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.AllStudents;
import com.project.cams.DBhelperclasses.AllTeacher;
import com.project.cams.DBhelperclasses.AttendanceMarked;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MarkerAttendanceAdapter extends RecyclerView.Adapter<MarkerAttendanceAdapter.MyViewHolder> {
    List<AllStudents> mList;
    Context mContext;
    View view;
    DataBaseCAMS dataBase;
    String name;
    String absent, prsent, excuse;

    public MarkerAttendanceAdapter(List<AllStudents> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        view = LayoutInflater.from(mContext).inflate(R.layout.adapter_mark_attendance, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllStudents pos = mList.get(position);
        holder.title.setText(pos.getFirstnamestudents()+"  "+pos.getLastname());
        holder.present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.present.isChecked()) {
                    prsent = holder.present.getText().toString();
                    dataBase.daoData().InsertAttendance(new AttendanceMarked(pos.getStudent_id(), pos.getFirstnamestudents(), pos.getCourse_code(), "1", "0", "0", getCurrentDateAndTime()));
                }
            }
        });
        holder.absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.absent.isChecked()) {
                    absent = holder.present.getText().toString();
                    dataBase.daoData().InsertAttendance(new AttendanceMarked(pos.getStudent_id(), pos.getFirstnamestudents(), pos.getCourse_code(), "0", "1", "0", getCurrentDateAndTime()));
                }
            }
        });
        holder.excused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.excused.isChecked()) {
                    excuse = holder.present.getText().toString();
                    dataBase.daoData().InsertAttendance(new AttendanceMarked(pos.getStudent_id(), pos.getFirstnamestudents(), pos.getCourse_code(), "0", "0", "1", getCurrentDateAndTime()));
                }
            }
        });
    }

    public static String getCurrentDateAndTime() {
        Date todaysdate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(todaysdate);
        return date;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, coursecode;
        RadioButton present, absent, excused;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.student_name);
            // coursecode = itemView.findViewById(R.id.studentscourse);
            present = itemView.findViewById(R.id.present);
            absent = itemView.findViewById(R.id.absent);
            excused = itemView.findViewById(R.id.excused);
        }
    }
}

