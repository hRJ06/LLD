package Vending_Machine.State_Design_Pattern.Concrete_State;

import Vending_Machine.State_Design_Pattern.VendingMachineContext;
import Vending_Machine.State_Design_Pattern.VendingMachineState;

public class SelectionState implements VendingMachineState {

    public SelectionState() {
        System.out.println("Vending Machine is in Selection State.");
    }

    @Override
    public String getName() {
        return "Selection state.";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(context.getSelectedItemCode() > 0) {
            return new DispenseState();
        }
        return this;
    }
}
