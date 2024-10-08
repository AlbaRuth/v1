package com.lw1.exceptions;

public class FileNotReadyException extends Exception {

    public FileNotReadyException(String message) {
        super(message);
    }

    public FileNotReadyException(String message, Throwable cause) {
        super(message, cause);
    }
}