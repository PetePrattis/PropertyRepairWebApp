package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RepairServiceImpl implements RepairService{

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public Optional<Repair> findRepair(Long id) {
        return repairRepository.findById(id);
    }

    @Override
    public List<Repair> getAllRepairs() {
        return repairRepository.findAll();
    }

    @Override
    public List<Repair> findRepairByDate(Date date) {
        return repairRepository.findRepairByDate(date);
    }


    @Override
    public Repair addRepair(Repair repair) {
        return repairRepository.save(repair);
    }

    @Override
    public List<Repair> getRepairsByAfm(Long afm) {
        return repairRepository.findByOwner_Afm(afm);
    }

//    @Override
//    public Repair deleteRepair(){}

}
