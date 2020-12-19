package com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    Optional<Property> findPropertyByPropertyCode(String propertyCode);
    Optional<Property> findPropertyByOwnerId(Long id);
    Optional<Property> findPropertyByOwnerAfm(Long id);
    //TODO add findRepairsByPropertyId in repair repository

}
