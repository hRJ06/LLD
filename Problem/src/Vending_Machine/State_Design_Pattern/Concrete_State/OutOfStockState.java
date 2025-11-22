package Vending_Machine.State_Design_Pattern.Concrete_State;

import Vending_Machine.State_Design_Pattern.VendingMachineContext;
import Vending_Machine.State_Design_Pattern.VendingMachineState;

public class OutOfStockState implements VendingMachineState {

    public OutOfStockState() {
        System.out.println("Vending Machine is in Out Of Stock State.");
    }

    @Override
    public String getName() {
        return "Out Of Stock state.";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(context.getInventory().hasItem()) {
            return new IdleState();
        }
        return this;
    }
}
