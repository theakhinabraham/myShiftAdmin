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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class StudentManager extends AppCompatActivity {

    TextView link;
    EditText studentID;
    Button removeStudent;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_manager);

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


            }
        });

    }
}