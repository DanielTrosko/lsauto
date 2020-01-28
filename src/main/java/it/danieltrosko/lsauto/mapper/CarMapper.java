package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.model.entites.Car;

public class CarMapper {


    public static CarDTO toDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setMark(car.getMark());
        carDTO.setModel(car.getModel());
        carDTO.setYear(car.getYear());
        carDTO.setChassisNumber(car.getChassisNumber());
        carDTO.setMeterReading(car.getMeterReading());
        carDTO.setPlateNumber(car.getPlateNumber());
        carDTO.setOwner(car.getOwner());
        return carDTO;
    }

    public static Car toEntity(CarDTO carDTO){
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setMark(carDTO.getMark());
        car.setMark(carDTO.getMark());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setChassisNumber(carDTO.getChassisNumber());
        car.setMeterReading(carDTO.getMeterReading());
        car.setPlateNumber(carDTO.getPlateNumber());
        car.setOwner(carDTO.getOwner());
        return car;
    }

}
