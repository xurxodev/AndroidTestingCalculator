package com.xurxo.androidtestingcalculator.robotiumtests;

import android.support.test.runner.AndroidJUnit4;

import com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects.CalculatorScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class CalculationTests {

    CalculatorScreen calculatorScreen;

    @Before
    public void setUp() throws Exception {
        calculatorScreen = new CalculatorScreen();

        calculatorScreen.start();
    }

    @After
    public void tearDown() throws Exception {
        calculatorScreen.finish();
    }

    @Test
    public void pressOne_PressAdd_PressTwo_PressEqual_DisplayShouldShowThree(){
        calculatorScreen
                .pressNumber("1")
                .pressOperation("+")
                .pressNumber("2")
                .pressEqual();

        assertThat(calculatorScreen.getDisplay(), is("3"));
    }

    @Test
    public void pressThree_PressAdd_PressFour_PressAdd_PressFive_PressAdd_PressSix_PressEqual_DisplayShouldShowEighteen(){
        calculatorScreen
                .pressNumber("3")
                .pressOperation("+")
                .pressNumber("4")
                .pressOperation("+")
                .pressNumber("5")
                .pressOperation("+")
                .pressNumber("6")
                .pressEqual();

        assertThat(calculatorScreen.getDisplay(), is("18"));
    }

    @Test
    public void pressNine_PressSubtract_PressEight_PressEqual_DisplayShouldShowOne(){
        calculatorScreen
                .pressNumber("9")
                .pressOperation("-")
                .pressNumber("8")
                .pressEqual();

        assertThat(calculatorScreen.getDisplay(), is("1"));
    }

    @Test
    public void pressNine_PressSubtract_PressOne_PressSubtract_PressTwo_PressSubtract_PressEight_PressEqual_DisplayShouldShowMinusTwo(){
        calculatorScreen
                .pressNumber("9")
                .pressOperation("-")
                .pressNumber("1")
                .pressOperation("-")
                .pressNumber("2")
                .pressOperation("-")
                .pressNumber("8")
                .pressEqual();

        assertThat(calculatorScreen.getDisplay(), is("-2"));
    }

    @Test
    public void pressOne_PressAdd_PressNine_PressSubtract_PressFour_PressEqual_DisplayShouldShowSix(){
        calculatorScreen
                .pressNumber("1")
                .pressOperation("+")
                .pressNumber("9")
                .pressOperation("-")
                .pressNumber("4")
                .pressEqual();

        assertThat(calculatorScreen.getDisplay(), is("6"));
    }
}
