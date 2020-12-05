package com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findRepairByDate(Date date);

    //List<Repair> findRepairByAfm(Long afm);

    //TODO find by date
    //List<Repair> findRepairByStartDateGraterThanEqualAndEndDateLessThanEqual(Date endDate, Date startDate);

    //TODO updates

    //todo show top 10 next repairs
}
