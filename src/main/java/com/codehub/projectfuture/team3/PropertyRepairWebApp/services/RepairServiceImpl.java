package com.codehub.projectfuture.team3.PropertyRepairWebApp.services;


import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Owner;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.domains.Repair;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.enums.RepairStatus;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OnCreateRepairException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.OwnerNotFoundException;
import com.codehub.projectfuture.team3.PropertyRepairWebApp.exceptions.RepairNotFoundException;
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
    private RepairToRepairModelMapper repairToRepairModel;

    @Autowired
    private RepairFormToRepairMapper repairFormToRepair;

    @Override
    public RepairModel findRepairById(Long id) {
        Optional<Repair> repair = repairRepository.findById(id);
        if (repair.isEmpty()) throw new RepairNotFoundException();
        return repairToRepairModel.map(repair.get());
    }

    @Override
    public List<RepairModel> getAllRepairs() {
        return repairRepository
                .findAll()
                .stream()
                .map(repair -> repairToRepairModel.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findRepairByDateAndRepairStatus(LocalDate date, RepairStatus status) {
        return repairRepository
                .findByDateAndRepairStatus(date, status)
                .stream()
                .map(repair -> repairToRepairModel.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findRepairByDate(LocalDate date) {
        return repairRepository
                .findRepairByDate(date)
                .stream()
                .map(repair -> repairToRepairModel.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepairModel> findRepairByDateBetween(LocalDate startDate, LocalDate endDate) {
        return repairRepository
                .findByDateBetween(startDate, endDate)
                .stream()
                .map(repair -> repairToRepairModel.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRepairById(Long id) {
        repairRepository.deleteById(id);
    }

//    @Override
//    public List<RepairModel> getRepairsByAfm(Long afm) {
//        return repairRepository
//                .findByOwner_Afm(afm)
//                .stream()
//                .map(repair -> repairToRepairModel.map(repair))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<RepairModel> findFirst10ByOrderByDateAscAndRepairStatus(RepairStatus status)
    {
        return repairRepository
                .findFirst10ByRepairStatusOrderByDateAsc(status)
                .stream()
                .map(repair -> repairToRepairModel.map(repair))
                .collect(Collectors.toList());
    }

    @Override
    public RepairModel updateRepair(RepairModel repairModel) {
        Optional<Repair> originalRepair = repairRepository.findById(repairModel.getId());
        if (originalRepair.isEmpty()) throw new RepairNotFoundException();
        originalRepair.get().setAddress(repairModel.getAddress());
        originalRepair.get().setCost(Float.parseFloat(repairModel.getCost().replace(".","").replace(",",".")));
        LocalDate date = LocalDate.parse(repairModel.getDate());
        originalRepair.get().setDate(date);
        originalRepair.get().setExtraInfo(repairModel.getExtraInfo());

        //Optional<Owner> owner = ownerRepository.findOwnerByAfm(repairModel.getOwnerAfm());
        //if (owner.isEmpty()) throw new OwnerNotFoundException();

        //originalRepair.get().setOwner(owner.get());
        originalRepair.get().setRepairStatus(repairModel.getRepairStatus());
        originalRepair.get().setRepairType(repairModel.getRepairType());
        Repair newRepair = repairRepository.save(originalRepair.get());
        return repairToRepairModel.map(newRepair);
    }

    @Override
    public RepairModel createRepair(RepairForm repairForm) {
        try {
            Repair repair = repairFormToRepair.map(repairForm);
            Repair newRepair = repairRepository.save(repair);
            return repairToRepairModel.map(newRepair);
        }
        catch (OwnerNotFoundException e) {
            throw new OnCreateRepairException();
        }
    }

}
