package com.xurxo.androidtestingcalculator.domain.exception;


public class InvalidOperatorCharacterException extends IllegalArgumentException{

    public InvalidOperatorCharacterException(String detailMessage) {super(detailMessage);}

    public InvalidOperatorCharacterException(String message, Throwable cause) {super(message,cause);}

    public InvalidOperatorCharacterException(Throwable cause) {super(cause);}
}

