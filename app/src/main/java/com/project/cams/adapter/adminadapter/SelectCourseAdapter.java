package com.project.cams.adapter.adminadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.cams.DBhelperclasses.AllCourse;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.DBhelperclasses.StudentSelectedCourse;
import com.project.cams.R;
import com.project.cams.fragments.adminfrag.AddStudentFragment;

import java.util.ArrayList;
import java.util.List;

import static com.project.cams.fragments.adminfrag.AddStudentFragment.mEmail;

public class SelectCourseAdapter extends RecyclerView.Adapter<SelectCourseAdapter.CourseHolder> {
    List<AllCourse> mList;
   List<String> courselist;
    List< StudentSelectedCourse > course_add_list;
   public static String  course_code;
   public static String course_title;


   Context mContext;
    View view;
    DataBaseCAMS dataBase;
    public SelectCourseAdapter (List< AllCourse > mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        view = LayoutInflater.from(mContext).inflate(R.layout.select_course_adapter, parent, false);
        return new CourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        AllCourse pos = mList.get(position);
        courselist = new ArrayList<>();
        course_add_list = new ArrayList<>();
        holder.coursecode.setText(pos.getCourseCode());
        holder.checkBox.setText(pos.getCoursetitle());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    course_code=pos.getCourseCode();
                    course_title=pos.getCoursetitle();

                    compoundButton.setChecked(true);
                    courselist.add(pos.getCourseCode());
                    dataBase.daoData().InsertStudentsCourse(new StudentSelectedCourse(pos.getCourseCode(),pos.getCoursetitle(),pos.getCourseTeacher(),mEmail));

                }
                else
                {
                    compoundButton.setChecked(false);
                    courselist.add(pos.getCourseCode());
                }
            }
        });
    }
    public void AddCourse(){

    }
   public String checkCourse( ){
       StringBuilder listString = new StringBuilder();
      for(String s : courselist){
         listString.append(s);

          // listString.append(s).append(",");
      }
     return listString.toString();
   }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    public static class CourseHolder  extends RecyclerView.ViewHolder  {
        TextView coursecode;
        CheckBox checkBox;
        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.coursetitles);
            coursecode = itemView.findViewById(R.id.selectedcourseid);
        }
    }
}
