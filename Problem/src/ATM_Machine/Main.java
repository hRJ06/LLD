package ATM_Machine;

import ATM_Machine.Enum.TransactionType;
import ATM_Machine.StateDesignPattern.ATMContext.ATMMachineContext;
import ATM_Machine.Utility.Account;
import ATM_Machine.Utility.Card;

public class Main {
    public static void main(String[] args) {
        ATMMachineContext ATM = new ATMMachineContext();
        ATM.addAccount(new Account("AN_123", 1000.0));
        ATM.addAccount(new Account("AN_456", 500.0));
        try {
            ATM.insertCard(new Card("AN_123", 1234, "CN_123"));
            ATM.enterPin(1234);
            ATM.selectOperation(TransactionType.WITHDRAW_CASH);
            ATM.performOperation();
            ATM.selectOperation(TransactionType.VIEW_BALANCE);
            ATM.performOperation();
            ATM.returnCard();

        } catch (Exception e) {
            System.out.println("Error - " + e.getMessage());
        }
    }
}
