package org.com.app.spring_boot_backend.documents.entity;

public class DocumentInfo {
    private String fileName;
    private String displayName;
    private String url;

    public DocumentInfo(String fileName, String displayName, String url) {
        this.fileName = fileName;
        this.displayName = displayName;
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUrl() {
        return url;
    }
}
