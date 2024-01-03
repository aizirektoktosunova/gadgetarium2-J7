package com.peaksoft.gadgetarium2j7.exseption;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(String message) {
        super(message);
    }

}
