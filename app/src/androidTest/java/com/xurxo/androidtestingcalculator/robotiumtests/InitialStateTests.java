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

    /*
    @Test
    public void toStartApp_NumberButtonsShouldBeDisplayed(){
        Button expectedButton;

        for(int i=0; i<10; i++){
            expectedButton = solo.getButton(String.valueOf(i),true);

            assertThat(expectedButton, notNullValue());
        }
    }

    @Test
    public void toStartApp_OperationsButtonsShouldBeDisplayed(){
        assertThat(solo.getButton("+",true), notNullValue());

        assertThat(solo.getButton("-",true), notNullValue());

        assertThat(solo.getButton("x", true), notNullValue());

        assertThat(solo.getButton("/", true), notNullValue());

        assertThat(solo.getButton("%", true), notNullValue());

        assertThat(solo.getButton("√", true), notNullValue());
    }

    @Test
    public void toStartApp_PositiveNegativeButtonShouldBeDisplayed(){
        assertThat(solo.getButton("+/-", true), notNullValue());
    }

    @Test
    public void toStartApp_ClearAllButtonShouldBeDisplayed(){
        assertThat(solo.getButton("CA", true), notNullValue());
    }

    @Test
    public void toStartApp_DotButtonShouldBeDisplayed(){
        assertThat(solo.getButton(".", true), notNullValue());
    }

    @Test
    public void toStartApp_EqualButtonShouldBeDisplayed(){
        assertThat(solo.getButton("=", true), notNullValue());
    }

*/

}