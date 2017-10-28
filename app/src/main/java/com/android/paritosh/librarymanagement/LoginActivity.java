package com.android.paritosh.librarymanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.R.attr.delay;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText password;
    private EditText email;
    private Button login;
    private Button register;

    private ProgressDialog progress;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        progress = new ProgressDialog(this);

        password = (EditText) findViewById(R.id.pass);
        email = (EditText) findViewById(R.id.emailid);
        login = (Button) findViewById(R.id.logger);
        register = (Button) findViewById(R.id.register);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    private void registerUser() {
        String em = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (TextUtils.isEmpty(em)) {
            Toast.makeText(this, "enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "enter a valid password", Toast.LENGTH_SHORT).show();
            return;
        }

        progress.setMessage("please wait...");
        progress.show();

        firebaseAuth.createUserWithEmailAndPassword(em, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "registered succesfully", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(LoginActivity.this, AllLoginActivity.class));

                        } else {
                            Toast.makeText(LoginActivity.this, "registration failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == login) {
            finish();
            startActivity(new Intent(LoginActivity.this, AllLoginActivity.class));
        }
        if (view == register) {
            registerUser();
        }
    }
}
