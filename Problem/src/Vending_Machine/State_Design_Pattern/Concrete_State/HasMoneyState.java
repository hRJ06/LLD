package Vending_Machine.State_Design_Pattern.Concrete_State;

import Vending_Machine.State_Design_Pattern.VendingMachineContext;
import Vending_Machine.State_Design_Pattern.VendingMachineState;

public class HasMoneyState implements VendingMachineState {

    public HasMoneyState() {
        System.out.println("Vending Machine is in Has Money State.");
    }

    @Override
    public String getName() {
        return "Has Money state.";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        return this;
    }
}
