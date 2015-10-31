package com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.robotium.solo.Solo;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import org.junit.Rule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

public abstract class ScreenObject {

    @Rule
    protected ActivityTestRule<MainActivity> mainActivityRule;

    protected Solo solo;

    ScreenNavigator navigator ;

    public ScreenNavigator navigation(){
        return navigator;
    }


    public String getTitle() {
        return (String) mainActivityRule.getActivity().getTitle();
    }
}
