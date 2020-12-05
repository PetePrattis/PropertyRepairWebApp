package com.codehub.projectfuture.team3.PropertyRepairWebApp.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PropertyType {
    HOUSE("Detached house"),
    MAISONETTE("Maisonette"),
    APARTMENT("Apartment Building");

    private String type;
}
