package com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions;

public class PropertyNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Property doesn't exist.";

    public PropertyNotFoundException(Throwable t) {
        super(MESSAGE, t);
    }

    public PropertyNotFoundException() {
        super(MESSAGE);
    }
}
