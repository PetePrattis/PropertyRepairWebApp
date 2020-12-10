package com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findRepairByDate(Date date);

    List<Repair> findByDateAndRepairStatus(Date date, RepairStatus status);

    List<Repair> findByDateBetween(Date startDate, Date endDate);

    List<Repair> findByOwner_Afm(Long OwnerAfm);

    List<Repair> findFirst10ByRepairStatusOrderByDateAsc(RepairStatus status);

    //List<Repair> findRepairByStartDateGraterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);
}
