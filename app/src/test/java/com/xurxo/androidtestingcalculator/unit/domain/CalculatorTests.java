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
    public void enterNumberOne_EnterOperation_EnterNumberOne_EnterAddOperation_ResultShouldBeTwo(){
        Operation operationMock = mock(Operation.class);

        when(operationMock.evaluate(anyDouble(), anyDouble())).thenReturn(3.0);

        double expectedValue = 3.0;

        Calculator calculator = new Calculator();

        calculator.enterNumber(1.0);
        calculator.enterOperation(operationMock);
        calculator.enterNumber(2.0);
        calculator.enterOperation(operationMock);

        verify(operationMock,times(1)).evaluate(anyDouble(),anyDouble());

        assertThat(calculator.getResult(), is(expectedValue));
    }

    @Test
    public void enterNumberOne_EnterOperation_EnterNumberOne_Calculate_ResultShouldBeTwo(){
        Operation operationMock = mock(Operation.class);

        when(operationMock.evaluate(anyDouble(),anyDouble())).thenReturn((double) 3);

        double expectedValue = (double) 3;

        Calculator calculator = new Calculator();

        calculator.enterNumber(1.0);
        calculator.enterOperation(operationMock);
        calculator.enterNumber(2.0);
        calculator.calculate();

        verify(operationMock,times(1)).evaluate(anyDouble(),anyDouble());

        assertThat(calculator.getResult(), is(expectedValue));
     }

    @Test
    public void enterNumber_EnterOperation_EnterNumber_Calculate_EnterOperation__EnterNumber_Calculate_ResultShouldWork(){
        Operation operation1Mock = mock(Operation.class);
        Operation operation2Mock = mock(Operation.class);

        when(operation1Mock.evaluate(anyDouble(),anyDouble())).thenReturn((double) 8);
        when(operation2Mock.evaluate(anyDouble(),anyDouble())).thenReturn((double) 9);

        double expectedValue = (double) 9;

        Calculator calculator = new Calculator();

        calculator.enterNumber(5.0);
        calculator.enterOperation(operation1Mock);
        calculator.enterNumber(3.0);
        calculator.calculate();
        calculator.enterOperation(operation2Mock);
        calculator.enterNumber(1.0);
        calculator.calculate();

        verify(operation1Mock,times(1)).evaluate(anyDouble(),anyDouble());

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
