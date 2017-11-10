package com.android.paritosh.librarymanagement;

/**
 * Created by PARITOSH on 11/2/2017.
 */
//to be worked on in future
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.R.attr.password;


public class FireAuthen {

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progress;

    public void instanceCretor() {


        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            //finish();
            //startActivity(new Intent(AllLoginActivity.this, UserLoginActivity.class));
        }
    }


    private void usetLogin(String em, String pass) {
        //String em = email.getText().toString().trim();
        //String pass = password.getText().toString().trim();

        /*
        if (TextUtils.isEmpty(em)) {
            Toast.makeText(this, "enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "enter a valid password", Toast.LENGTH_SHORT).show();
            return;
        }
        */

        progress.setMessage("please wait...");
        progress.show();

        firebaseAuth.signInWithEmailAndPassword(em, pass);
        /*
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(AllLoginActivity.this, "Login Succesful", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(AllLoginActivity.this, UserLoginActivity.class));

                        } else {
                            Toast.makeText(AllLoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                */
    }

    private void registerUser(String em, String pass) {
        //String em = email.getText().toString().trim();
        //String pass = password.getText().toString().trim();


        progress.setMessage("please wait...");
        progress.show();

        firebaseAuth.createUserWithEmailAndPassword(em, pass);
        /*
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.dismiss();
                        if (task.isSuccessful()) {
                            //Toast.makeText(LoginActivity.this, "registered succesfully", Toast.LENGTH_SHORT).show();
                            //finish();
                            //startActivity(new Intent(LoginActivity.this, AllLoginActivity.class));

                        } else {
                            //Toast.makeText(LoginActivity.this, "registration failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                */

    }

}
