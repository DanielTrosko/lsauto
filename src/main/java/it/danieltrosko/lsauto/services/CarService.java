package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.mapper.CarMapper;
import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.repositories.AddressRepository;
import it.danieltrosko.lsauto.model.repositories.CarRepository;
import it.danieltrosko.lsauto.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class CarService {
    private CarRepository carRepository;
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public CarService(CarRepository carRepository, UserRepository userRepository, AddressRepository addressRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public void createCar(CarDTO carDTO) {
        Car car = CarMapper.toEntity(carDTO);
        userRepository.save(car.getOwner());
        carRepository.save(car);
    }
    public void updateCar(CarDTO carDTO) {
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
