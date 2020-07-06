package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.mapper.CarMapper;
import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.repositories.AddressRepository;
import it.danieltrosko.lsauto.model.repositories.CarRepository;
import it.danieltrosko.lsauto.model.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarService {
    private CarRepository carRepository;
    private UserRepository userRepository;

    public CarService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }


    public void createCar(CarDTO carDTO) {
        Car car = CarMapper.toEntity(carDTO);
        userRepository.save(car.getOwner());
        carRepository.save(car);
    }

    public CarDTO getCarById(Long id) {
        return CarMapper
                .toDTO(carRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException(id, "car does not exist")));
    }

    public List<CarDTO> getCarsList() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CarDTO> getCarsList(Map<String, String> parameters) {
        Car car = Car
                .builder()
                .chassisNumber(parameters.getOrDefault("chassisNumber", null))
                .engineDesignation(parameters.getOrDefault("engineDesignation", null))
                .mark(parameters.getOrDefault("mark", null))
                .model(parameters.getOrDefault("model", null))
                .year(parameters.getOrDefault("year", null))
                .build();

        return carRepository.findAll(Example.of(car))
                .stream()
                .map(CarMapper::toDTO)
                .collect(Collectors.toList());
    }


}
