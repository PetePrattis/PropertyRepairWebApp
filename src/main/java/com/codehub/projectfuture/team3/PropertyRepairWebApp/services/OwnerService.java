package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    Optional<OwnerModel> findOwnerById(Long id);

    List<OwnerModel> getAllOwners();

    Optional<OwnerModel> findOwnerByAfm(Long afm);

    Optional<OwnerModel> findOwnerByEmail(String email);

    void deleteOwnerById(Long id);

    OwnerModel updateOwner(OwnerModel ownerModel);

    OwnerModel createOwner(OwnerForm ownerForm);

}
