package com.example.myapplication3.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication3.R;
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


    private FirebaseAuth mAuth;

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
        mAuth= FirebaseAuth.getInstance();



        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(getActivity(), "User Registration Successful", Toast.LENGTH_SHORT).show();

                            //asd
                        }
                    }
                });
            }
        });


        return v;
    }

    public void registerUser(){

    }
}
