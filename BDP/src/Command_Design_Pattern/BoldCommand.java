package Command_Design_Pattern;

public class BoldCommand implements Command{
    private final TextEditor editor;

    public BoldCommand(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.bold();
    }
}
