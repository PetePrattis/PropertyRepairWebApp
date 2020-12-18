package com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions;

public class OnCreateRepairException extends RuntimeException{
    private static final String MESSAGE = "Owner doesn't exist. Cannot create Repair.";

    public OnCreateRepairException(Throwable t) {
        super(MESSAGE, t);
    }

    public OnCreateRepairException() {
        super(MESSAGE);
    }
}
