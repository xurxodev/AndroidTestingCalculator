package com.xurxo.androidtestingcalculator.robotiumtests;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.robotium.solo.Solo;
import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class CalculationTests {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    private Solo solo;

    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), mainActivityRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    @Test
    public void pressOne_PressAdd_PressTwo_PressEqual_DisplayShouldShowThree(){
        solo.clickOnView(solo.getView(R.id.one_button));

        solo.clickOnView(solo.getView(R.id.add_button));

        solo.clickOnView(solo.getView(R.id.two_button));

        solo.clickOnView(solo.getView(R.id.equal_button));

        String display = (String)((TextView) solo.getView(R.id.display_TextView)).getText();

        assertThat(display, is("3"));
    }

    @Test
    public void pressThree_PressAdd_PressFour_PressAdd_PressFive_PressAdd_PressSix_PressEqual_DisplayShouldShowEighteen(){
        solo.clickOnView(solo.getView(R.id.three_button));

        solo.clickOnView(solo.getView(R.id.add_button));

        solo.clickOnView(solo.getView(R.id.four_button));

        solo.clickOnView(solo.getView(R.id.add_button));

        solo.clickOnView(solo.getView(R.id.five_button));

        solo.clickOnView(solo.getView(R.id.add_button));

        solo.clickOnView(solo.getView(R.id.six_button));

        solo.clickOnView(solo.getView(R.id.equal_button));

        String display = (String)((TextView) solo.getView(R.id.display_TextView)).getText();

        assertThat(display, is("18"));
    }

    @Test
    public void pressNine_PressSubtract_PressEight_PressEqual_DisplayShouldShowOne(){
        solo.clickOnView(solo.getView(R.id.nine_button));

        solo.clickOnView(solo.getView(R.id.subtract_button));

        solo.clickOnView(solo.getView(R.id.eight_button));

        solo.clickOnView(solo.getView(R.id.equal_button));

        String display = (String)((TextView) solo.getView(R.id.display_TextView)).getText();

        assertThat(display, is("1"));
    }


    @Test
    public void pressNine_PressSubtract_PressOne_PressSubtract_PressTwo_PressSubtract_PressEight_PressEqual_DisplayShouldShowMinusTwo(){
        solo.clickOnView(solo.getView(R.id.nine_button));

        solo.clickOnView(solo.getView(R.id.subtract_button));

        solo.clickOnView(solo.getView(R.id.one_button));

        solo.clickOnView(solo.getView(R.id.subtract_button));

        solo.clickOnView(solo.getView(R.id.two_button));

        solo.clickOnView(solo.getView(R.id.subtract_button));

        solo.clickOnView(solo.getView(R.id.eight_button));

        solo.clickOnView(solo.getView(R.id.equal_button));

        String display = (String)((TextView) solo.getView(R.id.display_TextView)).getText();

        assertThat(display, is("-2"));
    }

    @Test
    public void pressOne_PressAdd_PressNine_PressSubtract_PressFour_PressEqual_DisplayShouldShowSix(){
        solo.clickOnView(solo.getView(R.id.one_button));

        solo.clickOnView(solo.getView(R.id.add_button));

        solo.clickOnView(solo.getView(R.id.nine_button));

        solo.clickOnView(solo.getView(R.id.subtract_button));

        solo.clickOnView(solo.getView(R.id.four_button));

        solo.clickOnView(solo.getView(R.id.equal_button));

        String display = (String)((TextView) solo.getView(R.id.display_TextView)).getText();

        assertThat(display, is("6"));
    }
}
