package File_System;

import java.util.Objects;

import File_System.CompositePattern.FileSystemNode;
import File_System.CompositePattern.Concrete_Implementation.Directory;
import File_System.CompositePattern.Concrete_Implementation.File;

public class FileSystem {
    public FileSystemNode root;

    public FileSystem() {
        this.root = new Directory("/");
    }

    public boolean createPath(String path) {
        if(!isValidPath(path)) {
            return false;
        }
        String[] components = path.split("/");
        FileSystemNode current = root;
        for(int i = 1; i<components.length - 1; i++) {
            String component = components[i];
            if(component.isEmpty()) {
                return false;
            }
            if(!current.hasChild(component)) {
                FileSystemNode directory = new Directory(component);
                current.addChild(component, directory);
            }
            FileSystemNode child = current.getChild(component);
            if(child.isFile()) {
                return false;
            }
            current = child;
        }
        String lastChild = components[components.length - 1];
        if(lastChild.isEmpty()) {
            return false;
        }
        if(current.hasChild(lastChild)) {
            return false;
        }
        FileSystemNode newNode;
        if(lastChild.contains(".")) {
            newNode = new File(lastChild);
        } else {
            newNode = new Directory(lastChild);
        }
        current.addChild(lastChild, newNode);
        return true;
    }

    public boolean deletePath(String path) {
        if(!isValidPath(path)) {
            return false;
        }
        if(path.equals("/")) {
            return false;
        }
        String parentPath = getParentPath(path);
        FileSystemNode parentNode = getNode(parentPath);
        if(Objects.isNull(parentNode) || parentNode.isFile()) {
            return false;
        }
        String lastComponent = path.substring(path.lastIndexOf("/") + 1);
        if(!parentNode.hasChild(lastComponent)) {
            return false;
        }
        parentNode.removeChild(lastComponent);
        return true;
    }

    public void display() {
        root.display(0);
    }
    
    public boolean setFileContent(String path, String content) {
        FileSystemNode node = getNode(path);
        if(Objects.isNull(node) || !node.isFile()) {
            return false;
        }
        File file = (File) node;
        file.setContent(content);
        return true;
    }

    public String getFileContent(String path) {
        FileSystemNode node = getNode(path);
        if(Objects.isNull(node) || !node.isFile()) {
            return null;
        }
        File file = (File) node;
        return file.getContent();
    }
    
    private String getParentPath(String path) {
        int lastSlash = path.lastIndexOf("/");
        if(lastSlash <= 0) {
            return "/";
        }
        return path.substring(0, lastSlash);
    }

    FileSystemNode getNode(String path) {
        if(!isValidPath(path)) {
            return null;
        }
        if(path.equals("/")) {
            return root;
        }
        FileSystemNode current = root;
        String[] components = path.split("/");
        for(int i = 1; i<components.length; i++) {
            String component = components[i];
            if(component.isEmpty()) {
                continue;
            }
            if(!current.hasChild(component)) {
                return null;
            }
            current = current.getChild(component);
        }
        return current;
    }
    private boolean isValidPath(String path) {
        return path != null && !path.isEmpty() && path.startsWith("/");
    }
}
