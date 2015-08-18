package com.xurxo.androidtestingcalculator.unit.domain.model;

import com.xurxo.androidtestingcalculator.domain.exception.InvalidDigitFormatException;
import com.xurxo.androidtestingcalculator.domain.model.Digit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DigitTest {
    @Rule
    public ExpectedException expectedDigitException = ExpectedException.none();

    @Test
    public void createDigitWithWrongFormatNumber_ShouldThrowInvalidDigitFormatException(){
        expectedDigitException.expect(InvalidDigitFormatException.class);

        Digit digit = new Digit("5.5.5");
    }
}
