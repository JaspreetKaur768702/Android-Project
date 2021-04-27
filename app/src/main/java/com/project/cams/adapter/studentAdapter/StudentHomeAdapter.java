package com.project.cams.adapter.studentAdapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.StudentSelectedCourse;
import com.project.cams.R;

import java.util.List;

public class StudentHomeAdapter extends RecyclerView.Adapter< StudentHomeAdapter.CourseHolder> {
    List< StudentSelectedCourse > mList;
    Context mContext;
    View view;

    public StudentHomeAdapter(List< StudentSelectedCourse > mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.adapter_student_home, parent, false);
        return new CourseHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
   StudentSelectedCourse pos = mList.get(position);
        holder.coursecode.setText(pos.getCoursecode());
        holder.coursetitle.setText(pos.getCoursetitle());
        holder.teacher.setText(pos.getTeacher());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class CourseHolder  extends RecyclerView.ViewHolder  {
        TextView coursecode, coursetitle,teacher;
        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            coursetitle = itemView.findViewById(R.id.coursetitlehome);
            coursecode = itemView.findViewById(R.id.codecoursehome);
            teacher = itemView.findViewById(R.id.courseteacher);
        }
    }
}
