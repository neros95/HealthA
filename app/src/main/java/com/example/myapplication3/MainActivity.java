package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication3.firebase.FirebaseAuthentication;
import com.example.myapplication3.ui.CreateAccount;
import com.google.android.gms.tasks.Tasks;

public class MainActivity extends AppCompatActivity {

    Button button, button1;
    EditText email, password;

    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.logIn);
        button1 = findViewById(R.id.createAccount);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        boolean authState = FirebaseAuthentication.firebaseAuth.authState();
        if (authState) {
            goToMain2();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (FirebaseAuthentication.firebaseAuth.signInExistingUser(email.getText().toString(), password.getText().toString())) {
                    goToMain2();
                } else {
                    Toast.makeText(getApplicationContext(),"Login failed. Incorrect email or password",Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                }
            }
        });
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager fragmentManager= getSupportFragmentManager();
               CreateAccount createAccount = new CreateAccount();
               fragmentManager.beginTransaction().replace(R.id.main, createAccount).commit();
           }
       });
    }

    private void goToMain2() {
        myIntent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(myIntent);
    }
}
