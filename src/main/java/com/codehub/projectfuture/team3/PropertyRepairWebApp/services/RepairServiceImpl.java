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
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements RepairService{

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private RepairToRepairModelMapper repairModelMapper;

    @Override
    public Optional<RepairModel> findRepairById(Long id) {
        return repairRepository
                .findById(id)
                .map(repair -> repairModelMapper.map(repair));
    }

    @Override
    public List<RepairModel> getAllRepairs() {
        return repairRepository
                .findAll()
                .stream()
                .map(repair -> repairModelMapper.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findRepairByDateAndRepairStatus(Date date, RepairStatus status) {
        return repairRepository
                .findByDateAndRepairStatus(date, status)
                .stream()
                .map(repair -> repairModelMapper.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findRepairByDate(Date date) {
        return repairRepository
                .findRepairByDate(date)
                .stream()
                .map(repair -> repairModelMapper.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findRepairByDateBetween(Date startDate, Date endDate) {
        return repairRepository
                .findByDateBetween(startDate, endDate)
                .stream()
                .map(repair -> repairModelMapper.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRepairById(Long id) {
        repairRepository.deleteById(id);
    }

    @Override
    public List<RepairModel> getRepairsByAfm(Long afm) {
        return repairRepository
                .findByOwner_Afm(afm)
                .stream()
                .map(repair -> repairModelMapper.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus status)
    {
        return repairRepository
                .findFirst10ByRepairStatusOrderByDateAsc(status)
                .stream()
                .map(repair -> repairModelMapper.map(repair))
                .collect(Collectors.toList());
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

}
