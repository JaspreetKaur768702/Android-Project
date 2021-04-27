package com.project.cams.DBhelperclasses;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface DaoCarts {
    @Insert
    void InsertCourse(AllCourse recordsModel);

    @Insert
    void InsertTeacher(AllTeacher recordsModel);

    @Insert
    void InsertStudents(AllStudents allStudents);

    @Insert
    void InsertStudentsCourse(StudentSelectedCourse allStudents);

    @Query("SELECT * FROM AllStudents where emailS = :sid ")
    List<AllStudents> getStudentByEmail(String sid);

    @Insert
    void InsertAttendance(AttendanceMarked attendanceMarked);

    @Query("SELECT * FROM AllCourse ")
    List<AllCourse> getAllCourses();

    @Query("SELECT * FROM AllTeacher ")
    List<AllTeacher> getAllTeacher();

    @Query("SELECT * FROM AllStudents ")
    List<AllStudents> getAllStudents();

    @Query("SELECT * FROM AllStudents where course_code = :course_cod")
    List<AllStudents> getAllStudents_fromCourse(String course_cod);

    @Query("SELECT * FROM studentcourse ")
    List<StudentSelectedCourse> getAllCoursesStudent();

    @Query("SELECT * from AttendanceMarked where currentdate =:dated and coursecode=:course_codes")
    List<AttendanceMarked> getMarkedAttendence(String dated,String course_codes);

}