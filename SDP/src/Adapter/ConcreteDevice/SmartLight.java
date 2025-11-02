package Adapter.ConcreteDevice;

public class SmartLight {
    public void connectViaWifi() {
        System.out.println("Smart Light connected to Wi-fi.");
    }

    public void switchOn() {
        System.out.println("Smart Light is now ON!");
    }

    public void switchOff() {
        System.out.println("Smart Light is now OFF!");
    }

    public void disconnectWifi() {
        System.out.println("Smart Light disconnected from Wi-fi.");
    }
}
