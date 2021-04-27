package com.project.cams.fragments.adminfrag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.project.cams.DBhelperclasses.AllTeacher;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.MainActivity;
import com.project.cams.databinding.AddTeacherFragmentBinding;

public class AddTeacherFragment extends Fragment {
    AddTeacherFragmentBinding binding;
    TextInputEditText ETfirstname;
    TextInputEditText ETlastname;
    TextInputEditText ETcontact;
    TextInputEditText ETemail;
    MaterialButton addTeacherButton;
    String mFirstname, mLastname, mContact, mEmail;
    Context mContext;
    DataBaseCAMS dataBase;

    public AddTeacherFragment() {

    }
    //*****************************//
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        binding = AddTeacherFragmentBinding.inflate(getLayoutInflater());
        initView();
        addTeacherButton.setOnClickListener(v -> {
            if(IsNotEmpty()){
                dataBase.daoData().InsertTeacher(new AllTeacher(mFirstname,mLastname,mContact,mEmail));
                Toast.makeText(mContext, "Added Teacher", Toast.LENGTH_SHORT).show();
            }
        });
        return binding.getRoot();
    }

    private void initView() {
        ETcontact = binding.edcontactNumber;
        ETfirstname = binding.edFirstNAme;
        ETlastname = binding.edlastNAme;
        ETemail = binding.edemailid;
        addTeacherButton = binding.addTeacherbuttonid;
        MainActivity.setNavigationDrawerState(false);
        MainActivity.toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        MainActivity.floatingActionButton.setVisibility(View.GONE);
    }
    /*********Validation*********/
    private Boolean IsNotEmpty() {
        mFirstname = ETfirstname.getText().toString();
        mLastname = ETlastname.getText().toString();
        mEmail = ETemail.getText().toString();
        mContact = ETcontact.getText().toString();
        if (mFirstname.isEmpty()) {
            Toast.makeText(mContext, "Enter FirstName", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mLastname.isEmpty()) {
            Toast.makeText(mContext, "Enter LastName", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mContact.isEmpty()) {
            Toast.makeText(mContext, "Enter Contact", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (mEmail.isEmpty()) {
            Toast.makeText(mContext, "Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

