package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.mapper.CarMapper;
import it.danieltrosko.lsauto.mapper.UserMapper;
import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.repositories.CarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCar(CarDTO carDTO) {
        carRepository.save(CarMapper.toEntity(carDTO));
    }

    public void createCrFromAcceptance(CarDTO carDTO, UserDTO userDTO) {
//        CarDTO dto = carDTO;
//        dto.setOwner(UserMapper.userToEntity(userDTO));
//        carRepository.save(CarMapper.toEntity(dto));
        carRepository.save(CarMapper.toEntity(carDTO));
    }

    public CarDTO getCarById(Long id) {
        return CarMapper.toDTO(carRepository.findById(id).orElse(new Car()));
    }

    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream().map(CarMapper::toDTO).collect(Collectors.toList());
    }

    public CarDTO getCarByPlateNumber(String plateNr) {
        return CarMapper.toDTO(carRepository.getByPlateNumberEquals(plateNr).orElse(new Car()));
    }
}
