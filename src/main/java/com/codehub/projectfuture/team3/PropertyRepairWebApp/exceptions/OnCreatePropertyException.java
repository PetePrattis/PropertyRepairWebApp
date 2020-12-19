package com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions;

public class OnCreatePropertyException extends RuntimeException {
    private static final String MESSAGE = "Owner doesn't exist. Cannot create Property.";

    public OnCreatePropertyException(Throwable t) {
        super(MESSAGE, t);
    }

    public OnCreatePropertyException() {
        super(MESSAGE);
    }
}
