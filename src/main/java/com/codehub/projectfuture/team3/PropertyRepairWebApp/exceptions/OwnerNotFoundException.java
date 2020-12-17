package com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions;

public class OwnerNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Owner doesn't exist.";

    public OwnerNotFoundException(Throwable t) {
        super(MESSAGE, t);
    }

    public OwnerNotFoundException() {
        super(MESSAGE);
    }
}
