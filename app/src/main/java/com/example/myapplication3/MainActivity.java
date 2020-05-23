package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication3.firebase.FirebaseAuthentication;
import com.example.myapplication3.ui.CreateAccount;
import com.example.myapplication3.ui.LogInFragment;
import com.example.myapplication3.ui.dashboard.DashboardFragment;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button signInBtn, registerBtn;
    EditText email, password;

    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuthentication.mAuth = FirebaseAuth.getInstance();

        checkAuthState();
    }

    private void checkAuthState() {
        boolean authState = FirebaseAuthentication.firebaseAuth.authState();
        if (authState) {
            FragmentManager fragmentManager= getSupportFragmentManager();
            DashboardFragment dashboardFragment = new DashboardFragment();
            fragmentManager.beginTransaction().replace(R.id.main, dashboardFragment).commit();
        } else {
            FragmentManager fragmentManager= getSupportFragmentManager();
            LogInFragment logInFragment = new LogInFragment();
            fragmentManager.beginTransaction().replace(R.id.main, logInFragment).commit();
        }
    }
}
