package Memento_Design_Pattern;

public class TextEditorApplication {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CareTaker careTaker = new CareTaker();

        editor.write("Hello World!");
        careTaker.saveState(editor);

        editor.write("This is Memento Design Pattern");
        careTaker.saveState(editor);

        System.out.println(editor.getContent());
        careTaker.undoState(editor);
        System.out.println(editor.getContent());
    }
}
