package Memento_Design_Pattern;

import java.util.Stack;

public class CareTaker {
    public final Stack<EditorMemento> history = new Stack<>();

    public void saveState(TextEditor editor) {
        history.push(editor.save());
    }

    public void undoState(TextEditor editor) {
        if(!history.empty()) {
            history.pop();
            editor.restore(history.peek());
        }
    }
}
