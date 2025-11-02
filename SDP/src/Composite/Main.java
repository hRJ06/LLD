package Composite;

import Composite.CompositeClass.CompositeSmartComponent;
import Composite.ConcreteDevice.AirConditioner;
import Composite.ConcreteDevice.SmartLight;

public class Main {
    public static void main(String[] args) {
        SmartComponent airConditioner = new AirConditioner();
        SmartComponent smartLight = new SmartLight();

        CompositeSmartComponent room1 = new CompositeSmartComponent();
        room1.addComponent(airConditioner);
        room1.addComponent(smartLight);

        CompositeSmartComponent room2 = new CompositeSmartComponent();
        room2.addComponent(airConditioner);
        room2.addComponent(smartLight);

        CompositeSmartComponent floor = new CompositeSmartComponent();
        floor.addComponent(room1);
        floor.addComponent(room2);

        CompositeSmartComponent house = new CompositeSmartComponent();
        house.addComponent(floor);

        System.out.println("Turning ON all device in the house - ");
        house.turnOn();
        System.out.println("Turning OFF all device in the house - ");
        house.turnOff();

        System.out.println("\nTurning ON all device on the 1st floor - ");
        floor.turnOn();
        System.out.println("Turning OFF all device on the 1st floor - ");
        floor.turnOff();

        System.out.println("\nTurning ON all device in Room 1 - ");
        room1.turnOn();
        System.out.println("Turning OFF all device in Room 1 - ");
        room1.turnOff();
    }
}
