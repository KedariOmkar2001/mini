package org.com.app.spring_boot_backend.dtos.works.WorkSubType;

public class WorkSubTypeSaveDto {

    String WorkSubType;
    String WorkSubTypeName;

    public String getWorkSubType() {
        return WorkSubType;
    }

    public void setWorkSubType(String workSubType) {
        WorkSubType = workSubType;
    }

    public String getWorkSubTypeName() {
        return WorkSubTypeName;
    }

    public void setWorkSubTypeName(String workSubTypeName) {
        WorkSubTypeName = workSubTypeName;
    }
}
