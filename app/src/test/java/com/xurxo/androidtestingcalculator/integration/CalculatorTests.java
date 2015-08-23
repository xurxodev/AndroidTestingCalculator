package com.xurxo.androidtestingcalculator.integration;

import com.xurxo.androidtestingcalculator.domain.AddOperation;
import com.xurxo.androidtestingcalculator.domain.Calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTests {
    @Test
    public void EnterNumberOne_EnterOperatorAdd_EnterNumberOne_Calculate_ResultShouldBeTwo(){
        Calculator calculator = new Calculator();

        calculator.enterNumber(1.0);
        calculator.enterOperation(new AddOperation());
        calculator.enterNumber(1.0);
        calculator.calculate();

        assertThat(calculator.getResult(), is(2.0));
    }

    @Test
    public void EnterNumberOne_EnterOperatorAdd_EnterNumberOne_EnterOperatorAdd_ResultShouldBeTwo(){
        Calculator calculator = new Calculator();

        calculator.enterNumber(1.0);
        calculator.enterOperation(new AddOperation());
        calculator.enterNumber(1.0);
        calculator.enterOperation(new AddOperation());

        assertThat(calculator.getResult(), is(2.0));
    }
}
