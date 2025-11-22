package ATM_Machine.State_Design_Pattern.ConcreteATMState;

import ATM_Machine.State_Design_Pattern.ATMState;
import ATM_Machine.State_Design_Pattern.ATMContext.ATMMachineContext;

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
