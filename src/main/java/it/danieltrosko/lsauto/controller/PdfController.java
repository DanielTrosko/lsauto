package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.services.PdfService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
@RequestMapping(value = "/pdf")
public class PdfController {

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<byte[]> getCarAcceptance(@PathVariable("id") Long id) throws JRException, IOException {

        byte[] pdf = pdfService.getCarAcceptancePDF(id);
        return ResponseEntity.ok()
                .header("Content-Type", "application/pdf")
                .body(pdf);
    }

}
