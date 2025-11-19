package ATM_Machine.StateDesignPattern;

import ATM_Machine.StateDesignPattern.ATMContext.ATMMachineContext;

public interface ATMState {
    String getStateName();
    ATMState next(ATMMachineContext context);
}
