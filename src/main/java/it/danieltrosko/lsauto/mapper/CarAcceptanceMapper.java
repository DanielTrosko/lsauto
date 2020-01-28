package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.model.entites.Car;

public class CarAcceptanceMapper {

    public static CarAcceptanceDTO toDTO(Car car){
        CarAcceptanceDTO acceptanceDTO = new CarAcceptanceDTO();
        acceptanceDTO.setMark(car.getMark());
        acceptanceDTO.setModel(car.getModel());
        acceptanceDTO.setYear(car.getYear());
        acceptanceDTO.setPlateNumber(car.getPlateNumber());
        acceptanceDTO.setChassisNumber(car.getChassisNumber());
        acceptanceDTO.setMeterReading(car.getMeterReading());
        acceptanceDTO.setEmail(car.getOwner().getEmail());
        acceptanceDTO.setUsername(car.getOwner().getUsername());
        acceptanceDTO.setPassword(car.getOwner().getPassword());
        acceptanceDTO.setFirstName(car.getOwner().getFirstName());
        acceptanceDTO.setSurname(car.getOwner().getSurname());
        acceptanceDTO.setPhoneNumber(car.getOwner().getPhoneNumber());
        acceptanceDTO.setStreet(car.getOwner().getAddress().getStreet());
        acceptanceDTO.setHouseNumber(car.getOwner().getAddress().getHouseNumber());
        acceptanceDTO.setApartmentNumber(car.getOwner().getAddress().getApartmentNumber());
        acceptanceDTO.setPostCode(car.getOwner().getAddress().getPostCode());
        acceptanceDTO.setCity(car.getOwner().getAddress().getCity());
        return acceptanceDTO;
    }
}
