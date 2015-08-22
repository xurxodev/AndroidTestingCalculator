package com.xurxo.androidtestingcalculator.unit.domain;

import com.xurxo.androidtestingcalculator.domain.CalculatorEngine;
import com.xurxo.androidtestingcalculator.domain.Operation;
import com.xurxo.androidtestingcalculator.domain.model.Digit;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorEngineTests {

    @Test
    public void enterDigitOne_EnterOperatorAdd_EnterDigitOne_OperationsHistoryShouldBeOK(){
        Digit digitOneStub = mock(Digit.class);
        Digit digitTwoStub = mock(Digit.class);
        Operation operationStub = mock(Operation.class);

        when(digitOneStub.stringValue()).thenReturn("1");
        when(digitTwoStub.stringValue()).thenReturn("2");
        when(operationStub.getOperator()).thenReturn('+');

        String expectedValue = "1+2";

        CalculatorEngine calculator = new CalculatorEngine();

        calculator.enterDigit(digitOneStub);
        calculator.enterOperation(operationStub);
        calculator.enterDigit(digitTwoStub);

        assertThat(calculator.getOperationsHistory(), is(expectedValue));
    }

    @Test
    public void enterDigitOne_PressOperatorAdd_EnterDigitOne_Calculate_ResultShouldBeTwo(){
        Digit digitOneStub = mock(Digit.class);
        Digit digitTwoStub = mock(Digit.class);
        Operation operationMock = mock(Operation.class);

        when(digitOneStub.doubleValue()).thenReturn(1.0);
        when(digitTwoStub.doubleValue()).thenReturn((double) 2);
        when(operationMock.evaluate(anyDouble(),anyDouble())).thenReturn((double) 3);

        double expectedValue = (double) 3;

        CalculatorEngine calculator = new CalculatorEngine();

        calculator.enterDigit(digitOneStub);
        calculator.enterOperation(operationMock);
        calculator.enterDigit(digitTwoStub);
        calculator.calculate();

        verify(operationMock).evaluate(anyDouble(),anyDouble());

        assertThat(calculator.getResult(), is(expectedValue));
        }
    }
