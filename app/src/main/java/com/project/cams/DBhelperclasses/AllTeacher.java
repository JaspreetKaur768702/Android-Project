package com.project.cams.DBhelperclasses;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AllTeacher")
public class AllTeacher implements Serializable {
    //primary key auto increament
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Idteacher")
    private int id;
    @ColumnInfo(name = "firstname")
    private String firstnameTeacher;
    //
    @ColumnInfo(name = "lastnameTeacher")
    private String lastnameTeacher;
    //
    @ColumnInfo(name = "contactTeacher")
    private String contactTeacher;
    //
    @ColumnInfo(name = "emailTeacher")
    private String emailTeacher;

    public AllTeacher(String firstnameTeacher, String lastnameTeacher, String contactTeacher, String emailTeacher) {
        this.firstnameTeacher = firstnameTeacher;
        this.lastnameTeacher = lastnameTeacher;
        this.contactTeacher = contactTeacher;
        this.emailTeacher = emailTeacher;
    }
    /******/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstnameTeacher() {
        return firstnameTeacher;
    }

    public void setFirstnameTeacher(String firstnameTeacher) {
        this.firstnameTeacher = firstnameTeacher;
    }

    public String getLastnameTeacher() {
        return lastnameTeacher;
    }

    public void setLastnameTeacher(String lastnameTeacher) {
        this.lastnameTeacher = lastnameTeacher;
    }

    public String getContactTeacher() {
        return contactTeacher;
    }

    public void setContactTeacher(String contactTeacher) {
        this.contactTeacher = contactTeacher;
    }

    public String getEmailTeacher() {
        return emailTeacher;
    }

    public void setEmailTeacher(String emailTeacher) {
        this.emailTeacher = emailTeacher;
    }
}
