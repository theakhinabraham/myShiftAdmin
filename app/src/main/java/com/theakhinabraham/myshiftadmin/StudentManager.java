package com.theakhinabraham.myshiftadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.FileInputStream;
import java.io.InputStream;
import com.google.firebase.auth.FirebaseAuth;

public class StudentManager extends AppCompatActivity {

    TextView link;
    EditText studentID;
    Button removeStudent;


    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_manager);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        String url = "https://console.firebase.google.com/u/0/project/myshiftproject/firestore/data/~2FStudent";

        link = findViewById(R.id.firebaseRedirection);
        studentID = findViewById(R.id.studentID);
        removeStudent = findViewById(R.id.removeStudent);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        removeStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String student_id_str = studentID.getText().toString();

                //TODO: REMOVE STUDENT FROM DATABASE
                db.collection("Student").document(student_id_str).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(StudentManager.this, "Successfully Removed", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(StudentManager.this, "FAILED", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }
}