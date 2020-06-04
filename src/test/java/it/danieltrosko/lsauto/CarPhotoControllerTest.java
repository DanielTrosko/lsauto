package it.danieltrosko.lsauto;

import it.danieltrosko.lsauto.controller.CarRepairPhotoController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
public class CarPhotoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CarRepairPhotoController carRepairPhotoController;


    @Before
    public void start() {
        mockMvc = MockMvcBuilders.standaloneSetup(carRepairPhotoController).build();
    }


    @Test
    public void shouldReturnCorrectImage() throws Exception {
        mockMvc
                .perform(get("/photo/show").param("id", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_PNG))
                .andReturn();
    }
}
