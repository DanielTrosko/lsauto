package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.model.entites.Address;
import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.User;

public class CarMapper {


    public static CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        Address address = car.getOwner().getAddress();
        User owner = car.getOwner();

        carDTO.setEmail(owner.getEmail());
        carDTO.setPassword(owner.getPassword());
        carDTO.setFirstName(owner.getFirstName());
        carDTO.setSurname(owner.getSurame());
        carDTO.setPhoneNumber(owner.getPhoneNumber());

        carDTO.setCity(address.getCity());
        carDTO.setHouseNumber(address.getHouseNumber());
        carDTO.setApartmentNumber(address.getApartmentNumber());
        carDTO.setPostCode(address.getPostCode());
        carDTO.setStreet(address.getStreet());
        carDTO.setAddressId(address.getId());

        carDTO.setId(car.getId());
        carDTO.setMark(car.getMark());
        carDTO.setModel(car.getModel());
        carDTO.setEngineCode(car.getEngineCode());
        carDTO.setEngineDesignation(car.getEngineDesignation());
        carDTO.setYear(car.getYear());
        carDTO.setChassisNumber(car.getChassisNumber());
        carDTO.setMeterReading(car.getMeterReading());
        carDTO.setPlateNumber(car.getPlateNumber());
        carDTO.setOwnerId(car.getOwner().getId());
        carDTO.setAddressId(car.getOwner().getAddress().getId());

        return carDTO;
    }

    public static Car toEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setMark(carDTO.getMark());
        car.setModel(carDTO.getModel());
        car.setEngineDesignation(carDTO.getEngineDesignation());
        car.setEngineCode(carDTO.getEngineCode());
        car.setYear(carDTO.getYear());
        car.setChassisNumber(carDTO.getChassisNumber());
        car.setMeterReading(carDTO.getMeterReading());
        car.setPlateNumber(carDTO.getPlateNumber());

        User user = new User();
        Address address = new Address();

        user.setEmail(carDTO.getEmail());
        user.setPassword(carDTO.getPassword());
        user.setFirstName(carDTO.getFirstName());
        user.setSurame(carDTO.getSurname());
        user.setPhoneNumber(carDTO.getPhoneNumber());

        address.setCity(carDTO.getCity());
        address.setHouseNumber(carDTO.getHouseNumber());
        address.setApartmentNumber(carDTO.getApartmentNumber());
        address.setPostCode(carDTO.getPostCode());
        address.setStreet(carDTO.getStreet());
        user.setAddress(address);
        car.setOwner(user);

        return car;
    }

}
