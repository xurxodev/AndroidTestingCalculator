package com.xurxo.androidtestingcalculator.domain.model;

import com.xurxo.androidtestingcalculator.domain.exception.InvalidOperatorCharacterException;

public class Operator {
    private char value;

    public Operator(char value){
        this.value = parseOperator(value);
    }

    private char parseOperator(char operator){
        if (operator != '+' && operator != '-' && operator != 'x' &&
                operator != '/' && operator != '%')
            throw new InvalidOperatorCharacterException
                    ("Invalid operator character. Valid characters are + - x / %");
        else
            return  operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operator)) return false;

        Operator operator = (Operator) o;

        return value == operator.value;

    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    static Operator addOperator;

    public static Operator AddOperator(){
        if (addOperator == null )
            addOperator = new Operator('+');

        return addOperator;
    }

    public static Operator SubstractOperator(){
        return new Operator('-');
    }

    public static Operator DivideOperator(){
        return new Operator('/');
    }

    public static Operator MultiplyOperator(){
        return new Operator('*');
    }

    public char stringValue() {
        return value;
    }
}
