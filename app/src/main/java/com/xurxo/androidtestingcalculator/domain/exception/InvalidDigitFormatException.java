package com.xurxo.androidtestingcalculator.domain.exception;


public class InvalidDigitFormatException extends IllegalArgumentException{

    public InvalidDigitFormatException(String detailMessage) {super(detailMessage);}

    public InvalidDigitFormatException(String message, Throwable cause) {super(message,cause);}

    public InvalidDigitFormatException(Throwable cause) {super(cause);}
}

