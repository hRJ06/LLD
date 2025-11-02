import Adapter.ConcreteAdapter.AirConditionerAdapter;
import Adapter.ConcreteAdapter.CoffeeMachineAdapter;
import Adapter.ConcreteAdapter.SmartLightAdapter;
import Adapter.ConcreteDevice.AirConditioner;
import Adapter.ConcreteDevice.CoffeeMachine;
import Adapter.ConcreteDevice.SmartLight;
import Adapter.SmartDevice;

public class Main {
    public static void main(String[] args) {
        SmartDevice airConditioner = new AirConditionerAdapter(new AirConditioner());
        SmartDevice smartLight = new SmartLightAdapter(new SmartLight());
        SmartDevice coffeeMachine = new CoffeeMachineAdapter(new CoffeeMachine());

        airConditioner.turnOn();
        airConditioner.turnOff();

        smartLight.turnOn();
        smartLight.turnOff();

        coffeeMachine.turnOn();
        coffeeMachine.turnOff();
    }
}