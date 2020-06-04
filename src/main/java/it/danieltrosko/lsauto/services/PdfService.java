package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.mapper.CarAcceptanceMapper;
import it.danieltrosko.lsauto.model.repositories.RepairRepository;
import net.sf.jasperreports.engine.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class PdfService {

    private RepairRepository repairRepository;

    public PdfService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }


    public byte[] getCarAcceptancePDF(Long id) throws JRException, IOException {
        return generatePDF(getParamFromDB(id));

    }

    public byte[] generatePDF(Map<String, Object> param) throws JRException, IOException {
//        String resource = "C:\\Users\\Daniel\\Desktop\\Rep\\lsauto\\src\\main\\resources\\carAcceptancePDF.jrxml";
//        InputStream jrxml = getClass().getResourceAsStream("/resources/carAcceptancePDF.jrxml");
        Resource resource = new ClassPathResource("carAcceptancePDF.jrxml");
        InputStream jrxml = resource.getInputStream();

        JasperReport jasperReport = JasperCompileManager.compileReport(jrxml);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JREmptyDataSource(1));

        return JasperExportManager.exportReportToPdf(jasperPrint);
//        return new byte[2];
    }


    public Map<String, Object> getParamFromDB(Long id) {
        Map<String, Object> parameters = new HashMap<>();
        CarAcceptanceDTO carAcceptanceDTO = CarAcceptanceMapper.toDTOWithRepair(repairRepository.getOne(id));
        parameters.put("mark", carAcceptanceDTO.getMark());
        parameters.put("model", carAcceptanceDTO.getModel());
        parameters.put("year", carAcceptanceDTO.getYear());
        parameters.put("chassis", carAcceptanceDTO.getChassisNumber());
        parameters.put("meter", carAcceptanceDTO.getMeterReading());
        parameters.put("plateNumber", carAcceptanceDTO.getPlateNumber());
        parameters.put("name", carAcceptanceDTO.getFirstName());
        parameters.put("surname", carAcceptanceDTO.getSurname());
        parameters.put("email", carAcceptanceDTO.getEmail());
        parameters.put("phoneNumber", carAcceptanceDTO.getPhoneNumber());
        parameters.put("street", carAcceptanceDTO.getStreet());
        parameters.put("houseNumber", carAcceptanceDTO.getHouseNumber());
        parameters.put("apartmentNumber", carAcceptanceDTO.getApartmentNumber());
        parameters.put("postCode", carAcceptanceDTO.getPostCode());
        parameters.put("city", carAcceptanceDTO.getCity());
        parameters.put("repairNumber", carAcceptanceDTO.getRepairNumber());
        parameters.put("dataOfPickup", carAcceptanceDTO.getDataOfPickup().toString());
        parameters.put("dateOfAdmission", carAcceptanceDTO.getDateOfAdmission().toString());
        parameters.put("scopeOfWork", carAcceptanceDTO.getScopeOfWork());
        parameters.put("date", LocalDate.now().toString());
        return parameters;
    }

}
