package com.project.cams.adapter.teacheradaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.R;

public class StudentlistAdapter extends RecyclerView.Adapter<StudentlistAdapter.StudentlistHolder> {
    @NonNull
    @Override
    public StudentlistAdapter.StudentlistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_student_list, parent, false);
        return new StudentlistAdapter.StudentlistHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull StudentlistAdapter.StudentlistHolder holder, int position) {
        holder.studentName.setText("Student" + (position + 1));
    }
    @Override
    public int getItemCount() {
        return 7;
    }

    public class StudentlistHolder extends RecyclerView.ViewHolder {
        private TextView studentName;
        public StudentlistHolder(@NonNull View itemView) {
            super(itemView);
            studentName=itemView.findViewById(R.id.student_name);

        }
    }
}