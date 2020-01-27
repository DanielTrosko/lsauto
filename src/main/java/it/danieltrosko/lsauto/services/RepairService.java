package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.mapper.RepairMapper;
import it.danieltrosko.lsauto.model.repositories.RepairRepository;
import org.springframework.stereotype.Service;

@Service
public class RepairService {
    private RepairRepository repairRepository;

    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    public RepairDTO getRepairById(Long id) {
        return RepairMapper.toDTO(repairRepository.getOne(id));
    }

    public void createRepair(RepairDTO repairDTO){
        repairRepository.save(RepairMapper.toEntity(repairDTO));
    }

    public void updateRepair(RepairDTO repairDTO){
        repairRepository.save(RepairMapper.toEntity(repairDTO));
    }
}
