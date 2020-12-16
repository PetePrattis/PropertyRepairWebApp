package com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findRepairByDate(LocalDate date);

    List<Repair> findByDateAndRepairStatus(LocalDate date, RepairStatus status);

    List<Repair> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Repair> findByOwner_Afm(Long OwnerAfm);

    List<Repair> findFirst10ByRepairStatusOrderByDateAsc(RepairStatus status);

    //List<Repair> findRepairByStartDateGraterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);
}
