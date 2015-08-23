package com.xurxo.androidtestingcalculator.domain;

public class Calculator {

    Operation lastOperation;
    Double lastNumber = null;
    double result = 0.0;

    boolean resultIsDirty = false;

    public double getResult(){ return result; }

    public void enterNumber(double number){
        lastNumber = number;
        resultIsDirty = true;
    }

    public void enterOperation(Operation operation) {
        if (operation == null)
            throw new IllegalArgumentException("Operation can not be null");

        this.lastOperation = operation;

        if (resultIsDirty)
            calculate();
    }

    public void calculate(){
        result = lastOperation.evaluate(result,lastNumber);

        resultIsDirty = false;
    }
}