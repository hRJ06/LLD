package Abstract_Factory;

public class Application {
    private final Button button;
    private final ScrollBar scrollBar;

    public Application(AbstractFactory factory) {
        this.button = factory.createButton();
        this.scrollBar = factory.createScrollBar();
    }

    public void renderUI() {
        button.render();
        scrollBar.scroll();
    }
}
