package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.RepairToRepairModelMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class RepairServiceImpl implements RepairService{

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private RepairToRepairModelMapper repairModelMapper;

    @Override
    public Optional<Repair> findRepairById(Long id) {
        return repairRepository.findById(id);
    }

    @Override
    public List<Repair> getAllRepairs() {
        return repairRepository.findAll();
    }

    @Override
    public List<Repair> findRepairByDateAndRepairStatus(Date date, RepairStatus status) {
        return repairRepository.findByDateAndRepairStatus(date, status);
    }

    @Override
    public List<Repair> findRepairByDate(Date date) {
        return repairRepository.findRepairByDate(date);
    }

    @Override
    public List<Repair> findRepairByDateBetween(Date startDate, Date endDate) {
        return repairRepository.findByDateBetween(startDate, endDate);
    }

    @Override
    public void deleteRepairById(Long id) {
        repairRepository.deleteById(id);
    }

    @Override
    public Repair addRepair(Repair repair) {
        return repairRepository.save(repair);
    }

    @Override
    public List<Repair> getRepairsByAfm(Long afm) {
        return repairRepository.findByOwner_Afm(afm);
    }

    @Override
    public List<Repair> findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus status)
    {
        return repairRepository.findFirst10ByRepairStatusOrderByDateAsc(status);
    }

    @Override
    public RepairModel updateRepair(RepairModel repairModel) {
        Repair originalRepair = repairRepository.findById(repairModel.getId()).get();
        originalRepair.setAddress(repairModel.getAddress());
        originalRepair.setCost(repairModel.getCost());
        originalRepair.setDate(repairModel.getDate());
        originalRepair.setExtraInfo(repairModel.getExtraInfo());
        originalRepair.setOwner(repairModel.getOwner());
        originalRepair.setRepairStatus(repairModel.getRepairStatus());
        originalRepair.setRepairType(repairModel.getRepairType());
        Repair newRepair = repairRepository.save(originalRepair);
        return repairModelMapper.map(newRepair);

    }

    @Override
    public Optional<RepairModel> findRepair(Long id) {
        return repairRepository
                .findById(id)
                .map(repair -> repairModelMapper.map(repair));
    }
}
