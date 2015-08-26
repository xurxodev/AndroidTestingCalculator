package com.xurxo.androidtestingcalculator.domain;

public class Calculator {

    Operation lastOperation;
    Double lastNumber = null;
    Double result = null;

    boolean resultIsDirty = false;

    public double getResult(){ return result; }

    public void enterNumber(double number){

        if (result != null){
            lastNumber = number;
            resultIsDirty = true;
        }
        else
            result = number;
    }

    public void enterOperation(Operation operation) {
        if (operation == null)
            throw new IllegalArgumentException("Operation can not be null");

        if (lastOperation != null) {
            if (resultIsDirty)
                calculate();

            this.lastOperation = operation;
        }
        else{
            this.lastOperation = operation;

            if (resultIsDirty)
                calculate();
        }
    }

    public void calculate(){
        if (resultIsDirty && lastOperation != null) {
            result = lastOperation.evaluate(result, lastNumber);

            lastNumber = null;
            lastOperation = null;
            resultIsDirty = false;
        }
    }
}