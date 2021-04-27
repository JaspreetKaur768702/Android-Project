package com.project.cams.adapter.adminadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder> {
    List<AllCourse> mList;
    Context mContext;
    View view;

    public CourseAdapter(List< AllCourse > mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.adapter_course, parent, false);
        return new CourseHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseHolder holder, int position) {
          AllCourse pos = mList.get(position);
          holder.coursecode.setText(pos.getCourseCode());
          holder.coursetitle.setText(pos.getCoursetitle());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class CourseHolder  extends RecyclerView.ViewHolder  {
        TextView coursecode, coursetitle;
        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            coursetitle = itemView.findViewById(R.id.coursetitle_id);
            coursecode = itemView.findViewById(R.id.courseCode_id);
        }
    }
}
