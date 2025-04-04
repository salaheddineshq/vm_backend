package com.smart.vm_avoca.exception;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
