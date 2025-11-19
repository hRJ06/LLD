package ATM_Machine.StateDesignPattern.ConcreteATMState;

import ATM_Machine.StateDesignPattern.ATMState;
import ATM_Machine.StateDesignPattern.ATMContext.ATMMachineContext;

public class SelectOperationState implements ATMState {
    public SelectOperationState() {
        System.out.println("ATM is in Select Operation State - Please select an Operation");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Check Balance");
    }

    @Override
    public String getStateName() {
        return "Select Operation State";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getSelectedOperation() != null) {
            return context.getStateFactory().createTransactionState();
        }
        return this;
    }
}
