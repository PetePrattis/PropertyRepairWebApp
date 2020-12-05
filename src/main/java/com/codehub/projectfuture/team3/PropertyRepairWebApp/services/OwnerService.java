package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    Optional<Owner> findOwner(Long id);

    List<Owner> getAllOwners();

    Optional<Owner> findOwnerByAfm(Long afm);

    Optional<Owner> findOwnerByEmail(String email);

    Owner addOwner(Owner owner);

    Owner deleteOwnerByEmail(String email);

    Owner deleteOwnerByAfm(Long afm);

    //TODO find by email or afm & updates
}
