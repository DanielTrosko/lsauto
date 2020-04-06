package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.mapper.CarAcceptanceMapper;
import it.danieltrosko.lsauto.model.entites.CarRepairPhoto;
import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import it.danieltrosko.lsauto.model.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CarAcceptanceService {
    private AddressRepository addressRepository;
    private CarRepository carRepository;
    private UserRepository userRepository;
    private RepairRepository repairRepository;
    private CarRepairPhotoRepository carRepairPhotoRepository;

    public CarAcceptanceService(AddressRepository addressRepository, CarRepository carRepository, UserRepository userRepository, RepairRepository repairRepository, CarRepairPhotoRepository carRepairPhotoRepository) {
        this.addressRepository = addressRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.repairRepository = repairRepository;
        this.carRepairPhotoRepository = carRepairPhotoRepository;
    }

    public void createAcceptance(CarAcceptanceDTO carAcceptanceDTO) {
        Repair repair = CarAcceptanceMapper.toRepairEntity(carAcceptanceDTO);

        addressRepository.save(repair.getCar().getOwner().getAddress());
        userRepository.save(repair.getCar().getOwner());
        carRepository.save(repair.getCar());
        repairRepository.save(repair);



    }

    public void createRepairWithPhotos
            (Map<String, String> param, List<MultipartFile> files) throws IOException {
        CarAcceptanceDTO carAcceptanceDTO = new CarAcceptanceDTO();
        carAcceptanceDTO.setMark(param.get("mark"));
        carAcceptanceDTO.setModel(param.get("model"));
        carAcceptanceDTO.setYear(param.get("year"));
        carAcceptanceDTO.setPlateNumber(param.get("plateNumber"));
        carAcceptanceDTO.setChassisNumber(param.get("chassisNumber"));
        carAcceptanceDTO.setMeterReading(param.get("meterReading"));
        carAcceptanceDTO.setEmail(param.get("email"));
        carAcceptanceDTO.setFirstName(param.get("firstName"));
        carAcceptanceDTO.setSurname(param.get("surname"));
        carAcceptanceDTO.setPhoneNumber(param.get("phoneNumber"));
        carAcceptanceDTO.setStreet(param.get("street"));
        carAcceptanceDTO.setApartmentNumber(param.get("apartmentNumber"));
        carAcceptanceDTO.setHouseNumber(param.get("houseNumber"));
        carAcceptanceDTO.setPostCode(param.get("postCode"));
        carAcceptanceDTO.setCity(param.get("city"));
        carAcceptanceDTO.setFaultsReportedByCustomer(param.get("faultsReportedByCustomer"));
        carAcceptanceDTO.setEstimatedRepairPrice(param.get("estimatedRepairPrice"));
        carAcceptanceDTO.setDataOfPickup(LocalDate.now());
        carAcceptanceDTO.setStatus(RepairStatus.ACCEPTED);
//        carAcceptanceDTO.setPhotoOne(photoOne.getBytes());
//        carAcceptanceDTO.setPhotoTwo(photoTwo.getBytes());
//        carAcceptanceDTO.setPhotoThree(photoThree.getBytes());
//        carAcceptanceDTO.setPhotoFour(photoFour.getBytes());
        System.err.println(carAcceptanceDTO.getEmail());
        Repair repair = CarAcceptanceMapper.toRepairEntity(carAcceptanceDTO);

        addressRepository.save(repair.getCar().getOwner().getAddress());
        userRepository.save(repair.getCar().getOwner());
        carRepository.save(repair.getCar());
        repairRepository.save(repair);

        for (int i = 0; i < files.size(); i++) {
            CarRepairPhoto carRepairPhoto = new CarRepairPhoto();
            carRepairPhoto.setRepair(repair);
            carRepairPhoto.setPhoto(files.get(i).getBytes());
            carRepairPhotoRepository.save(carRepairPhoto);
        }

    }
}
