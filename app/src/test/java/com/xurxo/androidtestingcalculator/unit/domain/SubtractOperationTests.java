package com.xurxo.androidtestingcalculator.unit.domain;

import com.xurxo.androidtestingcalculator.domain.Operation;
import com.xurxo.androidtestingcalculator.domain.SubtractOperation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SubtractOperationTests {
    @Test
    public void evaluateTenSubtractSix_ShouldReturnFour(){

        double operand1 = 10;
        double operand2 = 6;
        double expectedResult = 4;

        Operation subtractOperation = new SubtractOperation();

        double result = subtractOperation.evaluate(operand1,operand2);

        assertThat(result, is(expectedResult));
    }

    @Test
    public void getOperator_ShouldBeMinus(){

        char expectedOperator = '-';

        Operation subtractOperation = new SubtractOperation();

        assertThat(subtractOperation.getOperator(), is(expectedOperator));
    }
}
