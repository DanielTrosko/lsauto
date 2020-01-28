package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarDTO;
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

    public CarDTO getCarById(Long id) {
        return CarMapper.toDTO(carRepository.getOne(id));
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();

    }
}
