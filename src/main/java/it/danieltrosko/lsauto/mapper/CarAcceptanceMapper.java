package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.model.entites.Address;
import it.danieltrosko.lsauto.model.entites.Car;
import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.User;

public class CarAcceptanceMapper {

    public static CarAcceptanceDTO toDTO(Car car) {
        CarAcceptanceDTO acceptanceDTO = new CarAcceptanceDTO();
        acceptanceDTO.setUserId(car.getOwner().getId());
        acceptanceDTO.setAddressId(car.getOwner().getAddress().getId());
        acceptanceDTO.setCarId(car.getId());
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
        acceptanceDTO.setSurname(car.getOwner().getSurame());
        acceptanceDTO.setPhoneNumber(car.getOwner().getPhoneNumber());
        acceptanceDTO.setStreet(car.getOwner().getAddress().getStreet());
        acceptanceDTO.setHouseNumber(car.getOwner().getAddress().getHouseNumber());
        acceptanceDTO.setApartmentNumber(car.getOwner().getAddress().getApartmentNumber());
        acceptanceDTO.setPostCode(car.getOwner().getAddress().getPostCode());
        acceptanceDTO.setCity(car.getOwner().getAddress().getCity());
        return acceptanceDTO;
    }

    public static CarDTO toCarDTO(CarAcceptanceDTO carAcceptanceDTO) {
        CarDTO car = new CarDTO();
        car.setId(carAcceptanceDTO.getCarId());
        car.setMark(carAcceptanceDTO.getMark());
        car.setModel(carAcceptanceDTO.getModel());
        car.setYear(carAcceptanceDTO.getYear());
        car.setPlateNumber(carAcceptanceDTO.getPlateNumber());
        car.setChassisNumber(carAcceptanceDTO.getChassisNumber());
        car.setMeterReading(carAcceptanceDTO.getMeterReading());
        return car;
    }

    public static UserDTO toUserDTO(CarAcceptanceDTO carAcceptanceDTO) {
        Address address = new Address();
        address.setId(carAcceptanceDTO.getAddressId());
        address.setCity(carAcceptanceDTO.getCity());
        address.setHouseNumber(carAcceptanceDTO.getHouseNumber());
        address.setPostCode(carAcceptanceDTO.getPostCode());
        address.setStreet(carAcceptanceDTO.getStreet());

        UserDTO user = new UserDTO();
        user.setId(carAcceptanceDTO.getUserId());
        user.setEmail(carAcceptanceDTO.getEmail());
        user.setUsername(carAcceptanceDTO.getUsername());
        user.setPassword(carAcceptanceDTO.getPassword());
        user.setFirstName(carAcceptanceDTO.getFirstName());
        user.setSurname(carAcceptanceDTO.getSurname());
        user.setPhoneNumber(carAcceptanceDTO.getPhoneNumber());

        return user;
    }
    public static Repair toRepairEntity(CarAcceptanceDTO carAcceptanceDTO){
        Repair repair = new Repair();
        repair.setId(carAcceptanceDTO.getRepairId());
        repair.setRepairNumber(carAcceptanceDTO.getRepairNumber());
        repair.setDateOfAdmission(carAcceptanceDTO.getDateOfAdmission());
        repair.setDataOfPickup(carAcceptanceDTO.getDataOfPickup());
        repair.setScopeOfWork(carAcceptanceDTO.getScopeOfWork());
        repair.setStatus(carAcceptanceDTO.getStatus());

        Car car = new Car();
        car.setId(carAcceptanceDTO.getCarId());
        car.setMark(carAcceptanceDTO.getMark());
        car.setModel(carAcceptanceDTO.getModel());
        car.setYear(carAcceptanceDTO.getYear());
        car.setPlateNumber(carAcceptanceDTO.getPlateNumber());
        car.setChassisNumber(carAcceptanceDTO.getChassisNumber());
        car.setMeterReading(carAcceptanceDTO.getMeterReading());

        User user = new User();
        user.setId(carAcceptanceDTO.getUserId());
        user.setEmail(carAcceptanceDTO.getEmail());
        user.setUsername(carAcceptanceDTO.getUsername());
        user.setPassword(carAcceptanceDTO.getPassword());
        user.setFirstName(carAcceptanceDTO.getFirstName());
        user.setSurame(carAcceptanceDTO.getSurname());
        user.setPhoneNumber(carAcceptanceDTO.getPhoneNumber());

        Address address = new Address();
        address.setId(carAcceptanceDTO.getAddressId());
        address.setStreet(carAcceptanceDTO.getStreet());
        address.setHouseNumber(carAcceptanceDTO.getHouseNumber());
        address.setApartmentNumber(carAcceptanceDTO.getApartmentNumber());
        address.setPostCode(carAcceptanceDTO.getPostCode());
        address.setCity(carAcceptanceDTO.getCity());
        user.setAddress(address);
        car.setOwner(user);
        repair.setCar(car);

        return repair;

    }
}
