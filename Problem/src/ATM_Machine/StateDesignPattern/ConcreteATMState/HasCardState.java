package ATM_Machine.StateDesignPattern.ConcreteATMState;

import ATM_Machine.StateDesignPattern.ATMState;
import ATM_Machine.StateDesignPattern.ATMContext.ATMMachineContext;

public class HasCardState implements ATMState {
    public HasCardState() {
        System.out.println("ATM is in Has Card State - Please enter your PIN.");
    }

    @Override
    public String getStateName() {
        return "Has Card State.";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentAccount() != null) {
            return context.getStateFactory().createSelectOperationState();
        }
        return this;
    }
    
}
