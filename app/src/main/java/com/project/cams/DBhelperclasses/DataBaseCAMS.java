package com.project.cams.DBhelperclasses;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AllTeacher.class, AllCourse.class,AllStudents.class,StudentSelectedCourse.class,AttendanceMarked.class},version =5,exportSchema = true)
public abstract class DataBaseCAMS extends RoomDatabase{
    //data base instance
  public static DataBaseCAMS instance;
    private static String databasename="db_attendance_system";
    public synchronized static DataBaseCAMS getInstance(Context mcontext){
        // check
        if(instance == null){
            instance = Room.databaseBuilder(mcontext, DataBaseCAMS.class,databasename).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
     return instance;
    }
   public abstract DaoCarts daoData();
}
