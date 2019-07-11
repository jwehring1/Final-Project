package com.cts.ac.web_sandbox.service;

public class InvalidAddressStreetException extends RuntimeException {
    public InvalidAddressStreetException(String message)
    {
        super(message);
    }
    public InvalidAddressStreetException(String message, Throwable cause)
    {
        super(message,cause);
    }
}
