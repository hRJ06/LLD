package Vending_Machine.State_Design_Pattern;

public interface VendingMachineState {
    String getName();
    VendingMachineState next(VendingMachineContext context);
}
