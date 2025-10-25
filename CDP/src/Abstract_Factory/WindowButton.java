package Abstract_Factory;

public class WindowButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Window button.");
    }
}
