package com.xurxo.androidtestingcalculator.domain;

public interface Operation {
    char getOperator();
    Double evaluate(Double operand1, Double operand2);
}
