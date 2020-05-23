package com.example.myapplication3.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication3.R;
import com.example.myapplication3.firebase.FirebaseAuthentication;
import com.example.myapplication3.ui.dashboard.DashboardFragment;

public class LogInFragment extends Fragment {

    private Button signInBtn, registerBtn;
    private EditText email, password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_log_in, container, false);

        signInBtn = v.findViewById(R.id.signInBtn);
        registerBtn = v.findViewById(R.id.registerBtn);

        email = v.findViewById(R.id.email);
        password = v.findViewById(R.id.password);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Email", email.getText().toString());
                if (FirebaseAuthentication.firebaseAuth.signInExistingUser(email.getText().toString(), password.getText().toString())) {
                    FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                    DashboardFragment dashboardFragment = new DashboardFragment();
                    fragmentManager.beginTransaction().replace(R.id.main, dashboardFragment).commit();
                } else {
                    Toast.makeText(getContext(),"Login failed. Incorrect email or password",Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                }
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                CreateAccount createAccount = new CreateAccount();
                fragmentManager.beginTransaction().replace(R.id.main, createAccount).commit();
            }
        });

        return v;
    }
}
