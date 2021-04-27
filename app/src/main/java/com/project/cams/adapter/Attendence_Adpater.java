package com.project.cams.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.cams.DBhelperclasses.AttendanceMarked;
import com.project.cams.R;

import java.util.List;

public class Attendence_Adpater extends RecyclerView.Adapter< Attendence_Adpater.CourseHolder> {
    List<AttendanceMarked> mList;
    Context mContext;
    View view;

    public Attendence_Adpater(List< AttendanceMarked > mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.attended_student, parent, false);
        return new CourseHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        AttendanceMarked pos = mList.get(position);
        holder.coursecode.setText(pos.getFirstnamestudents());
        holder.teacher.setText(pos.getmDatecurrent());
        if (pos.getmAbsent().equals(1)){
            holder.coursetitle.setText("Absent");
        }
        else if (pos.getmPresnt().equals("1")){
            holder.coursetitle.setText("Present");
        }
        else {
            holder.coursetitle.setText("Excused");
        }


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
