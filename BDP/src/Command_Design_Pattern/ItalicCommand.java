package Command_Design_Pattern;

public class ItalicCommand implements Command{
    private final TextEditor editor;

    public ItalicCommand(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.italic();
    }
}
