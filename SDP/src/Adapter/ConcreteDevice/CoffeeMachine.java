package Adapter.ConcreteDevice;

public class CoffeeMachine {
    public void initializeZigbeeConnection() {
        System.out.println("Coffee Machine connected via Zigbee.");
    }

    public void startBrewing() {
        System.out.println("Coffee Machine is now brewing coffee.");
    }

    public void stopBrewing() {
        System.out.println("Coffee Machine stopped brewing coffee.");
    }

    public void terminateZigbeeConnection() {
        System.out.println("Coffee Machine disconnected from Zigbee.");
    }
}
