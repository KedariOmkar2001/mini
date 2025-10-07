package org.com.app.spring_boot_backend.documents.controllers;

import org.com.app.spring_boot_backend.documents.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "*")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Map<String, Object>> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{folder}/{fileName:.+}")
    public ResponseEntity<Resource> downloadDocument(
            @PathVariable String folder,
            @PathVariable String fileName) throws Exception {

        Resource resource = documentService.getFile(folder, fileName);
        String contentType = Files.probeContentType(resource.getFile().toPath());
        if (contentType == null) contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
