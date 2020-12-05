package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RepairService {

    Optional<Repair> findRepair(Long id);

    List<Repair> getAllRepairs();

    List<Repair> findRepairByDate(Date date);

    List<Repair> findRepairByAfm(Long afm);

    Repair addRepair(Repair repair);

    //List<Repair> findRepairByStartDateGraterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);

}
