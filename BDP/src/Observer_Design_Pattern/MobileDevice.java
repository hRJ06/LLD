package Observer_Design_Pattern;

public class MobileDevice implements Observer{
    private final String deviceName;

    public MobileDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(float temperature) {
        System.out.println("Temperature in " + deviceName + " - " + temperature);
    }
}
