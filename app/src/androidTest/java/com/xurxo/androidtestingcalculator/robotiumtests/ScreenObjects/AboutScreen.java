package com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects;

import android.support.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;
import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;

public class AboutScreen extends ScreenObject {


    public AboutScreen(ActivityTestRule<MainActivity> mainActivityRule, Solo solo) {
        this.solo = solo;
        this.mainActivityRule = mainActivityRule;
    }

    public boolean NameAndVersionIsDisplayed(){

        return solo.getView(R.id.about_app_name_and_version).isShown();
    }

    public boolean DescriptionIsDisplayed(){
        return  solo.getView(R.id.about_description).isShown();
    }
}
