package org.com.app.spring_boot_backend.dtos.works.WorkType;

public class WorkTypeDTO {
    private Integer workTypeId;
    private String workType;
    private String workTypeCode;
    private String isImportant;

    // Constructors
    public WorkTypeDTO() {}

    public WorkTypeDTO(Integer workTypeId, String workType, String workTypeCode, String isImportant) {
        this.workTypeId = workTypeId;
        this.workType = workType;
        this.workTypeCode = workTypeCode;
        this.isImportant = isImportant;
    }

    // Getters and Setters
    public Integer getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(Integer workTypeId) {
        this.workTypeId = workTypeId;
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
}