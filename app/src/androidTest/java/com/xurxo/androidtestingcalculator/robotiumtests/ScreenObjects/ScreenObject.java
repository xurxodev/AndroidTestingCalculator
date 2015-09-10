package com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

public abstract class ScreenObject {

    ScreenNavigator navigator = new ScreenNavigator();

    public ScreenNavigator navigation(){
        return navigator;
    }

    public void verifyTextTitle(String text) {

        //ToolBar-> TextView
        //Search TexView inside toolbar with text calculator
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(text)));
    }
}
