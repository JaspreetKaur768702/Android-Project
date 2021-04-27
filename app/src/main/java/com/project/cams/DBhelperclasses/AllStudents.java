package com.project.cams.DBhelperclasses;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AllStudents")
public class AllStudents implements Serializable {
    //primary key auto increament
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    private int student_id;
    @ColumnInfo(name = "firstnamestudent")
    private String firstnamestudents;
    //
    @ColumnInfo(name = "lastname")
    private String lastname;
    //
    @ColumnInfo(name = "contactS")
    private String contact;
    //
    @ColumnInfo(name = "emailS")
    private String emailS;
    @ColumnInfo(name = "course_code")
    private String course_code;
    @ColumnInfo(name = "course_title")
    private String course_title;


    public AllStudents(String firstnamestudents, String lastname, String contact, String emailS, String course_code, String course_title) {
        this.firstnamestudents = firstnamestudents;
        this.lastname = lastname;
        this.contact = contact;
        this.emailS = emailS;
        this.course_code = course_code;
        this.course_title = course_title;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirstnamestudents() {
        return firstnamestudents;
    }

    public void setFirstnamestudents(String firstnamestudents) {
        this.firstnamestudents = firstnamestudents;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmailS() {
        return emailS;
    }

    public void setEmailS(String emailS) {
        this.emailS = emailS;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }
}
