package com.xurxo.androidtestingcalculator.unit.domain;

import com.xurxo.androidtestingcalculator.domain.Calculator;
import com.xurxo.androidtestingcalculator.domain.Operation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorTests {

    @Test
    public void enterNumberOne_EnterAddOperation_EnterNumberOne_EnterAddOperation_ResultShouldBeTwo(){
        Operation operationMock = mock(Operation.class);

        when(operationMock.evaluate(anyDouble(), anyDouble())).thenReturn((double) 3);

        double expectedValue = (double) 3;

        Calculator calculator = new Calculator();

        calculator.enterNumber(1.0);
        calculator.enterOperation(operationMock);
        calculator.enterNumber(2.0);
        calculator.enterOperation(operationMock);

        verify(operationMock,times(2)).evaluate(anyDouble(),anyDouble());

        assertThat(calculator.getResult(), is(expectedValue));
    }

    @Test
    public void enterNumberOne_EnterAddOperation_EnterNumberOne_Calculate_ResultShouldBeTwo(){
        Operation operationMock = mock(Operation.class);

        when(operationMock.evaluate(anyDouble(),anyDouble())).thenReturn((double) 3);

        double expectedValue = (double) 3;

        Calculator calculator = new Calculator();

        calculator.enterNumber(1.0);
        calculator.enterOperation(operationMock);
        calculator.enterNumber(2.0);
        calculator.calculate();

        verify(operationMock,times(2)).evaluate(anyDouble(),anyDouble());

        assertThat(calculator.getResult(), is(expectedValue));
        }

    @Rule
    public ExpectedException expectedOperatorException = ExpectedException.none();

    @Test
    public void EnterNullOperation_ShouldThrowIllealArgumenException(){
        expectedOperatorException.expect(IllegalArgumentException.class);
        expectedOperatorException.expectMessage("Operation can not be null");

        Calculator calculator = new Calculator();

        calculator.enterOperation(null);

    }
}
