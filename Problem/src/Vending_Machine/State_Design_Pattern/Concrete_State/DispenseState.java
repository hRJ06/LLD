package Vending_Machine.State_Design_Pattern.Concrete_State;

import Vending_Machine.State_Design_Pattern.VendingMachineContext;
import Vending_Machine.State_Design_Pattern.VendingMachineState;

public class DispenseState implements VendingMachineState {

    public DispenseState() {
        System.out.println("Vending Machine is in Dispense State.");
    }

    @Override
    public String getName() {
        return "Dispense state.";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        return new IdleState();
    }
}
