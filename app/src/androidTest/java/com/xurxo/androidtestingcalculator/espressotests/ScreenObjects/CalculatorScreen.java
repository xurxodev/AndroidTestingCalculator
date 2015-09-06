package com.xurxo.androidtestingcalculator.espressotests.ScreenObjects;


import android.support.test.rule.ActivityTestRule;
import android.widget.Button;

import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import org.junit.Rule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

public class CalculatorScreen extends ScreenObject {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class,true,false);

    public CalculatorScreen start(){
        mainActivityRule.launchActivity(null);

        return this;
    }

    public CalculatorScreen pressNumber(String number){
        onView(withText(number))
                .perform(click());

        return this;
    }

    public CalculatorScreen pressOperation(String operator){
        onView(withText(operator))
                .perform(click());

        return this;
    }

    public CalculatorScreen pressEqual(){
        onView(withId(R.id.equal_button))
                .perform(click());

        return this;
    }

    public AboutScreen navigateToAbout(){
        navigation().open();

        navigation().to(AboutScreen.class,2);

        return new AboutScreen();
    }

    public CalculatorScreen verifyButtonIsDisplayed(String text){
        onView(allOf(isAssignableFrom(Button.class), withText(text)))
                .check(matches(isDisplayed()));

        return this;
    }

    public CalculatorScreen verifyTextDisplay(String text){
        onView(withId(R.id.display_TextView))
                .check(matches(withText(text)));

        return this;
    }
}
