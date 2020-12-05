package com.codehub.projectfuture.team3.PropertyRepairWebApp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    OWNER("Owner"),
    ADMIN("Admin");

    private String role;
}
