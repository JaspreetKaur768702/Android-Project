package com.project.cams;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.project.cams.DBhelperclasses.AllStudents;
import com.project.cams.DBhelperclasses.DataBaseCAMS;
import com.project.cams.databinding.ActivityLoginBinding;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity {
    ActivityLoginBinding binding;
    TextInputEditText email;
    DataBaseCAMS dataBase;
  public static String emailstudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBase = DataBaseCAMS.getInstance(LoginActivity.this);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        email=binding.edEmail;
        setContentView(binding.getRoot());
        clickListerner();
    }

    private void clickListerner() {
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validations();
            }
            private void validations() {

                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter email or loginId", Toast.LENGTH_SHORT).show();
                } else if (binding.edPassword.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
                else if (binding.spinnerType.getSelectedItem().toString().equalsIgnoreCase("Select Login Type")) {
                    Toast.makeText(LoginActivity.this, "Please select loginType", Toast.LENGTH_SHORT).show();
                }
              //  else if (email.getText().toString().equalsIgnoreCase(emailstudents) || binding.edEmail.getText().toString().equalsIgnoreCase("teacher") || binding.edEmail.getText().toString().equalsIgnoreCase("admin")) {
                    if (binding.edPassword.getText().toString().equalsIgnoreCase("1234")) {
                      //  SavedValueInSharedPref(emailstudents);
                        PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putString("userType",binding.spinnerType.getSelectedItem().toString()).apply();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                }
          //  }
        });
    }
    //public void SavedValueInSharedPref(String email) {
      //  SharedPreferences prefs = getApplicationContext().getSharedPreferences(Contstant.USERPREF, MODE_PRIVATE);
      //  SharedPreferences.Editor editor = prefs.edit();
       // editor.putString("email", emailstudents);
       // editor.apply();
   // }

}
