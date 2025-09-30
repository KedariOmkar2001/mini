package org.com.app.spring_boot_backend.dtos.reports;

import org.com.app.spring_boot_backend.entities.works.WorkSubType;

import java.util.List;

public class WorkTypeReportDTO {

    private int workTypeid;
    private String workType;
    private String workTypeCode;
    private String isImportant;
    private List<WorkSubType> subTypes;

    public int getWorkTypeid() {
        return workTypeid;
    }

    public void setWorkTypeid(int workTypeid) {
        this.workTypeid = workTypeid;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkTypeCode() {
        return workTypeCode;
    }

    public void setWorkTypeCode(String workTypeCode) {
        this.workTypeCode = workTypeCode;
    }

    public String getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(String isImportant) {
        this.isImportant = isImportant;
    }

    public List<WorkSubType> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<WorkSubType> subTypes) {
        this.subTypes = subTypes;
    }

    public void setWorkTypeId(int i) {
        this.workTypeid = i;
    }
}
