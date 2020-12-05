package com.codehub.projectfuture.team3.PropertyRepairWebApp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RepairStatus {
    PENDING("Pending"),
    INPROGRESS("In Progress"),
    COMPLETED("Completed");

    private String status;
}
