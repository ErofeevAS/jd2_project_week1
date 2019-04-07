package com.gmail.erofeev.st.alexei.service.exception;

public class WrongNumberOfArgumentsException extends RuntimeException {
    public WrongNumberOfArgumentsException(String message) {
        super(message);
    }

    public WrongNumberOfArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongNumberOfArgumentsException(Throwable cause) {
        super(cause);
    }

    public WrongNumberOfArgumentsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WrongNumberOfArgumentsException() {
    }
}
