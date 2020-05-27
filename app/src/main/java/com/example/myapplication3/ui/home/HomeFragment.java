package com.example.myapplication3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication3.R;

public class HomeFragment extends Fragment {

    EditText height, weight;
    TextView result;
    Button calculateBmi;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        height.findViewById(R.id.heigh);
        weight.findViewById(R.id.weight);
        result.findViewById(R.id.result);
        calculateBmi.findViewById(R.id.calculateBMI);


        calculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi();
            }
        });



        return root;
    }

    private void bmi(){
        float a, b, c;
        a = Float.parseFloat(height.getText().toString())/100;
        b= Float.parseFloat(weight.getText().toString());
        c= b / (a * a);

        result.setText("Your ideal weight" +c);

        if (c<=18.8){
            Toast.makeText(getContext(),"You are underweight",Toast.LENGTH_LONG);
        }
        if ((c>= 18.8) && (c<25)) {

            Toast.makeText(getContext(),"Normal weight", Toast.LENGTH_LONG);

        }
        if (c>=25){
            Toast.makeText(getContext(),"Normal weight", Toast.LENGTH_LONG);
        }
    }
}
