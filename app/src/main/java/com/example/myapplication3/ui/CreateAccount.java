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
import com.example.myapplication3.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAccount extends Fragment {

    EditText name,email,password;
    Button createAccount;



    Button button;
    public CreateAccount() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_account, container, false);

        name.findViewById(R.id.name);
        email.findViewById(R.id.emailAccount);
        button.findViewById(R.id.createAccount);


createAccount.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

      FirebaseAuthentication firebaseAuthentication = new FirebaseAuthentication();
        firebaseAuthentication.signInExistingUser(email.getText().toString(),password.getText().toString());

        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.createAccount, homeFragment).commit();

    }
});

        return v;
    }

    public void registerUser(){

    }
}
