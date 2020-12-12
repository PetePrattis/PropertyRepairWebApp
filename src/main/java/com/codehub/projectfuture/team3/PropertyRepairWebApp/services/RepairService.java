package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RepairService {

    Optional<Repair> findRepairById(Long id);

    List<Repair> getAllRepairs();

    List<Repair> findRepairByDateAndRepairStatus(Date date, RepairStatus status);

    Repair addRepair(Repair repair);

    List<Repair> getRepairsByAfm(Long afm);

    List<Repair> findRepairByDate(Date date);

    List<Repair> findRepairByDateBetween(Date startDate, Date endDate);
    //List<Repair> findRepairByStartDateGraterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);

    void deleteRepairById(Long id);

    Optional<RepairModel> findRepair(Long id);


    List<Repair> findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus status);

    //TODO updates
    //TODO show top 10 next repairs
}
