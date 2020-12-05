package com.codehub.projectfuture.team3.PropertyRepairWebApp.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Repair {

    @Id
    @Column(name = "repair_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "repair_date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "repair_status")
    private


}
