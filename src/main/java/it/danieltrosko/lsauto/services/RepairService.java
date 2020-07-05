package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.mapper.CarAcceptanceMapper;
import it.danieltrosko.lsauto.mapper.RepairMapper;
import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import it.danieltrosko.lsauto.model.repositories.CarRepository;
import it.danieltrosko.lsauto.model.repositories.RepairRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    @CacheEvict(value = {"currentRepair", "repairHistory"}, allEntries = true)
    public void updateRepair(RepairDTO repairDTO) {
        repairRepository.save(RepairMapper.toEntity(repairDTO));
    }

    @Cacheable("currentRepair")
    public List<RepairDTO> getCurrentRepair() {
        return repairRepository.getAllByStatusIsNot(RepairStatus.TO_RECEIVE)
                .stream()
                .map(RepairMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Cacheable("repairHistory")
    public List<RepairDTO> getRepairHistory() {
        return repairRepository.getAllByStatusIs(RepairStatus.TO_RECEIVE).stream().map(RepairMapper::toDTO).collect(Collectors.toList());
    }

    public CarAcceptanceDTO getExistCarAcceptance(Long id) {
        return CarAcceptanceMapper.toDTO(carRepository.getOne(id));
    }

    public CarAcceptanceDTO getAcceptanceCarWithExistCar(Long carId) {
        CarAcceptanceDTO carAcceptanceDTO = CarAcceptanceMapper.toDTO(carRepository.findById(carId).orElseThrow(() -> new ObjectNotFoundException(carId, "car acceptance does not exist")));
        return carAcceptanceDTO;
    }


    public List<RepairDTO> getRepairListByParameters(Map<String, String> parameters) {

        Repair repair = Repair
                .builder()
                .repairNumber(parameters.get("repairNumber"))
                .dataOfPickup(parameters.get("dataOfPickup") == null ? null : LocalDate.parse(parameters.get("dataOfPickup")))
                .dateOfAdmission(parameters.get("dataOfPickup") == null ? null : LocalDate.parse(parameters.get("dateOfAdmission")))
                .status(parameters.get("status") == null ? null : RepairStatus.valueOf(parameters.get("status")))
                .build();

        return repairRepository.findAll(Example.of(repair))
                .stream()
                .map(RepairMapper::toDTO)
                .collect(Collectors.toList());

    }


}
