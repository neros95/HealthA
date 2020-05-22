package com.example.myapplication3.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication3.Main2Activity;
import com.example.myapplication3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAccount extends Fragment {

    Button button;
    public CreateAccount() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_create_account, container, false);

        return view;
    }
}
