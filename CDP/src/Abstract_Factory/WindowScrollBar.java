package Abstract_Factory;

public class WindowScrollBar implements ScrollBar{
    @Override
    public void scroll() {
        System.out.println("Scrolling Window scrollbar.");
    }
}
