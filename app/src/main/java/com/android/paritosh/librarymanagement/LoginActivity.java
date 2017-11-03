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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import static android.R.attr.delay;
import static android.R.attr.name;
import static android.R.id.message;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText password, nameUser;
    private EditText email;
    private TextView login;
    private Button register;

    private ProgressDialog progress;

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        progress = new ProgressDialog(this);

        nameUser = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.pass);
        email = (EditText) findViewById(R.id.emailid);
        login = (TextView) findViewById(R.id.logger);
        register = (Button) findViewById(R.id.register);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }


    private void registerUser() {

        final String em = email.getText().toString().trim();
        final String pass = password.getText().toString().trim();
        final String nameOfUser = nameUser.getText().toString().trim();


        if (TextUtils.isEmpty(em)) {
            Toast.makeText(this, "enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "enter a valid password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(nameOfUser)) {
            Toast.makeText(this, "enter a valid Name", Toast.LENGTH_SHORT).show();
            return;
        }

        progress.setMessage("please wait...");
        progress.show();

        //shit




        firebaseAuth.createUserWithEmailAndPassword(em, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "registered succesfully", Toast.LENGTH_SHORT).show();

                            //nameSetter();

                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(nameOfUser).build();

                            user.updateProfile(profileUpdates);
                            firebaseAuth.signOut();


                            //saveUserInformation();
                            finish();
                            Intent n = new Intent(LoginActivity.this, AllLoginActivity.class);
                            //n.putExtra("name", nameOfUser);
                            startActivity(n);

                        } else {
                            Toast.makeText(LoginActivity.this, "registration failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


        //UserInformation userInformation = new UserInformation(nameOfUser);
        //databaseReference.child(user.getUid()).setValue(userInformation);
        //FirebaseUser user = firebaseAuth.getCurrentUser();



        /* depricated piece of shit
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(nameOfUser).build();

        user.updateProfile(profileUpdates);
        */

        /*
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                final String n = nameUser.getText().toString().trim();
                if(user!=null){
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(n).build();
                    user.updateProfile(profileUpdates);
                    //Intent intent = new Intent(currentActivity.this, nextActivity.class);
                    //startActivity(intent);
                }
            }
        };
        */

    }

    private void saveUserInformation() {


        String nameOfUser = nameUser.getText().toString().trim();
        String em = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        UserInformation userInformation = new UserInformation(nameOfUser);

        //
        //
        //
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithEmailAndPassword(em, pass);

        if (firebaseAuth.getCurrentUser() != null) {
            databaseReference.child(user.getUid()).setValue(userInformation);
        }


        Toast.makeText(this, "Information Saved", Toast.LENGTH_LONG).show();
    }


    /*
    public void nameSetter(){


        /*UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(nameOfUser).build();

        user.updateProfile(profileUpdates);

        String nameOfUser = nameUser.getText().toString().trim();
        UserInformation userInformation = new UserInformation(nameOfUser);
        databaseReference.child(user.getUid()).setValue(userInformation);
    }

    */
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
/*
    @Override
    public void onResume(){
        super.onResume();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mAuthListener != null){
            firebaseAuth.removeAuthStateListener(mAuthListener);
        }
    }
    */
}
