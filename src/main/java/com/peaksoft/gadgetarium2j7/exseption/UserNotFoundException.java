package com.peaksoft.gadgetarium2j7.exseption;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }

}
