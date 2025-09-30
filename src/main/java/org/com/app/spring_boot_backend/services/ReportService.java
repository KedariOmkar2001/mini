package org.com.app.spring_boot_backend.services;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.com.app.spring_boot_backend.dtos.reports.WorkTypeReportDTO;
import org.com.app.spring_boot_backend.dtos.works.WorkSubType.WorkSubTypeDTO;
import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeDTO;
import org.com.app.spring_boot_backend.entities.Employee.Employee;
import org.com.app.spring_boot_backend.entities.works.WorkSubType;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {

    private WorkSubTypeService workSubTypeService;
    private WorkTypeService workTypeService;
    public ReportService(WorkTypeService workTypeService,WorkSubTypeService workSubTypeService){
        this.workTypeService = workTypeService;
        this.workSubTypeService = workSubTypeService;
    }


    public JasperPrint generateWorkSubTypeReport() throws JRException {
        // 1 - Compile the JRXML file to JasperReport
        String filepath = "W:\\cdac_work\\wamis_mini\\spring_boot_backend\\src\\main\\resources\\reports\\work_sub_type_report.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(filepath);

        List<WorkSubTypeDTO> workSubTypes = workSubTypeService.getAllWorkSubTypes();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(workSubTypes);

        // 3 - Parameters (optional, can be used inside report.jrxml as $P{ReportTitle})
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ReportTitle", "Work Sub Type Report");

        // 4 - Fill report (compile + data + parameters)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return jasperPrint;
    }


    public JasperPrint generateWorkTypeReport() throws JRException {

        // 1 - Compile the JRXML file to JasperReport
        String filepath = "W:\\cdac_work\\wamis_mini\\spring_boot_backend\\src\\main\\resources\\reports\\work_type_report.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(filepath);

        List<WorkTypeDTO> worktypes = workTypeService.getAllWorkTypes();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(worktypes);

        // 3 - Parameters (optional, can be used inside report.jrxml as $P{ReportTitle})
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ReportTitle", "Work Type Report");

        // 4 - Fill report (compile + data + parameters)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        return jasperPrint;
    }


}
