package com.xurxo.androidtestingcalculator.domain;

public interface Operation {
    String getOperator();
    Double evaluate(Double operator1, Double operator2);
}
