package Abstract_Factory;

public class MacFactory implements AbstractFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MacScrollBar();
    }
}
