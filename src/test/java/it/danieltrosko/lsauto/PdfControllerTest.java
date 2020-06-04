package it.danieltrosko.lsauto;

import it.danieltrosko.lsauto.controller.PdfController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PdfControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PdfController pdfController;


    @Before
    public void start() {
        mockMvc = MockMvcBuilders.standaloneSetup(pdfController).build();
    }

    @Test
    public void shouldReturnCorrectPdf() throws Exception {
        mockMvc
                .perform(get("/pdf/caracceptance").param("id", String.valueOf(1L)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_PDF_VALUE))
                .andReturn();
    }
}
