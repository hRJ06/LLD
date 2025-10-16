package Command_Design_Pattern;

public class TextEditorApplication {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Button button = new Button();
        button.setCommand(new BoldCommand(editor));
        button.click();

        button.setCommand(new ItalicCommand(editor));
        button.click();
    }
}
