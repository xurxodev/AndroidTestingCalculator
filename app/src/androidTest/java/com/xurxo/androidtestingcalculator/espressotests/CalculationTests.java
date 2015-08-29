package com.xurxo.androidtestingcalculator.espressotests;

import android.support.test.rule.ActivityTestRule;

import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.unit.fragments.presentation.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class CalculationTests {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ClickButtonOne_DisplayShouldShowOne(){
        onView(withId(R.id.one_button))
                .perform(click());

        onView(withId(R.id.display_TextView))
                .check(matches(withText("1")));


    }
}
