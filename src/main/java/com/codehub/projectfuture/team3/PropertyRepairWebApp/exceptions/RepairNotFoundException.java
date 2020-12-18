package com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions;

public class RepairNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Repair doesn't exist.";

    public RepairNotFoundException(Throwable t) {
        super(MESSAGE, t);
    }

    public RepairNotFoundException() {
        super(MESSAGE);
    }
}
