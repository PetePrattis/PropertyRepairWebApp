package com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Repair, Long> {

    List<Repair> findRepairByDate(Date date);

    //TODO find by date
    //List<Repair> findRepairByStartDateGraterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);

    //TODO updates
}
