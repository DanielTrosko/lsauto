package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.model.entites.Repair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepairMapper {

    public static RepairDTO toDTO(Repair repair) {
        RepairDTO repairDTO = new RepairDTO();
        repairDTO.setId(repair.getId());
        repairDTO.setRepairNumber(repair.getRepairNumber());
        repairDTO.setDateOfAdmission(repair.getDateOfAdmission());
        repairDTO.setDataOfPickup(repair.getDataOfPickup());
        repairDTO.setScopeOfWork(repair.getScopeOfWork());
        repairDTO.setStatus(repair.getStatus());
        repairDTO.setCar(repair.getCar());
        return repairDTO;
    }

    public static Repair toEntity(RepairDTO repairDTO) {
        Repair repair = new Repair();
        repair.setId(repairDTO.getId());
        repair.setRepairNumber(repairDTO.getRepairNumber());
        repair.setDateOfAdmission(repairDTO.getDateOfAdmission());
        repair.setDataOfPickup(repairDTO.getDataOfPickup());
        repair.setScopeOfWork(repairDTO.getScopeOfWork());
        repair.setCar(repairDTO.getCar());
        repair.setStatus(repairDTO.getStatus());
        return repair;
    }
}
