package ATM_Machine.State_Design_Pattern.ConcreteATMState;

import ATM_Machine.State_Design_Pattern.ATMState;
import ATM_Machine.State_Design_Pattern.ATMContext.ATMMachineContext;

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
