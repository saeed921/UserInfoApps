package com.example.userinfoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class SignUpActivity extends AppCompatActivity {

    EditText UsernameID, registerEmail, registerPass ;
    Button signup;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;


    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    //DatabaseReference reference=database.getReference("UserInfo");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
         progressDialog= new ProgressDialog(SignUpActivity.this);
         progressDialog.setTitle("Creating Account");
         progressDialog.setMessage("We're Creating Your Account \n Please Wait");

        UsernameID = findViewById(R.id.UsernameID);

        registerEmail = findViewById(R.id.registerEmailID);
        registerPass = findViewById(R.id.registerpassID);
        signup = findViewById(R.id.signupID);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();

/*
                auth.createUserWithEmailAndPassword(registerEmail.getText().toString(),
                        registerPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Info info=new Info(UsernameID.getText().toString(),
                                    registerEmail.getText().toString(),registerPass.getText().toString());
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("UserInfo").child(id).setValue(info);
                            Toast.makeText(SignUpActivity.this, "User Create Successfully", Toast.LENGTH_SHORT).show();


                        }else{

                            Toast.makeText(SignUpActivity.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                
*/
                CheakError();


            }
        });
    }

            private void CheakError() {
                String regEmail = registerEmail.getText().toString();
                String regPass = registerPass.getText().toString();

                if ((registerEmail.getText().toString().isEmpty() && registerPass.getText().toString().isEmpty())
                        || (!TextUtils.isEmpty(regEmail) && registerPass.getText().toString().isEmpty())
                        || (TextUtils.isEmpty(regEmail) && !TextUtils.isEmpty(regPass))) {
                    Toast.makeText(SignUpActivity.this, " Enter Email & Password", Toast.LENGTH_SHORT).show();


                } else if (!TextUtils.isEmpty(regEmail) && !TextUtils.isEmpty(regPass) && registerPass.length() >= 6) {
                    Toast.makeText(SignUpActivity.this, "Oka", Toast.LENGTH_SHORT).show();

                    CreateUser(regEmail, regPass);
                } else {
                    Toast.makeText(SignUpActivity.this, "Password should be 6 charachter", Toast.LENGTH_SHORT).show();
                }

            }

    private void CreateUser(String regEmail, String regPass) {

        auth.createUserWithEmailAndPassword(regEmail,regPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {

                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    Info info=new Info(UsernameID.getText().toString(), regEmail,regPass);
                    String id=task.getResult().getUser().getUid();
                    database.getReference().child("UserInfo").child(id).setValue(info);
                    Toast.makeText(SignUpActivity.this, "User Create Successfully", Toast.LENGTH_SHORT).show();


                }

                else{
                    progressDialog.setMessage("Try Again");
                    progressDialog.dismiss();
                    Toast.makeText(SignUpActivity.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }


        });


    }







}

















