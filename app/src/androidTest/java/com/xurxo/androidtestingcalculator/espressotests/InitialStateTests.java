package com.xurxo.androidtestingcalculator.espressotests;

import android.support.test.runner.AndroidJUnit4;

import com.xurxo.androidtestingcalculator.espressotests.ScreenObjects.CalculatorScreen;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InitialStateTests {

    @Test
    public void toStartApp_TitleShouldBeCalculator() {

        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .verifyTextTitle("Calculator");
    }

    @Test
    public void toStartApp_DisplayShouldBeEmpty(){

        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .verifyTextDisplay("");
    }

    @Test
    public void toStartApp_NumberButtonsShouldBeDisplayed(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start();

        for(int i=0; i<10; i++){
            calculatorScreen.verifyButtonIsDisplayed(String.valueOf(i));
        }
    }

    @Test
    public void toStartApp_OperationsButtonsShouldBeDisplayed(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .verifyButtonIsDisplayed("+")
                .verifyButtonIsDisplayed("-")
                .verifyButtonIsDisplayed("x")
                .verifyButtonIsDisplayed("/")
                .verifyButtonIsDisplayed("%")
                .verifyButtonIsDisplayed("√");
    }

    @Test
    public void toStartApp_PositiveNegativeiveButtonShouldBeDisplayed(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .verifyButtonIsDisplayed("+/-");
    }

    @Test
    public void toStartApp_ClearAllButtonShouldBeDisplayed(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .verifyButtonIsDisplayed("CA");
    }

    @Test
    public void ToStartApp_DotButtonShouldBeDisplayed(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .verifyButtonIsDisplayed(".");
    }

    @Test
    public void ToStartApp_EqualButtonShouldBeDisplayed(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .verifyButtonIsDisplayed("=");
    }
}