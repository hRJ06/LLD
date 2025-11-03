package File_System;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("File System Manager - Commands:");
        System.out.println("1. create <path> - Create a new path");
        System.out.println("2. write <path> <content> - Write content to a file");
        System.out.println("3. read <path> - Read content from a file");
        System.out.println("4. delete <path> - Delete a path");
        System.out.println("5. display - Show the entire file system structure");
        System.out.println("6. exit - Exit the program");

        while (isRunning) {
            System.out.println("\nEnter command - ");
            String input = sc.nextLine().trim();
            String[] parts = input.split("\\s", 3);
            if(parts.length > 0) {
                String command = parts[0].toLowerCase();
                try {
                    switch (command) {
                    case "create" -> {
                        if(parts.length >= 2) {
                            String path = parts[1];
                            boolean isCreated = fs.createPath(path);
                            System.out.println(isCreated ? "Path created successfully." : "Failed to create path.");
                        } else {
                            System.out.println("Usage - create <paht>");
                        }
                    }
                    case "write" -> {
                        if(parts.length >= 3) {
                            String path = parts[1], content = parts[2];
                            boolean isWritten = fs.setFileContent(path, content);
                            System.out.println(isWritten ? "Content written successfully." : "Failed to write content.");
                        } else {
                            System.out.println("Usage - write <path> <content>");
                        }
                    }
                    case "read" -> {
                        if(parts.length >= 2) {
                            String path = parts[1];
                            String content = fs.getFileContent(path);
                            System.out.println(Objects.nonNull(content) ? "Content - " + content : "Failed to read content.");
                        }
                        else {
                            System.out.println("Usage - read <path>");
                        }
                    }
                    case "delete" -> {
                        if (parts.length >= 2) {
                            String path = parts[1]; 
                            boolean isDeleted = fs.deletePath(path); 
                            System.out.println(isDeleted ? "Path deleted successfully." : "Failed to delete path.");
                        } else {
                            System.out.println("Usage - delete <path>");
                        }
                    }
                    case "display" -> {
                        System.out.println("File System structure");
                        fs.display();
                    }
                    case "exit" -> {
                        isRunning = false;
                        System.out.println("Exiting.");
                    }
                    default -> {
                        System.out.println("Unknown command. Available commands - create, write, read, delete, display, exit.");
                    }
                }
                }
                catch (Exception e) {
                    System.out.println("Error - " + e.getMessage());
                }
            }
        }
        sc.close();
    }
}
