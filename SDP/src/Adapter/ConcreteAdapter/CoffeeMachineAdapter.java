package Adapter.ConcreteAdapter;

import Adapter.ConcreteDevice.CoffeeMachine;
import Adapter.SmartDevice;

public class CoffeeMachineAdapter implements SmartDevice {
    private final CoffeeMachine coffeeMachine;

    public CoffeeMachineAdapter(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void turnOn() {
        coffeeMachine.initializeZigbeeConnection();
        coffeeMachine.startBrewing();
    }

    @Override
    public void turnOff() {
        coffeeMachine.stopBrewing();
        coffeeMachine.terminateZigbeeConnection();
    }
}
