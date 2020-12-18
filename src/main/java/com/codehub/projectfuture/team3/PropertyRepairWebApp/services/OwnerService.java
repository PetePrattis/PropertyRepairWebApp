package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;

import java.util.List;

public interface OwnerService {

    OwnerModel findOwnerById(Long id) throws OwnerNotFoundException;

    List<OwnerModel> getAllOwners();

    OwnerModel findOwnerByAfm(Long afm) throws OwnerNotFoundException;

    OwnerModel findOwnerByEmail(String email) throws OwnerNotFoundException;

    void deleteOwnerById(Long id);

    OwnerModel updateOwner(OwnerModel ownerModel) throws OwnerNotFoundException;

    OwnerModel createOwner(OwnerForm ownerForm);

}
