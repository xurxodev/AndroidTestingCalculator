package com.xurxo.androidtestingcalculator.domain;

import com.xurxo.androidtestingcalculator.domain.model.Digit;

public class CalculatorEngine {

    String operationsHistory = "";

    Digit lastDigit;
    Operation lastOperation;

    double result;
    boolean resultIsDirty = false;

    public String getOperationsHistory(){ return operationsHistory; }

    public double getResult(){ return result; }

    public void enterDigit(Digit digit)
    {
        lastDigit = digit;

        operationsHistory += digit.stringValue();
        resultIsDirty = true;
    }

    public void enterOperation(Operation operation) {
        lastOperation = operation;

        this.operationsHistory += operation.getOperator();

        if (resultIsDirty)
            calculate();
    }

    public void calculate(){
        result = lastOperation.evaluate(result,lastDigit.doubleValue());

        resultIsDirty = false;
    }
}