package com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    //TODO search by email or afm
    Optional<Owner> findOwnerByEmail(String email);
    Optional<Owner> findOwnerByAfm(Long afm);

    //TODO updates and deletes
}
