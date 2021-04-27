package com.project.cams;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.cams.Utility.Global;
import com.project.cams.fragments.adminfrag.AddCourseFragment;
import com.project.cams.fragments.adminfrag.AddStudentFragment;
import com.project.cams.fragments.adminfrag.AddTeacherFragment;
import com.project.cams.fragments.adminfrag.AttandanceFragment;
import com.project.cams.fragments.adminfrag.CourseFragment;
import com.project.cams.fragments.adminfrag.StudentFragment;
import com.project.cams.fragments.adminfrag.TeacherFragment;
import com.project.cams.fragments.student.StudentHomeFragment;
import com.project.cams.fragments.teacherfragmnet.ChangePasswordFragment;
import com.project.cams.fragments.teacherfragmnet.MarkAttendanceFragment;
import com.project.cams.fragments.teacherfragmnet.StudentListFragment;
import com.project.cams.fragments.teacherfragmnet.StudentsFragment;
import com.project.cams.fragments.teacherfragmnet.TakeAttendanceFragment;
import com.project.cams.fragments.teacherfragmnet.TeacherHomeFragment;
import com.project.cams.fragments.teacherfragmnet.ViewAttendanceFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public BottomNavigationView navigation;
    private Toolbar toolbar;
    private static DrawerLayout drawer;
    public static ActionBarDrawerToggle toggle;
    private AlertDialog.Builder builder;
    private LinearLayout menuLayout;
    private ActionBar actionBar;
    boolean isExit = false;
    private TextView teacher, student, course, attandance, logout;
    private TextView teacherhome, students, takeattendence, viewattandance, changepassword;
    private String newLoginId = "";
    private String login_id = "";
    public static FloatingActionButton floatingActionButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeId();
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(" ");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_drawe_menu);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            isExit = false;
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (fragment instanceof AddCourseFragment || fragment instanceof AddTeacherFragment || fragment instanceof AddStudentFragment || fragment instanceof StudentListFragment || fragment instanceof MarkAttendanceFragment) {
                getSupportFragmentManager().popBackStack();
                if (PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("userType", "").equalsIgnoreCase("admin")) {
                    floatingActionButton.setVisibility(View.VISIBLE);
                }
                setNavigationDrawerState(true);
            } else {
           Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             startActivity(intent);
            }
        }
    }
    private void initializeId() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        logout = (TextView) findViewById(R.id.logout);
        student = (TextView) findViewById(R.id.student);
        course = (TextView) findViewById(R.id.course);
        teacher = (TextView) findViewById(R.id.teacher);
        attandance = (TextView) findViewById(R.id.attendance);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        teacherhome = findViewById(R.id.home);
        students = findViewById(R.id.students);
        takeattendence = findViewById(R.id.takeAttendance);
        viewattandance = findViewById(R.id.viewAttendance);
        changepassword = findViewById(R.id.changePassword);
        logout.setOnClickListener(this);
        student.setOnClickListener(this);
        course.setOnClickListener(this);
        teacher.setOnClickListener(this);
        attandance.setOnClickListener(this);
        teacherhome.setOnClickListener(this);
        students.setOnClickListener(this);
        takeattendence.setOnClickListener(this);
        viewattandance.setOnClickListener(this);
        changepassword.setOnClickListener(this);
        if (PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("userType", "").equalsIgnoreCase("admin")) {
            Global.changeFragment(this, new StudentFragment());
            teacher.setVisibility(View.VISIBLE);
            student.setVisibility(View.VISIBLE);
            course.setVisibility(View.VISIBLE);
            attandance.setVisibility(View.GONE);
            teacherhome.setVisibility(View.GONE);
            students.setVisibility(View.GONE);
            takeattendence.setVisibility(View.GONE);
            viewattandance.setVisibility(View.GONE);
            changepassword.setVisibility(View.GONE);
        } else if (PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("userType", "").equalsIgnoreCase("teacher")) {
            Global.changeFragment(this, new TeacherHomeFragment());
            teacher.setVisibility(View.GONE);
            student.setVisibility(View.GONE);
            course.setVisibility(View.GONE);
            attandance.setVisibility(View.GONE);
            teacherhome.setVisibility(View.VISIBLE);
            students.setVisibility(View.VISIBLE);
            takeattendence.setVisibility(View.VISIBLE);
            viewattandance.setVisibility(View.VISIBLE);
            changepassword.setVisibility(View.GONE);
            floatingActionButton.setVisibility(View.GONE);
        }


    }

    @Override
    public void onClick(View v) {
        drawer.closeDrawers();
        switch (v.getId()) {
            case R.id.student:
                Global.changeFragment(this, new StudentFragment());
                break;
            case R.id.teacher:
                Global.changeFragment(this, new TeacherFragment());
                break;
            case R.id.course:
                Global.changeFragment(this, new CourseFragment());
                break;
            case R.id.attendance:
                Global.changeFragment(this, new AttandanceFragment());
                break;
            case R.id.home:
                Global.changeFragment(this, PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("userType", "").equalsIgnoreCase("student") ? new StudentHomeFragment() : new TeacherHomeFragment());
                break;
            case R.id.students:
                Global.changeFragment(this, new StudentsFragment());
                break;
            case R.id.takeAttendance:
                Global.changeFragment(this, new TakeAttendanceFragment());
                break;
            case R.id.viewAttendance:
                Global.changeFragment(this, new ViewAttendanceFragment());
                break;
            case R.id.changePassword:
                Global.changeFragment(this, new ChangePasswordFragment());
                break;
            case R.id.logout:
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().remove("userid").apply();
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().remove("login_id").apply();
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().remove("userName").apply();
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().remove("userType").apply();
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit().remove("contact_no").apply();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();

        }
    }
    public static void setNavigationDrawerState(boolean isEnable) {
        if (isEnable) {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            toggle.setDrawerIndicatorEnabled(true);
            // toggle.setDrawerIndicatorEnabled(false);
            toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawer.openDrawer(GravityCompat.START);
                }
            });
            toggle.setHomeAsUpIndicator(R.drawable.ic_drawe_menu);
            toggle.syncState();
        } else {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            toggle.setDrawerIndicatorEnabled(false);
            toggle.setHomeAsUpIndicator(R.drawable.ic_back_icon);
            toggle.syncState();
        }
    }
}
