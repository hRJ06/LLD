package Abstract_Factory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new WindowFactory();
        Application app = new Application(factory);
        app.renderUI();
    }
}
