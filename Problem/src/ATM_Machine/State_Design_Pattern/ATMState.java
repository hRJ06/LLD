package ATM_Machine.State_Design_Pattern;

import ATM_Machine.State_Design_Pattern.ATMContext.ATMMachineContext;

public interface ATMState {
    String getStateName();
    ATMState next(ATMMachineContext context);
}
