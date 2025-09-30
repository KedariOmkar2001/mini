package org.com.app.spring_boot_backend.dtos.works.WorkSubType;

import org.com.app.spring_boot_backend.dtos.works.WorkType.WorkTypeDTO;

public class WorkSubTypeDTO {
    private Integer workSubTypeId;
    private String workSubType;
    private Integer workTypeId;
    private WorkTypeDTO workType; // For display purposes, nested primary DTO

    // Constructors
    public WorkSubTypeDTO() {}

    public WorkSubTypeDTO(Integer workSubTypeId, String workSubType, Integer workTypeId, WorkTypeDTO workType) {
        this.workSubTypeId = workSubTypeId;
        this.workSubType = workSubType;
        this.workTypeId = workTypeId;
        this.workType = workType;
    }

    // Getters and Setters
    public Integer getWorkSubTypeId() {
        return workSubTypeId;
    }

    public void setWorkSubTypeId(Integer workSubTypeId) {
        this.workSubTypeId = workSubTypeId;
    }

    public String getWorkSubType() {
        return workSubType;
    }

    public void setWorkSubType(String workSubType) {
        this.workSubType = workSubType;
    }

    public Integer getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(Integer workTypeId) {
        this.workTypeId = workTypeId;
    }

    public WorkTypeDTO getWorkType() {
        return workType;
    }

    public void setWorkType(WorkTypeDTO workType) {
        this.workType = workType;
    }

    @Override
    public String toString() {
        return "WorkSubTypeDTO{" +
                "workSubTypeId=" + workSubTypeId +
                ", workSubType='" + workSubType + '\'' +
                ", workTypeId=" + workTypeId +
                ", workType=" + workType +
                '}';
    }
}