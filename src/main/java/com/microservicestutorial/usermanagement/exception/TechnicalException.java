package com.microservicestutorial.usermanagement.exception;

public class TechnicalException extends RuntimeException{
    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String msg, Throwable cause){
        super(msg, cause);
    }
}
