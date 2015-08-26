package com.xurxo.androidtestingcalculator.integration;

import com.xurxo.androidtestingcalculator.domain.AddOperation;
import com.xurxo.androidtestingcalculator.domain.Calculator;
import com.xurxo.androidtestingcalculator.domain.SubtractOperation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTests {
    @Test
    public void EnterNumberOne_EnterAddOperation_EnterNumberOne_Calculate_ResultShouldBeTwo(){
        Calculator calculator = new Calculator();

        calculator.enterNumber(1.0);
        calculator.enterOperation(new AddOperation());
        calculator.enterNumber(1.0);
        calculator.calculate();

        assertThat(calculator.getResult(), is(2.0));
    }

    @Test
    public void EnterNumberOne_EnterAddOperation_EnterNumberOne_EnterOperatorAdd_ResultShouldBeTwo(){
        Calculator calculator = new Calculator();

        calculator.enterNumber(1.0);
        calculator.enterOperation(new AddOperation());
        calculator.enterNumber(1.0);
        calculator.enterOperation(new AddOperation());

        assertThat(calculator.getResult(), is(2.0));
    }

    @Test
    public void EnterNumberTen_EnterSubtractOperation_EnterNumberOne_Calculate_ResultShouldBeNine(){
        Calculator calculator = new Calculator();

        calculator.enterNumber(10.0);
        calculator.enterOperation(new SubtractOperation());
        calculator.enterNumber(1.0);
        calculator.calculate();

        assertThat(calculator.getResult(), is(9.0));
    }

    @Test
    public void EnterNumberTen_EnterSubtractOperation_EnterNumberOne_EnterOperatorAdd_ResultShouldBeNine(){
        Calculator calculator = new Calculator();

        calculator.enterNumber(10.0);
        calculator.enterOperation(new SubtractOperation());
        calculator.enterNumber(1.0);
        calculator.enterOperation(new AddOperation());

        assertThat(calculator.getResult(), is(9.0));
    }

    @Test
    public void enterNumberFive_EnterAddOperation_EnterNumberThree_Calculate_EnterAddOperation__EnterNumberOne_Calculate_ResultShouldReturnine(){
        double expectedValue = 9.0;

        Calculator calculator = new Calculator();

        calculator.enterNumber(5.0);
        calculator.enterOperation(new AddOperation());
        calculator.enterNumber(3.0);
        calculator.calculate();
        calculator.enterOperation(new AddOperation());
        calculator.enterNumber(1.0);
        calculator.calculate();

        assertThat(calculator.getResult(), is(expectedValue));
    }
}
