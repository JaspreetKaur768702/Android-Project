package com.project.cams.DBhelperclasses;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "AllCourse")
public class AllCourse implements Serializable {
    //primary key auto increament
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "mcourseCode")
    private String courseCode;
    //
    @ColumnInfo(name = "mcourseTitle")
    private String coursetitle;
    //
    @ColumnInfo(name = "mcourseTeacher")
    private String courseTeacher;

    public AllCourse(String courseCode, String coursetitle, String courseTeacher) {
        this.courseCode = courseCode;
        this.coursetitle = coursetitle;
        this.courseTeacher = courseTeacher;
    }
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }
    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
