package com.xurxo.androidtestingcalculator.presentation.fragments;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xurxo.androidtestingcalculator.R;

public class AboutFragment extends Fragment {

    TextView appNameAndVersion;
    TextView description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;

        getActivity().setTitle(getResources().getString(R.string.about_fragment_title));

        rootView = inflater.inflate(R.layout.fragment_about, container, false);

        appNameAndVersion = (TextView)
                rootView.findViewById(R.id.about_app_name_and_version);


        description = (TextView)
                rootView.findViewById(R.id.about_description);

        setContent();

        return  rootView;
    }

    public void setContent(){
        String appName = getResources().getString(R.string.app_name);
        String version = "";

        try {
            version = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        appNameAndVersion.setText(String.format("%s %s",appName,version));
        description.setText(getResources().getString(R.string.about_description));
    }
}
