package com.project.cams.Utility;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.project.cams.R;

public class Global {

    public static void changeFragment(final Context context, final Fragment fragment) {
        FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment).addToBackStack(fragment.getTag()).commit();
    }
}
