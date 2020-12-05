package com.codehub.projectfuture.team3.PropertyRepairWebApp.domains;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="REPAIR")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_id", nullable = false)
    private Long id;

    @Column(name = "repair_date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "repair_status")
    private RepairStatus repairStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "repair_type")
    private RepairType repairType;

    @Column(name = "repair_cost")
    private float cost;

    @Column(name = "repair_address")
    private String address;

    @Column(name = "extra_info")
    private String extraInfo;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
