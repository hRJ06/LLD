package File_System.CompositePattern.Concrete_Implementation;

import File_System.CompositePattern.FileSystemNode;

public class File extends FileSystemNode{
    private String content;
    private String extension;

    public File(String name) {
        super(name);
        this.content = "";
        this.extension = extractExtension(name);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        updateModifiedAt();
    }

    private String extractExtension(String name) {
        int dotIndex = name.lastIndexOf('.');
        return (dotIndex > 0) ? name.substring(dotIndex + 1) : "";
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public void display(int depth) {
        String indent = " ".repeat(depth * 2);
        System.out.println(indent + "📄 " + getName());
    }
}
