package com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    //TODO search by email or afm
    Optional<Owner> findOwnerByEmail(String email);
    Optional<Owner> findOwnerByAfm(Long afm);

    //TODO updates

    //todo delete query
}
