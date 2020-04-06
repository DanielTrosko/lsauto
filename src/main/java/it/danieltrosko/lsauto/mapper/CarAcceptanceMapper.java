package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.model.entites.*;

public class CarAcceptanceMapper {

    public static CarAcceptanceDTO toDTO(Car car) {
        CarAcceptanceDTO acceptanceDTO = new CarAcceptanceDTO();
        acceptanceDTO.setUserId(car.getOwner().getId());
        acceptanceDTO.setAddressId(car.getOwner().getAddress().getId());
        acceptanceDTO.setCarId(car.getId());
        acceptanceDTO.setMark(car.getMark());
        acceptanceDTO.setModel(car.getModel());
        acceptanceDTO.setEngineDesignation(car.getEngineDesignation());
        acceptanceDTO.setEngineCode(car.getEngineCode());
        acceptanceDTO.setYear(car.getYear());
        acceptanceDTO.setPlateNumber(car.getPlateNumber());
        acceptanceDTO.setChassisNumber(car.getChassisNumber());
        acceptanceDTO.setMeterReading(car.getMeterReading());
        acceptanceDTO.setEmail(car.getOwner().getEmail());
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

    public static CarAcceptanceDTO toDTOWithRepair(Repair repair) {
        CarAcceptanceDTO carAcceptanceDTO = new CarAcceptanceDTO();
        Car car = repair.getCar();
        User user = repair.getCar().getOwner();
        Address address = repair.getCar().getOwner().getAddress();
        CarRepairPhoto carRepairPhoto = new CarRepairPhoto();
        carAcceptanceDTO.setCarId(car.getId());
        carAcceptanceDTO.setMark(car.getMark());
        carAcceptanceDTO.setModel(car.getModel());
        carAcceptanceDTO.setEngineDesignation(car.getEngineDesignation());
        carAcceptanceDTO.setEngineCode(car.getEngineCode());
        carAcceptanceDTO.setYear(car.getYear());
        carAcceptanceDTO.setPlateNumber(car.getPlateNumber());
        carAcceptanceDTO.setChassisNumber(car.getChassisNumber());
        carAcceptanceDTO.setMeterReading(car.getMeterReading());
        carAcceptanceDTO.setRepairId(repair.getId());
        carAcceptanceDTO.setRepairNumber(repair.getRepairNumber());
        carAcceptanceDTO.setDateOfAdmission(repair.getDateOfAdmission());
        carAcceptanceDTO.setDataOfPickup(repair.getDataOfPickup());
        carAcceptanceDTO.setFaultsReportedByCustomer(repair.getFaultsReportedByCustomer());
        carAcceptanceDTO.setEstimatedRepairPrice(repair.getEstimatedRepairPrice());
        carAcceptanceDTO.setFinalRepairPrice(repair.getFinalRepairPrice());
        carAcceptanceDTO.setScopeOfWork(repair.getScopeOfWork());
        carAcceptanceDTO.setStatus(repair.getStatus());
        carAcceptanceDTO.setUserId(user.getId());
        carAcceptanceDTO.setEmail(user.getEmail());
        carAcceptanceDTO.setPassword(user.getPassword());
        carAcceptanceDTO.setFirstName(user.getFirstName());
        carAcceptanceDTO.setSurname(user.getSurame());
        carAcceptanceDTO.setPhoneNumber(user.getPhoneNumber());
        carAcceptanceDTO.setAddressId(address.getId());
        carAcceptanceDTO.setStreet(address.getStreet());
        carAcceptanceDTO.setHouseNumber(address.getHouseNumber());
        carAcceptanceDTO.setApartmentNumber(address.getApartmentNumber());
        carAcceptanceDTO.setPostCode(address.getPostCode());
        carAcceptanceDTO.setCity(address.getCity());
//        carAcceptanceDTO.setPhotoOne(carRepairPhoto.getPhotoOne());
//        carAcceptanceDTO.setPhotoTwo(carRepairPhoto.getPhotoTwo());
//        carAcceptanceDTO.setPhotoThree(carRepairPhoto.getPhotoThree());
//        carAcceptanceDTO.setPhotoFour(carRepairPhoto.getPhotoFour());
        carAcceptanceDTO.setPhotoId(carRepairPhoto.getId());
        return carAcceptanceDTO;

    }

    public static Repair toRepairEntity(CarAcceptanceDTO carAcceptanceDTO) {
        Repair repair = new Repair();
        repair.setId(carAcceptanceDTO.getRepairId());
        repair.setRepairNumber(carAcceptanceDTO.getRepairNumber());
        repair.setDateOfAdmission(carAcceptanceDTO.getDateOfAdmission());
        repair.setDataOfPickup(carAcceptanceDTO.getDataOfPickup());
        repair.setFaultsReportedByCustomer(carAcceptanceDTO.getFaultsReportedByCustomer());
        repair.setEstimatedRepairPrice(carAcceptanceDTO.getEstimatedRepairPrice());
        repair.setFinalRepairPrice(carAcceptanceDTO.getFinalRepairPrice());
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

        CarRepairPhoto carRepairPhoto = new CarRepairPhoto();
        carRepairPhoto.setRepair(repair);
//        carRepairPhoto.setPhotoOne(carAcceptanceDTO.getPhotoOne());
//        carRepairPhoto.setPhotoTwo(carAcceptanceDTO.getPhotoTwo());
//        carRepairPhoto.setPhotoThree(carAcceptanceDTO.getPhotoThree());
//        carRepairPhoto.setPhotoFour(carAcceptanceDTO.getPhotoFour());


        return repair;

    }
}
