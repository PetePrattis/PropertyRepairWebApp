package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;

import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.forms.RepairForm;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.RepairFormToRepairMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.mappers.RepairToRepairModelMapper;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.model.RepairModel;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.OwnerRepository;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements RepairService{

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private RepairToRepairModelMapper repairModelMapper;

    @Autowired
    private RepairFormToRepairMapper repairFormToRepair;

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
    public List<RepairModel> findRepairByDateAndRepairStatus(LocalDate date, RepairStatus status) {
        return repairRepository
                .findByDateAndRepairStatus(date, status)
                .stream()
                .map(repair -> repairModelMapper.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findRepairByDate(LocalDate date) {
        return repairRepository
                .findRepairByDate(date)
                .stream()
                .map(repair -> repairModelMapper.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findRepairByDateBetween(LocalDate startDate, LocalDate endDate) {
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
        originalRepair.setCost(Float.valueOf(repairModel.getCost().replace(".","").replace(",",".")));
        LocalDate date = LocalDate.parse(repairModel.getDate());
        originalRepair.setDate(date);
        originalRepair.setExtraInfo(repairModel.getExtraInfo());
        originalRepair.setOwner(ownerRepository.findOwnerByAfm(repairModel.getOwnerAfm()).get());
        originalRepair.setRepairStatus(repairModel.getRepairStatus());
        originalRepair.setRepairType(repairModel.getRepairType());
        Repair newRepair = repairRepository.save(originalRepair);
        return repairModelMapper.map(newRepair);

    }

    @Override
    public RepairModel createRepair(RepairForm repairForm) {
        Repair repair = repairFormToRepair.map(repairForm);
        Repair newRepair = repairRepository.save(repair);
        return repairModelMapper.map(newRepair);

    }

}
