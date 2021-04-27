package com.project.cams.DBhelperclasses;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "studentcourse")
public class StudentSelectedCourse implements Serializable {
    //primary key auto increament
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "course_id")
    private int student_id;
    @ColumnInfo(name = "coursecode")
    private String coursecode;
    //
    @ColumnInfo(name = "coursetitle")
    private String coursetitle;
    //
    @ColumnInfo(name = "teacher")
    private String teacher;
    @ColumnInfo(name = "emailS")
    private String emailS;


    public StudentSelectedCourse(String coursecode, String coursetitle, String teacher, String emailS) {
        this.coursecode = coursecode;
        this.coursetitle = coursetitle;
        this.teacher = teacher;
        this.emailS = emailS;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getEmailS() {
        return emailS;
    }

    public void setEmailS(String emailS) {
        this.emailS = emailS;
    }
}
