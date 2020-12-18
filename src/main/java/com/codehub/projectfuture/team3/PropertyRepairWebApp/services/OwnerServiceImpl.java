package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.OwnerFormToOwnerMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.OwnerToOwnerModelMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl  implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerToOwnerModelMapper ownerToOwnerModel;

    @Autowired
    private OwnerFormToOwnerMapper ownerFormToOwner;

    @Override
    public OwnerModel findOwnerById(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isEmpty()) throw new OwnerNotFoundException();
        return ownerToOwnerModel.map(owner.get());
    }

    @Override
    public List<OwnerModel> getAllOwners() {
        return ownerRepository
                .findAll()
                .stream()
                .map(owner -> ownerToOwnerModel.map(owner))
                .collect(Collectors.toList());
    }

    @Override
    public OwnerModel findOwnerByAfm(Long afm) {
        Optional<Owner> owner = ownerRepository.findOwnerByAfm(afm);
        if (owner.isEmpty()) throw new OwnerNotFoundException();
        return ownerToOwnerModel.map(owner.get());
    }

    @Override
    public OwnerModel findOwnerByEmail(String email) {
        Optional<Owner> owner = ownerRepository.findOwnerByEmail(email);
        if (owner.isEmpty()) throw new OwnerNotFoundException();
        return ownerToOwnerModel.map(owner.get());
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }


    @Override
    public OwnerModel updateOwner(OwnerModel ownerModel) {
        Optional<Owner> originalOwner = ownerRepository.findById(ownerModel.getId());
        if (originalOwner.isEmpty()) throw new OwnerNotFoundException();
        originalOwner.get().setFirstName(ownerModel.getFirstName());
        originalOwner.get().setAfm(ownerModel.getAfm());
        originalOwner.get().setLastName(ownerModel.getLastName());
        originalOwner.get().setAddress(ownerModel.getAddress());
        originalOwner.get().setEmail(ownerModel.getEmail());
        originalOwner.get().setTelephoneNumber(ownerModel.getTelephoneNumber());

        Owner newOwner = ownerRepository.save(originalOwner.get());
        return ownerToOwnerModel.map(newOwner);
    }

    @Override
    public OwnerModel createOwner(OwnerForm ownerForm) {
        Owner owner = ownerFormToOwner.map(ownerForm);
        owner.setPassword("password");
        Owner newOwner = ownerRepository.save(owner);
        return ownerToOwnerModel.map(newOwner);
    }
}
