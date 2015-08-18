package com.xurxo.androidtestingcalculator.presentation.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xurxo.androidtestingcalculator.R;

public class CalculatorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return rootView;
        return inflater.inflate(R.layout.fragment_calculator, container, false);

    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


    }
}
