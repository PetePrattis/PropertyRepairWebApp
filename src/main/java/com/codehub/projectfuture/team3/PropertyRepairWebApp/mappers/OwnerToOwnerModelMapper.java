package com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.OwnerModel;
import org.springframework.stereotype.Component;

@Component
public class OwnerToOwnerModelMapper {

    public OwnerModel map(Owner owner) {
        OwnerModel ownerModel = new OwnerModel();
        ownerModel.setId(owner.getId());
        ownerModel.setAfm(owner.getAfm());
        ownerModel.setEmail(owner.getEmail());
        ownerModel.setFirstName(owner.getFirstName());
        ownerModel.setLastName(owner.getLastName());
        ownerModel.setAddress(owner.getAddress());
        ownerModel.setTelephoneNumber(owner.getTelephoneNumber());

        return ownerModel;
    }


}


