package org.com.app.spring_boot_backend.documents.controllers;

import org.com.app.spring_boot_backend.documents.entity.Document;
import org.com.app.spring_boot_backend.documents.services.DocumentService;
import org.com.app.spring_boot_backend.documents.services.DocumentServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/documentsdb",produces = "application/json")
@CrossOrigin(origins = "*")
public class DocumentControllerDb {

    @Autowired
    private DocumentServiceDb documentService;

    /**
     * Return JSON of all documents grouped by module
     */
    @GetMapping
    public List<Map<String, Object>> getDocuments() {
        return documentService.getAllDocuments();
    }

    /**
     * Download file by document ID
     */
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long id) throws Exception {
        Optional<Document> docOpt = documentService.getDocumentById(id);

        if (docOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Document doc = docOpt.get();

        File file = new File(doc.getUrlPath() + "/" + doc.getFileName());

        if (!file.exists() || file.isDirectory()) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = new FileSystemResource(file);

        String contentType = Files.probeContentType(file.toPath());
        if (contentType == null) contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + doc.getFileName() + "\"")
                .body(resource);
    }
}
