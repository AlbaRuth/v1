package com.lw1.exceptions;

public class FileCloseException extends Exception {

    public FileCloseException(String message) {
        super(message);
    }

    public FileCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
