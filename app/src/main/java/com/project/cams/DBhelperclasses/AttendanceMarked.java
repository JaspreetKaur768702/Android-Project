package com.project.cams.DBhelperclasses;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "AttendanceMarked")
public class AttendanceMarked implements Serializable {
    //primary key auto increament
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    protected int student_id;
    @ColumnInfo(name = "studentgivinid")
    protected int studentgivinid;
    @ColumnInfo(name = "firstnamestudent")
    protected String firstnamestudents;
    //
    @ColumnInfo(name = "coursecode")
    protected String mCourseCode;
    @ColumnInfo(name = "present")
    protected String mPresnt;
    //
    @ColumnInfo(name = "absent")
    protected String mAbsent;
    //
    @ColumnInfo(name = "excuse")
    protected String mExcuse;
    @ColumnInfo(name = "currentdate")
    protected String mDatecurrent;

    public AttendanceMarked(int studentgivinid, String firstnamestudents, String mCourseCode, String mPresnt, String mAbsent, String mExcuse, String mDatecurrent) {
        this.studentgivinid = studentgivinid;
        this.firstnamestudents = firstnamestudents;
        this.mCourseCode = mCourseCode;
        this.mPresnt = mPresnt;
        this.mAbsent = mAbsent;
        this.mExcuse = mExcuse;
        this.mDatecurrent = mDatecurrent;
    }

    public int getStudentgivinid() {
        return studentgivinid;
    }

    public void setStudentgivinid(int studentgivinid) {
        this.studentgivinid = studentgivinid;
    }

    public String getFirstnamestudents() {
        return firstnamestudents;
    }

    public void setFirstnamestudents(String firstnamestudents) {
        this.firstnamestudents = firstnamestudents;
    }

    public String getmCourseCode() {
        return mCourseCode;
    }

    public void setmCourseCode(String mCourseCode) {
        this.mCourseCode = mCourseCode;
    }

    public String getmPresnt() {
        return mPresnt;
    }

    public void setmPresnt(String mPresnt) {
        this.mPresnt = mPresnt;
    }

    public String getmAbsent() {
        return mAbsent;
    }

    public void setmAbsent(String mAbsent) {
        this.mAbsent = mAbsent;
    }

    public String getmExcuse() {
        return mExcuse;
    }

    public void setmExcuse(String mExcuse) {
        this.mExcuse = mExcuse;
    }

    public String getmDatecurrent() {
        return mDatecurrent;
    }

    public void setmDatecurrent(String mDatecurrent) {
        this.mDatecurrent = mDatecurrent;
    }
}
