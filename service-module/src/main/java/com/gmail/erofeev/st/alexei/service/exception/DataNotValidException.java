package com.gmail.erofeev.st.alexei.service.exception;

public class DataNotValidException extends RuntimeException{
    public DataNotValidException(Throwable cause) {
        super(cause);
    }

    public DataNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataNotValidException() {
    }

    public DataNotValidException(String message) {
        super(message);
    }

    public DataNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
