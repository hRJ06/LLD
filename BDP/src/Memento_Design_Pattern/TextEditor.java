package Memento_Design_Pattern;

public class TextEditor {
    private String content;

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void write(String content) {
        this.content = content;
    }

    public void restore(EditorMemento memento) {
        content = memento.getContent();
    }
    public String getContent() {
        return this.content;
    }
}
