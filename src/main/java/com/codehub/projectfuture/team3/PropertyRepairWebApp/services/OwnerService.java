package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    OwnerModel findOwnerById(Long id) throws OwnerNotFoundException;

    List<OwnerModel> getAllOwners();

    Optional<Owner> findOwnerByAfmOptional(Long afm);

    OwnerModel findOwnerByAfm(Long afm) throws OwnerNotFoundException;

    Optional<Owner> findOwnerByEmailOptional(String email);

    OwnerModel findOwnerByEmail(String email) throws OwnerNotFoundException;

    void deleteOwnerById(Long id);

    OwnerModel updateOwner(OwnerModel ownerModel) throws OwnerNotFoundException;

    OwnerModel createOwner(OwnerForm ownerForm);

}
