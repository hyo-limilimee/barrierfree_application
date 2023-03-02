package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class activity_sign_up extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.text_sign).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.text_sign:
                    signUp();
                    break;
            }
        }
    };

    private void signUp() {
        String id = ((EditText) findViewById(R.id.text_id)).getText().toString();
        String password = ((EditText) findViewById(R.id.text_password)).getText().toString();

        if (id.length() > 0 && password.length() > 0) {
            mAuth.createUserWithEmailAndPassword(id, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override

                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(activity_sign_up.this, "회원 가입에 성공했습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        if (task.getException().toString() != null) {
                            Toast.makeText(activity_sign_up.this, "회원 가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }

        else
            {
                Toast.makeText(activity_sign_up.this, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    
    //수정수정수정
//브랜치에서 수정