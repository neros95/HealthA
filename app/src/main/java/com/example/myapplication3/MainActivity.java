package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication3.firebase.FirebaseAuthentication;
import com.example.myapplication3.ui.CreateAccount;
import com.example.myapplication3.ui.LogInFragment;
import com.example.myapplication3.ui.dashboard.DashboardFragment;
import com.example.myapplication3.ui.home.HomeFragment;
import com.example.myapplication3.ui.notifications.NotificationsFragment;
import com.example.myapplication3.ui.personalInfo.PersonalInfoFragment;
import com.example.myapplication3.ui.stepCounter.StepCounterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    //ChipNavigationBar bottomNav;
    Button signInBtn, registerBtn;
    EditText email, password;

    Intent myIntent;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_bar);

        FirebaseAuthentication.mAuth = FirebaseAuth.getInstance();
        bottomNavigationView.setOnNavigationItemSelectedListener(navlisterner);
        //bottomNav= findViewById(R.id.bottomNav);

        //bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
           // @Override
            //public void onItemSelected(int id) {

               // Fragment fragment= null;
                //switch (id){
                  //  case R.id.fragmentHome:
                    //    fragment= new HomeFragment();
                      //  break;
                    //case R.id.trainingPlans:
                       // fragment= new NotificationsFragment();
                        //break;
                    //case R.id.personalPlans:
                      //  fragment= new PersonalInfoFragment();
                        //break;
               // }
                //if (fragment!=null){

                  //  FragmentManager fragmentManager = getSupportFragmentManager();
                   // fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

                //}else {
                 //   Log.e(TAG,"Error");
                //}
            //}
        //});


//
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
    public BottomNavigationView.OnNavigationItemSelectedListener navlisterner= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment= null;

            switch (item.getItemId()){

                case R.id.navigation_home:
                    selectedFragment= new HomeFragment();
                    break;

                case R.id.navigation_personalInfon:
                    selectedFragment= new PersonalInfoFragment();
                    break;

                case R.id.navigation_stepCounter:
                    selectedFragment= new StepCounterFragment();
                    break;
                case R.id.workOutPlans:
                    selectedFragment= new NotificationsFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}
