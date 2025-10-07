package org.com.app.spring_boot_backend.documents.services;

import org.com.app.spring_boot_backend.documents.entity.DocumentInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class DocumentService {

    @Value("${base.documents.path}")
    private String basePath;

    /**
     * Returns all folders and files (category -> list of files)
     */
    public List<Map<String, Object>> getAllDocuments() {
        File baseDir = new File(basePath);
        if (!baseDir.exists() || !baseDir.isDirectory()) {
            throw new RuntimeException("Base directory not found: " + basePath);
        }

        List<Map<String, Object>> response = new ArrayList<>();

        // List subfolders
        File[] folders = baseDir.listFiles(File::isDirectory);
        if (folders != null) {
            for (File folder : folders) {
                Map<String, Object> folderData = new LinkedHashMap<>();
                folderData.put("folder", folder.getName());
                folderData.put("files", getFilesInFolder(folder));
                response.add(folderData);
            }
        }

        return response;
    }

    /**
     * Returns list of files inside a folder
     */
    private List<DocumentInfo> getFilesInFolder(File folder) {
        File[] files = folder.listFiles(File::isFile);
        List<DocumentInfo> fileList = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                String displayName = fileName.replaceFirst("^[0-9]+_", "")
                        .replaceAll("\\.[^.]+$", ""); // remove prefix + extension
                fileList.add(new DocumentInfo(
                        fileName,
                        displayName,
                        "/api/documents/" + folder.getName() + "/" + fileName
                ));
            }

            // sort files by prefix number (01_, 02_, etc.)
            fileList.sort(Comparator.comparingInt(f -> {
                try {
                    return Integer.parseInt(f.getFileName().split("_")[0]);
                } catch (Exception e) {
                    return Integer.MAX_VALUE;
                }
            }));
        }

        return fileList;
    }

    /**
     * Returns a Resource to download/view the file
     */
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
