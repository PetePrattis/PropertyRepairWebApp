package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RepairService {

    Optional<RepairModel> findRepairById(Long id);

    List<RepairModel> getAllRepairs();

    List<RepairModel> findRepairByDateAndRepairStatus(Date date, RepairStatus status);

    List<RepairModel> getRepairsByAfm(Long afm);

    List<RepairModel> findRepairByDate(Date date);

    List<RepairModel> findRepairByDateBetween(Date startDate, Date endDate);
    //List<Repair> findRepairByStartDateGraterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);

    void deleteRepairById(Long id);

    List<RepairModel> findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus status);

    RepairModel updateRepair(RepairModel repairModel);
    //TODO updates
    //TODO show top 10 next repairs
}
