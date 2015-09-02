package com.xurxo.androidtestingcalculator.espressotests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
public class InitialStateTests {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ToStartApp_TitleShouldBeCalculator() {

        //ToolBar-> TextView
        //Search TexView inside toolbar with text calculator
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText("Calculator")));
    }

    @Test
    public void ToStartApp_DisplayShouldBeEmpty(){

        onView(withId(R.id.display_TextView))
                .check(matches(withText("")));
    }

    @Test
    public void ToStartApp_NumberButtonsShouldBeDisplayed(){
        for(int i=0; i<10; i++){
            onView(allOf(isAssignableFrom(Button.class), withText(String.valueOf(i))))
                    .check(matches(isDisplayed()));
        }
    }

    @Test
    public void ToStartApp_OperationsButtonsShouldBeDisplayed(){
        onView(allOf(isAssignableFrom(Button.class), withText("+")))
                .check(matches(isDisplayed()));

        onView(allOf(isAssignableFrom(Button.class), withText("-")))
                .check(matches(isDisplayed()));

        onView(allOf(isAssignableFrom(Button.class), withText("x")))
                .check(matches(isDisplayed()));

        onView(allOf(isAssignableFrom(Button.class), withText("/")))
                .check(matches(isDisplayed()));

        onView(allOf(isAssignableFrom(Button.class), withText("%")))
                .check(matches(isDisplayed()));

        onView(allOf(isAssignableFrom(Button.class), withText("√")))
                .check(matches(isDisplayed()));
    }
}