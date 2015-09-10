package com.xurxo.androidtestingcalculator.robotiumtests;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(AndroidJUnit4.class)
public class InitialStateTests {

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
    public void ToStartApp_TitleShouldBeCalculator() {

        String expectedTitle = "Calculator";

        String title = (String) mainActivityRule.getActivity().getTitle();

        assertThat(title, is(expectedTitle));
    }

    @Test
    public void ToStartApp_DisplayShouldBeEmpty(){

        String expectedDisplay = "";

        String display = (String) ((TextView) solo.getView(R.id.display_TextView)).getText();

        assertThat(display,is(expectedDisplay));
    }

    @Test
    public void ToStartApp_NumberButtonsShouldBeDisplayed(){
        Button expectedButton;

        for(int i=0; i<10; i++){
            expectedButton = solo.getButton(String.valueOf(i),true);

            assertThat(expectedButton, notNullValue());
        }
    }

    @Test
    public void ToStartApp_OperationsButtonsShouldBeDisplayed(){
        assertThat(solo.getButton("+",true), notNullValue());

        assertThat(solo.getButton("-",true), notNullValue());

        assertThat(solo.getButton("x", true), notNullValue());

        assertThat(solo.getButton("/", true), notNullValue());

        assertThat(solo.getButton("%", true), notNullValue());

        assertThat(solo.getButton("√", true), notNullValue());
    }

    @Test
    public void ToStartApp_PositiveNegativeButtonShouldBeDisplayed(){
        assertThat(solo.getButton("+/-", true), notNullValue());
    }

    @Test
    public void ToStartApp_ClearAllButtonShouldBeDisplayed(){
        assertThat(solo.getButton("CA", true), notNullValue());
    }

    @Test
    public void ToStartApp_DotButtonShouldBeDisplayed(){
        assertThat(solo.getButton(".", true), notNullValue());
    }

    @Test
    public void ToStartApp_EqualButtonShouldBeDisplayed(){
        assertThat(solo.getButton("=", true), notNullValue());
    }



}