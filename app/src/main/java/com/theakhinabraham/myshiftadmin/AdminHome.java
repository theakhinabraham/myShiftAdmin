package com.theakhinabraham.myshiftadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminHome extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;

    Button manageStudentsBtn, manageCompaniesBtn, manageJobsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        manageStudentsBtn = findViewById(R.id.manageStudentsBtn);
        manageCompaniesBtn = findViewById(R.id.manageCompaniesBtn);
        manageJobsBtn = findViewById(R.id.manageJobsBtn);

        manageStudentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToStudents = new Intent(AdminHome.this, StudentManager.class);
                startActivity(goToStudents);
            }
        });

        manageCompaniesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToCompanies = new Intent(AdminHome.this, CompanyManager.class);
                startActivity(goToCompanies);
            }
        });

        manageJobsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToJobs = new Intent(AdminHome.this, JobManager.class);
                startActivity(goToJobs);
            }
        });

    }
}