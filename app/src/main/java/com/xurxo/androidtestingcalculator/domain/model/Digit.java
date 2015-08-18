package com.xurxo.androidtestingcalculator.domain.model;

import com.xurxo.androidtestingcalculator.domain.exception.InvalidDigitFormatException;

public class Digit {
    private String value;
    private double doubleValue;

    public Digit(String value){
        doubleValue = parseDigit(value);
        this.value = value;
    }

    public Double parseDigit(String number){
        try {
            return Double.parseDouble(number);
        }
        catch (NumberFormatException ex){
            throw  new InvalidDigitFormatException("Invalid digit format",ex);
        }
    }

    @Override
    public String toString() {
        return "Digit{" +
                "value='" + value + '\'' +
                ", doubleValue=" + doubleValue +
                '}';
    }

    public double doubleValue(){
        return doubleValue;
    }

    public String stringValue() {
        return value;
    }
}
