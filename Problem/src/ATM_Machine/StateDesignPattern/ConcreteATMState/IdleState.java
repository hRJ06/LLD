package ATM_Machine.StateDesignPattern.ConcreteATMState;

import ATM_Machine.StateDesignPattern.ATMState;
import ATM_Machine.StateDesignPattern.ATMContext.ATMMachineContext;

public class IdleState implements ATMState {

    public IdleState() {
        System.out.println("ATM is in Idle State - Please insert your card.");
    }

    @Override
    public String getStateName() {
       return "Idle State";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() != null) {
            return context.getStateFactory().createHasCardState();
        }
        return this;
    }

}
