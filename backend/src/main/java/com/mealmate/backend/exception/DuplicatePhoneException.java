package com.mealmate.backend.exception;

public class DuplicatePhoneException extends RuntimeException {
    public  DuplicatePhoneException(String message){
        super(message);
    }
}
