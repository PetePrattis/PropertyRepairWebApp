package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    Optional<Owner> findOwnerById(Long id);

    List<Owner> getAllOwners();

    Optional<Owner> findOwnerByAfm(Long afm);

    Optional<Owner> findOwnerByEmail(String email);

    //Optional<Owner> findOwnerByAfmAndEmail(Long afm, String email);

    Owner addOwner(Owner owner);

    void deleteOwnerById(Long id);

    Optional<OwnerModel> findOwner(Long id);

    OwnerModel updateOwner(OwnerModel ownerModel);

    // Owner deleteOwnerByEmail(String email);
   // Owner deleteOwnerByAfm(Long afm);

    //TODO find by email or afm & updates
}
