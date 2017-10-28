package com.android.paritosh.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int i = 0, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void logger(View view) {
        // Create a new intent to open the {@link PhrasesActivity}
        Intent phrasesIntent = new Intent(MainActivity.this, LoginActivity.class);

        // Start the new activity
        startActivity(phrasesIntent);
    }

    public void fac(View view) {
        // Create a new intent to open the {@link PhrasesActivity}
        Intent yoloIntent = new Intent(MainActivity.this, FacultyActivity.class);

        // Start the new activity
        startActivity(yoloIntent);
    }


    public void Allog(View view) {
        // Create a new intent to open the {@link PhrasesActivity}
        Intent phrasesIntent = new Intent(MainActivity.this, AllLoginActivity.class);

        // Start the new activity
        startActivity(phrasesIntent);
    }
}
