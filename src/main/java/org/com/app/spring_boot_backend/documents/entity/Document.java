package org.com.app.spring_boot_backend.documents.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "view_name", nullable = false)
    private String viewName;

    @Column(name = "is_activated", nullable = false)
    private Boolean activated;

    @Column(name = "url_path", nullable = false)
    private String urlPath;

    @Column(name = "file_module", nullable = false)
    private String module;

    // Constructors
    public Document() {}

    public Document(String fileName, String viewName, Boolean activated, String urlPath, String module) {
        this.fileName = fileName;
        this.viewName = viewName;
        this.activated = activated;
        this.urlPath = urlPath;
        this.module = module;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getViewName() { return viewName; }
    public void setViewName(String viewName) { this.viewName = viewName; }

    public Boolean getActivated() { return activated; }
    public void setActivated(Boolean activated) { this.activated = activated; }

    public String getUrlPath() { return urlPath; }
    public void setUrlPath(String urlPath) { this.urlPath = urlPath; }

    public String getModule() { return module; }
    public void setModule(String module) { this.module = module; }
}
