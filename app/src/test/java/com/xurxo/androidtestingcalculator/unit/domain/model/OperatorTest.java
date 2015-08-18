package com.xurxo.androidtestingcalculator.unit.domain.model;

import com.xurxo.androidtestingcalculator.domain.exception.InvalidOperatorCharacterException;
import com.xurxo.androidtestingcalculator.domain.model.Operator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OperatorTest {
    @Rule
    public ExpectedException expectedOperatorException = ExpectedException.none();

    @Test
    public void createOperatoWithWrongCharacter_ShouldThrowNumberFormatException(){
        expectedOperatorException.expect( InvalidOperatorCharacterException.class );

        Operator operator = new Operator('~');
    }

    @Test
    public void AddOperator_IsEqualTo_AddOperator(){

        Operator operatorA = new Operator('+');
        Operator operatorB = new Operator('+');

        assertThat(operatorA, is(operatorB));
    }

    @Test
    public void AddOperator_NotIsEqualTo_SubstractOperator(){

        Operator operatorA = new Operator('+');
        Operator operatorB = new Operator('-');

        assertThat(operatorA, not(operatorB));
    }
}
