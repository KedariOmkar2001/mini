package org.com.app.spring_boot_backend.entities.works;

import jakarta.persistence.*;

@Entity
@Table(name = "worktypes")
public class WorkType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_type_id")
    private int workTypeId;

    @Column(name = "work_type")
    private String workType;

    @Column(name = "work_type_code")
    private String workTypeCode;

    @Column(name = "is_important")
    private String isImportant;

    // getters & setters
    public int getWorkTypeId() { return workTypeId; }
    public void setWorkTypeId(int workTypeId) { this.workTypeId = workTypeId; }

    public String getWorkType() { return workType; }
    public void setWorkType(String workType) { this.workType = workType; }

    public String getWorkTypeCode() { return workTypeCode; }
    public void setWorkTypeCode(String workTypeCode) { this.workTypeCode = workTypeCode; }

    public String getIsImportant() { return isImportant; }
    public void setIsImportant(String isImportant) { this.isImportant = isImportant; }
}
