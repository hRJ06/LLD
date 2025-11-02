package Adapter.ConcreteAdapter;

import Adapter.ConcreteDevice.AirConditioner;
import Adapter.SmartDevice;

public class AirConditionerAdapter implements SmartDevice {
    private final AirConditioner airConditioner;

    public AirConditionerAdapter(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
    @Override
    public void turnOn() {
        airConditioner.connectViaBlueTooth();
        airConditioner.startCooling();
    }

    @Override
    public void turnOff() {
        airConditioner.stopCooling();
        airConditioner.disconnectBlueTooth();
    }
}
