package com.xurxo.androidtestingcalculator.domain;

public class AddOperation implements Operation {
    @Override
    public char getOperator() {
        return '+';
    }

    @Override
    public Double evaluate(Double operand1, Double operand2) {
        return operand1 + operand2;
    }

}
