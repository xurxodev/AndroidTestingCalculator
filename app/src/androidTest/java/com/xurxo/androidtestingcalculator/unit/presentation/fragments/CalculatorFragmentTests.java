package com.xurxo.androidtestingcalculator.unit.presentation.fragments;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.unit.fragments.presentation.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class CalculatorFragmentTests {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void customIntentToStartActivity() {

        Button equalButton = (Button) mainActivityRule.getActivity().findViewById(R.id.equal_button);

        assertThat(equalButton.getText().toString(), is("="));
    }
}
