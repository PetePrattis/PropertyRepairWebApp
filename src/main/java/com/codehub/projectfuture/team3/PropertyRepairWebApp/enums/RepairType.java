package com.codehub.projectfuture.team3.PropertyRepairWebApp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RepairType {
    PAINTING("Painting"),
    INSULATION("Insulation"),
    FRAMES("Frames"),
    PLUMBING("Plumbing work"),
    ELECTRICAL("Electrical work");

    private String type;
}
