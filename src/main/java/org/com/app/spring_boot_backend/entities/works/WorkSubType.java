package org.com.app.spring_boot_backend.entities.works;

import jakarta.persistence.*;

@Entity
@Table(name = "work_sub_types")
public class WorkSubType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_sub_type_id")
    private int workSubTypeId;

    @Column(name = "work_sub_type")
    private String workSubType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_type_id", referencedColumnName = "work_type_id")
    private WorkType workType; // relation to parent table

    // getters & setters
    public int getWorkSubTypeId() { return workSubTypeId; }
    public void setWorkSubTypeId(int workSubTypeId) { this.workSubTypeId = workSubTypeId; }

    public String getWorkSubType() { return workSubType; }
    public void setWorkSubType(String workSubType) { this.workSubType = workSubType; }

    public WorkType getWorkType() { return workType; }
    public void setWorkType(WorkType workType) { this.workType = workType; }
}
