package ATM_Machine.StateDesignPattern.ATMFactory;

import java.util.Objects;

import ATM_Machine.StateDesignPattern.ATMState;
import ATM_Machine.StateDesignPattern.ConcreteATMState.HasCardState;
import ATM_Machine.StateDesignPattern.ConcreteATMState.IdleState;
import ATM_Machine.StateDesignPattern.ConcreteATMState.SelectOperationState;
import ATM_Machine.StateDesignPattern.ConcreteATMState.TransactionState;

public class ATMStateFactory {
    private static ATMStateFactory instance = null;
    private ATMStateFactory() {}
    public static ATMStateFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ATMStateFactory();
        }
        return instance;
    }

    public ATMState createIdleState() {
        return new IdleState();
    }

    public ATMState createHasCardState() {
        return new HasCardState();
    }

    public ATMState createSelectOperationState() {
        return new SelectOperationState();
    }

    public ATMState createTransactionState() {
        return new TransactionState();
    }
}
