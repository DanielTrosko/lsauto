package it.danieltrosko.lsauto.services;

import net.sf.jasperreports.engine.*;

import java.util.Map;


public class JasperReportService {

    public static byte[] generatePDF(Map<String, Object> param) throws JRException {

        String jrxml = "src/main/resources/carAcceptancePDF.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxml);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JREmptyDataSource(1));
        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);

        return bytes;
    }
}


