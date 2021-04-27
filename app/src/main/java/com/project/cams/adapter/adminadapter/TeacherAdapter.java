package com.project.cams.adapter.adminadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.AllTeacher;
import com.project.cams.R;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.MyViewHolder> {
    List<AllTeacher> mList;
    Context mContext;
    View view;

    public TeacherAdapter(List< AllTeacher > mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.teacher_adapter, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AllTeacher pos = mList.get(position);
        holder.teachertitle.setText(pos.getFirstnameTeacher()+" "+pos.getLastnameTeacher());
        holder.teachercontact.setText(pos.getContactTeacher());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class MyViewHolder  extends RecyclerView.ViewHolder  {
        TextView teachertitle, teachercontact;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            teachercontact = itemView.findViewById(R.id.teachercontact_id);
            teachertitle = itemView.findViewById(R.id.teacher_name);
        }
    }
}
