package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.mapper.CarAcceptanceMapper;
import it.danieltrosko.lsauto.mapper.CarMapper;
import it.danieltrosko.lsauto.mapper.RepairMapper;
import it.danieltrosko.lsauto.mapper.UserMapper;
import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.repositories.AddressRepository;
import it.danieltrosko.lsauto.model.repositories.CarRepository;
import it.danieltrosko.lsauto.model.repositories.RepairRepository;
import it.danieltrosko.lsauto.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarAcceptanceService {
    private AddressRepository addressRepository;
    private CarRepository carRepository;
    private UserRepository userRepository;
    private RepairRepository repairRepository;


    public CarAcceptanceService(AddressRepository addressRepository, CarRepository carRepository, UserRepository userRepository, RepairRepository repairRepository) {
        this.addressRepository = addressRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.repairRepository = repairRepository;
    }

    public void createAcceptance(CarAcceptanceDTO carAcceptanceDTO) {
        Repair repair = CarAcceptanceMapper.toRepairEntity(carAcceptanceDTO);

        addressRepository.save(repair.getCar().getOwner().getAddress());
        userRepository.save(repair.getCar().getOwner());
        carRepository.save(repair.getCar());
        repairRepository.save(repair);

    }
}
