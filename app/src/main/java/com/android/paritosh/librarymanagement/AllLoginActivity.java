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
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.android.paritosh.librarymanagement.R.id.register;

public class AllLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText password;
    private EditText email;
    private Button login, regis;

    private ProgressDialog progress;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(AllLoginActivity.this, UserLoginActivity.class));
        }

        password = (EditText) findViewById(R.id.passLog);
        email = (EditText) findViewById(R.id.emailidLog);
        login = (Button) findViewById(R.id.LoginLog);
        regis = (Button) findViewById(R.id.RegisLog);

        progress = new ProgressDialog(this);


        login.setOnClickListener(this);
        regis.setOnClickListener(this);

    }

    public void books(View view) {
        // Create a new intent to open the {@link PhrasesActivity}
        Intent booksIntent = new Intent(AllLoginActivity.this, BooksActivity.class);

        // Start the new activity
        startActivity(booksIntent);
    }

    private void usetLogin() {
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

        firebaseAuth.signInWithEmailAndPassword(em, pass)
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
    }

    @Override
    public void onClick(View view) {
        if (view == login) {
            usetLogin();
        }
        if (view == regis) {
            finish();
            startActivity(new Intent(AllLoginActivity.this, LoginActivity.class));
        }
    }
}
