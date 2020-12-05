package com.codehub.projectfuture.team3.PropertyRepairWebApp.domains;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.PropertyType;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OWNER", uniqueConstraints = {@UniqueConstraint(columnNames = {"owner_AFM", "owner_email"})})
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", nullable = false)
    private Long id;

    @Column(name = "owner_AFM")
    private Long afm;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "owner_address")
    private String address;

    @Column(name = "owner_telephone")
    private String telephoneNumber;

    @Column(name = "owner_email")
    private String email;

    @Column(name = "owner_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type")
    private PropertyType propertyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

    @OneToMany(mappedBy = "owner", targetEntity = Repair.class)
    private List<Repair> repairs;

}
