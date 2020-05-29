package com.example.myapplication3.ui.stepCounter;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.myapplication3.R;

public class StepCounterFragment extends Fragment {

    private StepCounterViewModel mViewModel;
    ProgressBar stepCounter;
    public static StepCounterFragment newInstance() {
        return new StepCounterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.step_counter_fragment, container, false);

       stepCounter = view.findViewById(R.id.stepCounter);

       return  view;
    }


}
