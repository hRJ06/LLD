package ATM_Machine.StateDesignPattern.ConcreteATMState;

import ATM_Machine.StateDesignPattern.ATMState;
import ATM_Machine.StateDesignPattern.ATMContext.ATMMachineContext;

public class TransactionState implements ATMState {
    public TransactionState() {
        System.out.println("ATM is in Transaction State.");
    }
    @Override
    public String getStateName() {
        return "Transaction State";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        return context.getStateFactory().createSelectOperationState();
    }

}
