package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OnCreateRepairException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.RepairNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;

import java.time.LocalDate;
import java.util.List;

public interface RepairService {

    RepairModel findRepairById(Long id) throws RepairNotFoundException;

    List<RepairModel> getAllRepairs();

    List<RepairModel> findRepairByDateAndRepairStatus(LocalDate date, RepairStatus status);

    List<RepairModel> getRepairsByAfm(Long afm);

    List<RepairModel> findRepairByDate(LocalDate date);

    List<RepairModel> findRepairByDateBetween(LocalDate startDate, LocalDate endDate);

    void deleteRepairById(Long id);

    List<RepairModel> findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus status);

    RepairModel updateRepair(RepairModel repairModel)throws RepairNotFoundException, OwnerNotFoundException;

    RepairModel createRepair(RepairForm repairForm) throws OnCreateRepairException;
}
