package it.danieltrosko.lsauto;


import io.florianlopes.spring.test.web.servlet.request.MockMvcRequestBuilderUtils;
import it.danieltrosko.lsauto.controller.UserController;
import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.exception.UserNotFoundException;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserController userController;


    @Before
    public void start() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void shouldCreateNewUser() throws Exception {
        mockMvc
                .perform(get("/user/addnewuser"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/add_new_user"))
                .andExpect(model().attributeExists("user"))
                .andReturn();
    }

    @Test
    public void shouldReturnCorrectUser() throws Exception {
        mockMvc
                .perform(get("/user/edituser").param("id", String.valueOf(1)))
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("user/edit_user"))
                .andExpect(status().isOk());
    }

    @Test(expected = NestedServletException.class)
    public void shouldReturnError() throws Exception {
        mockMvc
                .perform(get("/user/edituser").param("id", String.valueOf(50)))
                .andExpect(view().name("user/edituser"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("user", new UserDTO()))
                .andExpect(status().isInternalServerError());

    }

    @Test
    public void shouldReturnValidUserList() throws Exception {
        mockMvc
                .perform(get("/user/userslist"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/users_list"))
                .andExpect(model().attribute("users", hasItem(
                        allOf(
                                hasProperty("id", Matchers.is(1L)),
                                hasProperty("firstName", Matchers.is("Jan"))
                        )
                )));
    }

    @Test
    public void shouldSaveorUpdateUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("poprawny@gmail.com");
        userDTO.setFirstName("Agnieszka");
        userDTO.setPhoneNumber("793569741");
        userDTO.setSurname("Kowalczyk");

        mockMvc
                .perform(MockMvcRequestBuilderUtils.postForm("/user/createuser", userDTO))
                .andExpect(status().isOk())
                .andExpect(view().name("user/add_new_user"));


    }
}
