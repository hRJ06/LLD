package Vending_Machine.State_Design_Pattern.Concrete_State;

import Vending_Machine.State_Design_Pattern.VendingMachineContext;
import Vending_Machine.State_Design_Pattern.VendingMachineState;

public class IdleState implements VendingMachineState {

    public IdleState() {
        System.out.println("Vending Machine is in Idle State.");
    }

    @Override
    public String getName() {
        return "Idle State.";
    }

    @Override
    public VendingMachineState next(VendingMachineContext context) {
        if(!context.getInventory().hasItem()) {
            return new OutOfStockState();
        }
        if(!context.getCoinList().isEmpty()) {
            return new HasMoneyState();
        }
        return this;
    }
}
