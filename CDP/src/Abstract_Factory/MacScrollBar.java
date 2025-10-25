package Abstract_Factory;

public class MacScrollBar implements ScrollBar{
    @Override
    public void scroll() {
        System.out.println("Scrolling MAC scrollbar.");
    }
}
