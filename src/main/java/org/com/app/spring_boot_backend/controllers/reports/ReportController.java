package org.com.app.spring_boot_backend.controllers.reports;


import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.com.app.spring_boot_backend.services.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/check")
    public String Reports(){
        return "IT's Working";
    }

    @GetMapping("/work_report")
    public void generateWorkReport(HttpServletResponse response) throws JRException, IOException {

        // 1 - generate the report
        JasperPrint jasperReport = reportService.generateWorkTypeReport();

        // 2 - set response types
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=WorkTypeReport.pdf");

        // 3 - export to browser
        OutputStream out = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperReport,out);
        out.flush();
        out.close();

    }

    @GetMapping("/work_sub_report")
    public void generateWorkSubReport(HttpServletResponse response) throws JRException,IOException{

        // 1 - generate the report
        JasperPrint jasperReport = reportService.generateWorkSubTypeReport();

        // 2 - set response types
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=WorkReport.pdf");

        // 3 - export to browser
        OutputStream out = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperReport,out);
        out.flush();
        out.close();



    }


}
