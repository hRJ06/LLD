package Abstract_Factory;

public class WindowFactory implements AbstractFactory{
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WindowScrollBar();
    }
}
