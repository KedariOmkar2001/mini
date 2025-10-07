package org.com.app.spring_boot_backend.documents.dtos;

import java.util.List;

public class TreeNode {
    private String name;
    private String type; // "folder" or "file"
    private List<TreeNode> children;
    private String path; // Relative path for files/folders

    // Constructors, getters, setters
    public TreeNode() {}

    public TreeNode(String name, String type, String path) {
        this.name = name;
        this.type = type;
        this.path = path;
    }

    // Add getters and setters for all fields
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public List<TreeNode> getChildren() { return children; }
    public void setChildren(List<TreeNode> children) { this.children = children; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
}