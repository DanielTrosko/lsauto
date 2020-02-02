package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.mapper.CarAcceptanceMapper;
import it.danieltrosko.lsauto.mapper.CarMapper;
import it.danieltrosko.lsauto.mapper.RepairMapper;
import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import it.danieltrosko.lsauto.model.repositories.CarRepository;
import it.danieltrosko.lsauto.model.repositories.RepairRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RepairService {
    private RepairRepository repairRepository;
    private CarRepository carRepository;

    public RepairService(RepairRepository repairRepository, CarRepository carRepository) {
        this.repairRepository = repairRepository;
        this.carRepository = carRepository;
    }

    public RepairDTO getRepairById(Long id) {
        return RepairMapper.toDTO(repairRepository.getOne(id));
    }

    public void createRepair(RepairDTO repairDTO) {
        repairRepository.save(RepairMapper.toEntity(repairDTO));
    }

    public void updateRepair(RepairDTO repairDTO) {
        repairRepository.save(RepairMapper.toEntity(repairDTO));
    }

    public List<RepairDTO> getCurrentRepair() {
        return repairRepository.getAllByStatusIsNot(RepairStatus.DO_ODBIORU).stream().map(RepairMapper::toDTO).collect(Collectors.toList());
    }

    public CarAcceptanceDTO getExistCarAcceptance(Long id) {
        return CarAcceptanceMapper.toDTO(carRepository.getOne(id));
    }

    public CarAcceptanceDTO getAcceptanceCarWithExistCar(Long carId) {
        CarAcceptanceDTO carAcceptanceDTO = CarAcceptanceMapper.toDTO(carRepository.findById(carId).orElse(new Car()));
        return carAcceptanceDTO;
    }

}
