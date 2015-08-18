package com.xurxo.androidtestingcalculator.domain;

/*This is a simple calculator with limitations , is created for educational purposes on testing
in android studio . The logic of the calculator may not be the most appropriate if your goal
was to make a real calculator.*/

import com.xurxo.androidtestingcalculator.domain.model.Digit;
import com.xurxo.androidtestingcalculator.domain.model.Operator;

public class CalculatorEngine {

    String operationsHistory = "";
    Digit lastDigit;
    Operator lastOperator;
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

    public void enterOperator(Operator operator) {
        lastOperator = operator;

        this.operationsHistory += operator.stringValue();

        if (resultIsDirty)
            evaluate();
    }

    public void calculate(){
        if (resultIsDirty)
            evaluate();
    }

    private void evaluate(){

        if (lastOperator.equals(Operator.AddOperator())){
            result += lastDigit.doubleValue();
        }

        resultIsDirty = false;
    }
}