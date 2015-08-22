package com.xurxo.androidtestingcalculator.unit.domain;

import com.xurxo.androidtestingcalculator.domain.AddOperation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddOperationTests {
    @Test
    public void evaluateOneAddOne_ShouldReturnTwo(){

        double operand1 = 1;
        double operand2 = 1;
        double expectedResult = 2;

        AddOperation addOperation = new AddOperation();

        double result = addOperation.evaluate(operand1,operand2);

        assertThat(result, is(expectedResult));
    }

}
