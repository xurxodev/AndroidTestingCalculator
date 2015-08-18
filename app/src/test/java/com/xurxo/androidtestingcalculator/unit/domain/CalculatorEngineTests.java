package com.xurxo.androidtestingcalculator.unit.domain;

import com.xurxo.androidtestingcalculator.domain.CalculatorEngine;
import com.xurxo.androidtestingcalculator.domain.model.Digit;
import com.xurxo.androidtestingcalculator.domain.model.Operator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorEngineTests {
    @Test
    public void enterDigitOne_EnterOperatorAdd_EnterDigitOne_OperationsHistoryShouldBeOK(){
        CalculatorEngine calculator = new CalculatorEngine();

        calculator.enterDigit(new Digit("1"));
        calculator.enterOperator(new Operator('+'));
        calculator.enterDigit(new Digit("1"));

        assertThat(calculator.getOperationsHistory(), is("1+1"));
    }

    @Test
    public void enterDigitOne_PressOperatorAdd_EnterDigitOne_Calculate_ResultShouldBeTwo(){
        CalculatorEngine calculator = new CalculatorEngine();

        calculator.enterDigit(new Digit("1"));
        calculator.enterOperator(Operator.AddOperator());
        calculator.enterDigit(new Digit("1"));
        calculator.calculate();

        assertThat(calculator.getResult(), is((double) 2));
    }

}
