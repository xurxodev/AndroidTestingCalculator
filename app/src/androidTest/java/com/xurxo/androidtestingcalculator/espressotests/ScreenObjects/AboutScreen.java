package com.xurxo.androidtestingcalculator.espressotests.ScreenObjects;

import com.xurxo.androidtestingcalculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AboutScreen extends ScreenObject {
    public AboutScreen verifyNameAndVersionIsDisplayed(){
        onView(withId(R.id.about_app_name_and_version))
                .check(matches(isDisplayed()));

        return this;
    }

    public AboutScreen verifyDescriptionIsDisplayed(){
        onView(withId(R.id.about_description))
                .check(matches(isDisplayed()));

        return this;
    }
}
