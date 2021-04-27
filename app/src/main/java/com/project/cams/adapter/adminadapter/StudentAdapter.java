package com.project.cams.adapter.adminadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.AllStudents;
import com.project.cams.DBhelperclasses.AllTeacher;
import com.project.cams.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    List< AllStudents > mList;
    Context mContext;
    View view;

    public StudentAdapter(List< AllStudents> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.adapter_student, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllStudents pos = mList.get(position);
        holder.coursecode.setText(pos.getCourse_code());
        holder.title.setText(pos.getFirstnamestudents());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder  extends RecyclerView.ViewHolder  {
        TextView title, coursecode;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.studentid);
            coursecode = itemView.findViewById(R.id.studentscourse);
        }
    }
}
