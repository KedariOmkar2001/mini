package org.com.app.spring_boot_backend.documents.services;


import org.com.app.spring_boot_backend.documents.entity.Document;
import org.com.app.spring_boot_backend.documents.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DocumentServiceDb {

    private DocumentRepository documentRepository;

    public DocumentServiceDb(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @Value("${base.documents.path}")
    private String basePath;

    /**
     * Returns documents grouped by module (folder)
     */
    public List<Map<String, Object>> getAllDocuments() {
        List<Document> documents = documentRepository.findAll();

        // Group by module
        Map<String, List<Document>> grouped = documents.stream()
                .collect(Collectors.groupingBy(Document::getModule, LinkedHashMap::new, Collectors.toList()));

        List<Map<String, Object>> response = new ArrayList<>();

        grouped.forEach((module, docs) -> {
            Map<String, Object> moduleMap = new LinkedHashMap<>();
            moduleMap.put("folder", module);

            List<Map<String, Object>> files = docs.stream().map(d -> {
                Map<String, Object> fileMap = new LinkedHashMap<>();
                fileMap.put("fileName", d.getFileName());
                fileMap.put("displayName", d.getViewName());
                fileMap.put("urlPath", d.getUrlPath());
                fileMap.put("isActivated",d.getActivated());
                fileMap.put("fileModule",d.getModule());
                return fileMap;
            }).collect(Collectors.toList());

            moduleMap.put("files", files);
            response.add(moduleMap);
        });

        return response;
    }

    /**
     * Get a document by ID
     */
    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(Math.toIntExact(id));
    }

    public Resource getFile(String folderName, String fileName) {
        File file = new File(basePath + "/" + folderName + "/" + fileName);

        // Security check
        if (!file.getAbsolutePath().startsWith(new File(basePath).getAbsolutePath())) {
            throw new SecurityException("Access denied: " + fileName);
        }
        if (!file.exists() || file.isDirectory()) {
            throw new RuntimeException("File not found: " + fileName);
        }

        return new FileSystemResource(file);
    }

}
