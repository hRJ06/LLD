package Observer_Design_Pattern;

public class WatchDevice implements Observer{
    private final String deviceName;

    public WatchDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(float temperature) {
        System.out.println("Temperature in " + deviceName + " - " + temperature);
    }
}
