package com.xurxo.androidtestingcalculator.espressotests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class CalculationTests {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void PressOne_PressAdd_PressTwo_PressEqual_DisplayShouldShowThree(){
        onView(withId(R.id.one_button))
                .perform(click());

        onView(withId(R.id.add_button))
                .perform(click());

        onView(withId(R.id.two_button))
                .perform(click());

        onView(withId(R.id.equal_button))
                .perform(click());

        onView(withId(R.id.display_TextView))
                .check(matches(withText("3")));
    }

    @Test
    public void PressThree_PressAdd_PressFour_PressAdd_PressFive_PressAdd_PressSix_PressEqual_DisplayShouldShowEighteen(){
        onView(withId(R.id.three_button))
                .perform(click());

        onView(withId(R.id.add_button))
                .perform(click());

        onView(withId(R.id.four_button))
                .perform(click());

        onView(withId(R.id.add_button))
                .perform(click());

        onView(withId(R.id.five_button))
                .perform(click());

        onView(withId(R.id.add_button))
                .perform(click());

        onView(withId(R.id.six_button))
                .perform(click());

        onView(withId(R.id.equal_button))
                .perform(click());

        onView(withId(R.id.display_TextView))
                .check(matches(withText("18")));
    }

    @Test
    public void PressNine_PressSubtract_PressEight_PressEqual_DisplayShouldShowOne(){
        onView(withId(R.id.nine_button))
                .perform(click());

        onView(withId(R.id.subtract_button))
                .perform(click());

        onView(withId(R.id.eight_button))
                .perform(click());

        onView(withId(R.id.equal_button))
                .perform(click());

        onView(withId(R.id.display_TextView))
                .check(matches(withText("1")));
    }


    @Test
    public void PressNine_PressSubtract_PressOne_PressSubtract_PressTwo_PressSubtract_PressEight_PressEqual_DisplayShouldShowMinusTwo(){
        onView(withId(R.id.nine_button))
                .perform(click());

        onView(withId(R.id.subtract_button))
                .perform(click());

        onView(withId(R.id.one_button))
                .perform(click());

        onView(withId(R.id.subtract_button))
                .perform(click());

        onView(withId(R.id.two_button))
                .perform(click());

        onView(withId(R.id.subtract_button))
                .perform(click());

        onView(withId(R.id.eight_button))
                .perform(click());

        onView(withId(R.id.equal_button))
                .perform(click());

        onView(withId(R.id.display_TextView))
                .check(matches(withText("-2")));
    }

    @Test
    public void PressOne_PressAdd_PressNine_PressSubtract_PressFour_PressEqual_DisplayShouldShowSix(){
        onView(withId(R.id.one_button))
                .perform(click());

        onView(withId(R.id.add_button))
                .perform(click());

        onView(withId(R.id.nine_button))
                .perform(click());

        onView(withId(R.id.subtract_button))
                .perform(click());

        onView(withId(R.id.four_button))
                .perform(click());

        onView(withId(R.id.equal_button))
                .perform(click());

        onView(withId(R.id.display_TextView))
                .check(matches(withText("6")));
    }
}
