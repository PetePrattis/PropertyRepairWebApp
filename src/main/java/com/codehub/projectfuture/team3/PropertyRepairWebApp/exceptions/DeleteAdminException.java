package com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions;

public class DeleteAdminException extends RuntimeException {
    private static final String MESSAGE = "You can not delete the only admin!";

    public DeleteAdminException(Throwable t) {
        super(MESSAGE, t);
    }

    public DeleteAdminException() {
        super(MESSAGE);
    }
}
