package Composite.ConcreteDevice;

import Composite.SmartComponent;

public class AirConditioner implements SmartComponent {
    @Override
    public void turnOn() {
        System.out.println("Air Conditioner is turned ON!");
    }

    @Override
    public void turnOff() {
        System.out.println("Air Conditioner is turned OFF!");
    }
}
