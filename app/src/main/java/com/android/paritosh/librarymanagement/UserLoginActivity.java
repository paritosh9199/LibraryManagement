package com.android.paritosh.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.data;
import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.android.paritosh.librarymanagement.R.id.log;

public class UserLoginActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView logout, valueFromUser;
    private TextView email;
    private Button saveInfo;
    private EditText name, halltckt;


    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        setContentView(R.layout.activity_user_login);

        String displayName = user.getDisplayName();

        for (UserInfo userInfo : user.getProviderData()) {
            if (displayName == null && userInfo.getDisplayName() != null) {
                displayName = userInfo.getDisplayName();
            }
        }


        logout = (TextView) findViewById(R.id.signoutUsr);
        valueFromUser = (TextView) findViewById(R.id.valueUsr);
        email = (TextView) findViewById(R.id.UserEmail);
        name = (EditText) findViewById(R.id.nameUsr);
        halltckt = (EditText) findViewById(R.id.hallUsr);
        saveInfo = (Button) findViewById(R.id.saveUsr);

        logout.setOnClickListener(this);
        saveInfo.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(UserLoginActivity.this, AllLoginActivity.class));
        }

        /* set the username proto 1
        Intent i = getIntent();
        String n = i.getStringExtra("puzzle");

        if(databaseReference.child(user.getUid()).getKey()==null) {
            UserInformation userInformation = new UserInformation(n);
            databaseReference.child(user.getUid()).setValue(userInformation);
        }
        */


        email.setText("welcome " + user.getDisplayName());
    }

    @Override
    public void onClick(View view) {
        if (view == logout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, AllLoginActivity.class));
        }

        if (view == saveInfo) {
            saveUserInformation();
        }
    }

    private void saveUserInformation() {
        String usrName = name.getText().toString().trim();
        String usrHallticket = halltckt.getText().toString().trim();

        UserInformation userInformation = new UserInformation(usrName, usrHallticket);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this, "Information Saved", Toast.LENGTH_LONG).show();
    }


}
