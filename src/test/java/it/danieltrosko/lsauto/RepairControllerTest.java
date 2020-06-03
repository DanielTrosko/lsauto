package it.danieltrosko.lsauto;

import it.danieltrosko.lsauto.controller.RepairController;
import it.danieltrosko.lsauto.controller.UserController;
import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import javassist.tools.rmi.ObjectNotFoundException;
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
import org.springframework.web.util.NestedServletException;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.util.NestedServletException.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class RepairControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RepairController repairController;


    @Before
    public void start() {
        mockMvc = MockMvcBuilders.standaloneSetup(repairController).build();
    }


    @Test
    public void shouldRedirectToCurrentRepairs() throws Exception {
        mockMvc
                .perform(post("/repair/addnewrepair"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:currentrepairs"));
    }

    @Test
    public void shouldReturnCurrentRepairs() throws Exception {
        mockMvc
                .perform(get("/repair/currentrepairs"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("currentrepairs", hasItem(
                        allOf(
                                hasProperty("id", Matchers.is(1L)),
                                hasProperty("faultsReportedByCustomer", Matchers.is("Brak hamulca"))
                        )
                )))
                .andExpect(view().name("repair/current_repairs"));
    }

    @Test
    public void shouldReturnCorrectRepairById() throws Exception {
        mockMvc
                .perform(get("/repair/getonerepair").param("id", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(model().attribute("repair", hasProperty("estimatedRepairPrice", is("260"))))
                .andExpect(view().name("repair/edit_repair"));

    }

    @Test
    public void shouldAddCorrectRepair() throws Exception {
        mockMvc
                .perform(get("/repair/addrepair").param("id", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(model().attribute("repair", hasProperty("engineCode", is("BLS"))))
                .andExpect(view().name("repair/add_new_repair"));


        mockMvc
                .perform(get("/repair/addrepair"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("repair"))
                .andExpect(view().name("repair/add_new_repair"));
    }

    @Test
    public void shouldAddRepairToExistCar() throws Exception {
        mockMvc
                .perform(get("/repair/addrepairtoexistcar").param("id", String.valueOf(4L)))
                .andExpect(status().isOk())
                .andExpect(model().attribute("acceptance", hasProperty("engineDesignation", is("1.9"))))
                .andExpect(view().name("repair/add_new_repair_to_exist_car"));
    }


    @Test(expected = NestedServletException.class)
    public void shouldReturnObjectNotFoundException() throws Exception {
        mockMvc
                .perform(get("/repair/addrepairtoexistcar").param("id", String.valueOf(50L)))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("car acceptance does not exist"))
                .andExpect(view().name("repair/add_new_repair_to_exist_car"));
    }
}
