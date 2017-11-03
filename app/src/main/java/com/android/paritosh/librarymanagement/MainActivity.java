package com.android.paritosh.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int i = 0, j;

    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // already logs in the user if the user is logged in...
        // gotta work on the looks now
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            finish();
            startActivity(new Intent(MainActivity.this, UserLoginActivity.class));
            // i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //startActivity(i);
        } else {
            // User is signed out
            Log.d("TAG", "onAuthStateChanged:signed_out");
        }
    }


    public void logger(View view) {
        // Create a new intent to open the {@link PhrasesActivity}
        Intent phrasesIntent = new Intent(MainActivity.this, LoginActivity.class);

        // Start the new activity
        startActivity(phrasesIntent);
    }

    /*
    public void fac(View view) {
        // Create a new intent to open the {@link PhrasesActivity}
        Intent yoloIntent = new Intent(MainActivity.this, FacultyActivity.class);

        // Start the new activity
        startActivity(yoloIntent);
    }
    */


    public void Allog(View view) {
        // Create a new intent to open the {@link PhrasesActivity}
        Intent phrasesIntent = new Intent(MainActivity.this, AllLoginActivity.class);

        // Start the new activity
        startActivity(phrasesIntent);
    }
}
