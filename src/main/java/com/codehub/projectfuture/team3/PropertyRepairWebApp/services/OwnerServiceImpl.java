package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceprions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.OwnerForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.OwnerFormToOwnerMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.OwnerToOwnerModelMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.RepairToRepairModelMapper;
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

//        return ownerRepository
//                .findById(id)
//                .map(owner -> ownerToOwnerModel.map(owner));
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
    public Optional<OwnerModel> findOwnerByAfm(Long afm) {
        return ownerRepository
                .findOwnerByAfm(afm)
                .map(owner -> ownerToOwnerModel.map(owner));
    }

    @Override
    public Optional<OwnerModel> findOwnerByEmail(String email) {
        return ownerRepository
                .findOwnerByEmail(email)
                .map(owner -> ownerToOwnerModel.map(owner));
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }


    @Override
    public OwnerModel updateOwner(OwnerModel ownerModel) {
        Owner originalOwner = ownerRepository.findById(ownerModel.getId()).get();
        originalOwner.setFirstName(ownerModel.getFirstName());
        originalOwner.setAfm(ownerModel.getAfm());
        originalOwner.setLastName(ownerModel.getLastName());
        originalOwner.setAddress(ownerModel.getAddress());
        originalOwner.setEmail(ownerModel.getEmail());
        originalOwner.setTelephoneNumber(ownerModel.getTelephoneNumber());

        Owner newOwner = ownerRepository.save(originalOwner);
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
