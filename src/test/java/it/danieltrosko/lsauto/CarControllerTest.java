package it.danieltrosko.lsauto;

import io.florianlopes.spring.test.web.servlet.request.MockMvcRequestBuilderUtils;
import it.danieltrosko.lsauto.controller.CarController;
import it.danieltrosko.lsauto.dto.CarDTO;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CarController carController;

    @Before
    public void start() {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }


    @Test
    public void shouldEditOrCreateNeCar() throws Exception {

        CarDTO carDTO = new CarDTO();
        carDTO.setMark("Fiat");
        carDTO.setYear("1999");
        carDTO.setPlateNumber("DW1R98");
        carDTO.setChassisNumber("TMBP4588FD59");
        carDTO.setMeterReading("198635");
        carDTO.setEmail("testowy@gmail.com");
        carDTO.setFirstName("Pawel");
        carDTO.setSurname("Kowalski");
        carDTO.setPhoneNumber("793568541");

        mockMvc
                .perform(get("/car/addnewcar"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("car"))
                .andExpect(view().name("car/add_new_car"))
                .andExpect(model().attributeHasNoErrors("car"));

        mockMvc
                .perform(get("/car/addnewcar").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("car", hasProperty("id", is(1L))))
                .andExpect(model().attribute("car", hasProperty("model", is("E60"))))
                .andExpect(view().name("car/add_new_car"));
    }

    @Test
    public void shouldReturnCorrectCar() throws Exception {

        mockMvc
                .perform(get("/car/showcar").param("id", "1"))
                .andExpect(model().attribute("car", hasProperty("id", is(1L))))
                .andExpect(model().attribute("car", hasProperty("model", is("E60"))))
                .andExpect(view().name("car/show_car"));

    }
}
