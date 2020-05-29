package com.example.myapplication3.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication3.R;
import com.example.myapplication3.firebase.FirebaseAuthentication;
import com.example.myapplication3.ui.dashboard.DashboardFragment;
import com.example.myapplication3.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAccount extends Fragment {

    EditText  emailAccount, password;
    Button createAccount;


    public CreateAccount() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_account, container, false);

        emailAccount = v.findViewById(R.id.emailAccount);
        password = v.findViewById(R.id.passwordAccount);
        createAccount = v.findViewById(R.id.createAccount);


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean login;

                System.out.println(emailAccount.getText().toString());
                System.out.println(password.getText().toString());

                FirebaseAuthentication firebaseAuthentication= new FirebaseAuthentication();
                login= firebaseAuthentication.signInNewUser(emailAccount.getText().toString(), password.getText().toString());
                System.out.println(login);
                //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                //DashboardFragment dashboardFragment= new DashboardFragment();
                //fragmentManager.beginTransaction().replace(R.id.main, dashboardFragment).commit();

            }
        });

        return v;
    }

    public void registerUser() {

    }
}
