package File_System.CompositePattern.Concrete_Implementation;

import java.util.Collection;

import File_System.CompositePattern.FileSystemNode;

public class Directory extends FileSystemNode {
    public Directory(String name) {
        super(name);
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public void display(int depth) {
        String indent = " ".repeat(depth * 2);
        Collection<FileSystemNode> children = getChildren();
        System.out.println(indent + "📁 " + getName() + "(" + children.size() + " items)");
        for(FileSystemNode child : children) {
            child.display(depth + 1);
        }
    }
}
