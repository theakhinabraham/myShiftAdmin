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

public class JobManager extends AppCompatActivity {

    TextView link;
    EditText jobID;
    Button removeJob;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_manager);

        link = findViewById(R.id.firebaseRedirection);
        jobID = findViewById(R.id.jobID);
        removeJob = findViewById(R.id.removeJob);

        String url = "https://console.firebase.google.com/u/0/project/myshiftproject/firestore/data/~2FJobs";

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        removeJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String job_id_str = jobID.getText().toString();

                //TODO: REMOVE JOB FROM DATABASE

            }
        });

    }
}