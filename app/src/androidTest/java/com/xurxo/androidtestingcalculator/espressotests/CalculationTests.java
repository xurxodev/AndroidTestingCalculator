package com.xurxo.androidtestingcalculator.espressotests;

import android.support.test.runner.AndroidJUnit4;

import com.xurxo.androidtestingcalculator.espressotests.ScreenObjects.CalculatorScreen;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CalculationTests {

    @Test
    public void pressOne_PressAdd_PressTwo_PressEqual_DisplayShouldShowThree(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .pressNumber("1")
                .pressOperation("+")
                .pressNumber("2")
                .pressEqual()
                .verifyTextDisplay("3");
    }

    @Test
    public void pressThree_PressAdd_PressFour_PressAdd_PressFive_PressAdd_PressSix_PressEqual_DisplayShouldShowEighteen(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .pressNumber("3")
                .pressOperation("+")
                .pressNumber("4")
                .pressOperation("+")
                .pressNumber("5")
                .pressOperation("+")
                .pressNumber("6")
                .pressEqual()
                .verifyTextDisplay("18");
    }

    @Test
    public void pressNine_PressSubtract_PressEight_PressEqual_DisplayShouldShowOne(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .pressNumber("9")
                .pressOperation("-")
                .pressNumber("8")
                .pressEqual()
                .verifyTextDisplay("1");
    }


    @Test
    public void pressNine_PressSubtract_PressOne_PressSubtract_PressTwo_PressSubtract_PressEight_PressEqual_DisplayShouldShowMinusTwo(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .pressNumber("9")
                .pressOperation("-")
                .pressNumber("1")
                .pressOperation("-")
                .pressNumber("2")
                .pressOperation("-")
                .pressNumber("8")
                .pressEqual()
                .verifyTextDisplay("-2");
    }

    @Test
    public void pressOne_PressAdd_PressNine_PressSubtract_PressFour_PressEqual_DisplayShouldShowSix(){
        CalculatorScreen calculatorScreen = new CalculatorScreen();

        calculatorScreen
                .start()
                .pressNumber("1")
                .pressOperation("+")
                .pressNumber("9")
                .pressOperation("-")
                .pressNumber("4")
                .pressEqual()
                .verifyTextDisplay("6");
    }
}
