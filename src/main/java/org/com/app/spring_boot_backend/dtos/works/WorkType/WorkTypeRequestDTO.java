package org.com.app.spring_boot_backend.dtos.works.WorkType;

public class WorkTypeRequestDTO {
    private String workType;
    private String workTypeCode;
    private String isImportant;

    // getters & setters
    public String getWorkType() { return workType; }
    public void setWorkType(String workType) { this.workType = workType; }

    public String getWorkTypeCode() { return workTypeCode; }
    public void setWorkTypeCode(String workTypeCode) { this.workTypeCode = workTypeCode; }

    public String getIsImportant() { return isImportant; }
    public void setIsImportant(String isImportant) { this.isImportant = isImportant; }
}
