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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class CompanyManager extends AppCompatActivity {

    TextView link;
    EditText companyID;
    Button removeCompany;

    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_manager);

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        String url = "https://console.firebase.google.com/u/0/project/myshiftproject/firestore/data/~2FCompany";

        link = findViewById(R.id.firebaseRedirection);
        companyID = findViewById(R.id.companyID);
        removeCompany = findViewById(R.id.removeCompany);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        removeCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String company_id_str = companyID.getText().toString();

                //TODO: REMOVE STUDENT FROM DATABASE
                db.collection("Company").document(company_id_str).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(CompanyManager.this, "Successfully Removed", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(CompanyManager.this, "FAILED", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });


    }
}