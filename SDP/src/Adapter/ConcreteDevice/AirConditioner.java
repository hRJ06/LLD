package Adapter.ConcreteDevice;

public class AirConditioner {
    public void connectViaBlueTooth() {
        System.out.println("Air conditioner connected via BlueTooth.");
    }

    public void startCooling() {
        System.out.println("Air conditioner is now cooling.");
    }

    public void stopCooling() {
        System.out.println("Air conditioner stopped cooling.");
    }

    public void disconnectBlueTooth() {
        System.out.println("Air conditioner disconnected from BlueTooth");
    }
}
