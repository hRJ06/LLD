package Adapter.ConcreteAdapter;

import Adapter.ConcreteDevice.SmartLight;
import Adapter.SmartDevice;

public class SmartLightAdapter implements SmartDevice {
    private final SmartLight smartLight;

    public SmartLightAdapter(SmartLight smartLight) {
        this.smartLight = smartLight;
    }

    @Override
    public void turnOn() {
        smartLight.connectViaWifi();
        smartLight.switchOn();
    }

    @Override
    public void turnOff() {
        smartLight.switchOff();
        smartLight.disconnectWifi();
    }
}
