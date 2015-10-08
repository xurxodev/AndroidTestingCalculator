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
public class InitialStateTests {

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
    public void toStartApp_TitleShouldBeCalculator() {

        String expectedTitle = "Calculator";

        String title = calculatorScreen
                       .getTitle();

        assertThat(title, is(expectedTitle));
    }

    @Test
    public void toStartApp_DisplayShouldBeEmpty(){

        String expectedDisplay = "";

        String display =  calculatorScreen
                          .getDisplay();

        assertThat(display,is(expectedDisplay));
    }

    @Test
    public void toStartApp_NumberButtonsShouldBeDisplayed(){
        boolean buttonIsDisplayed;

        for(int i=0; i<10; i++){
            buttonIsDisplayed = calculatorScreen.buttonIsDisplayed(String.valueOf(i));

            assertThat(buttonIsDisplayed, is(true));
        }
    }

    @Test
    public void toStartApp_OperationsButtonsShouldBeDisplayed(){
        assertThat(calculatorScreen.buttonIsDisplayed("+"), is(true));

        assertThat(calculatorScreen.buttonIsDisplayed("-"), is(true));

        assertThat(calculatorScreen.buttonIsDisplayed("x"), is(true));

        assertThat(calculatorScreen.buttonIsDisplayed("/"), is(true));

        assertThat(calculatorScreen.buttonIsDisplayed("%"), is(true));

        assertThat(calculatorScreen.buttonIsDisplayed("√"), is(true));
    }

    @Test
    public void toStartApp_PositiveNegativeButtonShouldBeDisplayed(){
        assertThat(calculatorScreen.buttonIsDisplayed("+/-"), is(true));
    }

    @Test
    public void toStartApp_ClearAllButtonShouldBeDisplayed(){
        assertThat(calculatorScreen.buttonIsDisplayed("CA"), is(true));
    }

    @Test
    public void toStartApp_DotButtonShouldBeDisplayed(){
        assertThat(calculatorScreen.buttonIsDisplayed("."), is(true));
    }

    @Test
    public void toStartApp_EqualButtonShouldBeDisplayed(){
        assertThat(calculatorScreen.buttonIsDisplayed("="), is(true));
    }

}