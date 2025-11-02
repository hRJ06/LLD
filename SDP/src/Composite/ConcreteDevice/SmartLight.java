package Composite.ConcreteDevice;

import Composite.SmartComponent;

public class SmartLight implements SmartComponent {
    @Override
    public void turnOn() {
        System.out.println("Smart Light is turned ON!");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Light is turned OFF!");
    }
}
