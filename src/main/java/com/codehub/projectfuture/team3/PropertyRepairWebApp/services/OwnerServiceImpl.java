package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.OwnerFormToOwnerMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.OwnerToOwnerModelMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.RepairToRepairModelMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl  implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerToOwnerModelMapper ownerModelMapper;

    @Autowired
    private OwnerFormToOwnerMapper ownerMapper;

    @Override
    public Optional<Owner> findOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> findOwnerByAfm(Long afm) {
        return ownerRepository.findOwnerByAfm(afm);
    }

    @Override
    public Optional<Owner> findOwnerByEmail(String email) {
        return ownerRepository.findOwnerByEmail(email);
    }

    @Override
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Optional<OwnerModel> findOwner(Long id) {
        return ownerRepository
                .findById(id)
                .map(owner -> ownerModelMapper.map(owner));
    }

    @Override
    public OwnerModel updateOwner(OwnerModel ownerModel) {
        Owner originalOwner = ownerRepository.findById(ownerModel.getId()).get();
        originalOwner.setFirstName(ownerModel.getFirstName());
        originalOwner.setAfm(ownerModel.getAfm());
        originalOwner.setLastName(ownerModel.getLastName());
        Owner newBook = ownerRepository.save(originalOwner);
        return ownerModelMapper.map(newBook);
    }
}
