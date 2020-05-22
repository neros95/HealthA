package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication3.ui.CreateAccount;

public class MainActivity extends AppCompatActivity {

    Button button, button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.logIn);

        button1= findViewById(R.id.createAccount);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(myIntent);
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
}
