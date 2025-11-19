package ATM_Machine.StateDesignPattern.ATMContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import ATM_Machine.Enum.CashType;
import ATM_Machine.Enum.TransactionType;
import ATM_Machine.StateDesignPattern.ATMState;
import ATM_Machine.StateDesignPattern.ATMFactory.ATMStateFactory;
import ATM_Machine.StateDesignPattern.ConcreteATMState.HasCardState;
import ATM_Machine.StateDesignPattern.ConcreteATMState.IdleState;
import ATM_Machine.StateDesignPattern.ConcreteATMState.SelectOperationState;
import ATM_Machine.StateDesignPattern.ConcreteATMState.TransactionState;
import ATM_Machine.Utility.ATMInventory;
import ATM_Machine.Utility.Account;
import ATM_Machine.Utility.Card;

public class ATMMachineContext {
    private ATMState currentState;
    private Account currentAccount;
    private Card currentCard;
    private TransactionType selectedOperation;
    private Map<String, Account> accounts;
    private ATMInventory atmInventory;
    private ATMStateFactory stateFactory;

    public ATMMachineContext() {
        this.stateFactory = ATMStateFactory.getInstance();
        this.currentState = stateFactory.createIdleState();
        this.atmInventory = new ATMInventory();
        this.accounts = new HashMap<>();
        System.out.println("ATM initialized in - " + currentState.getStateName());
    }


    private void advanceState() {
        ATMState nextState = currentState.next(this);
        this.currentState = nextState;
        System.out.println("Current State - " + currentState.getStateName());
    }

    private void resetATM() {
        this.currentCard = null;
        this.currentAccount = null;
        this.selectedOperation = null;
        this.currentState = stateFactory.createIdleState();
    }

    private void performWithdrawal(int amount) throws Exception {
        if(!currentAccount.withdraw(amount)) {
            throw new Exception("Insufficient balance.");
        }
        if(!atmInventory.hasSufficientCash(amount)) {
            currentAccount.deposit(amount);
            throw new Exception("Insufficient cash in ATM.");
        }
        Map<CashType, Integer> dispensedCash = atmInventory.dispenseCash(amount);
        if(Objects.isNull(dispensedCash)) {
            currentAccount.deposit(amount);
            throw new Exception("Unable to dispense exact amount.");
        } 
        System.out.println("Transaction successful. Please collect your cash - ");
        for(Map.Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
            System.out.println(entry.getValue() + " x $" + entry.getKey().value);
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is $" + currentAccount.getBalance());
    }

    public void insertCard(Card card) {
        if(currentState instanceof IdleState) {
            System.out.println("Card inserted.");
            this.currentCard = card;
            advanceState();
        } else {
            System.out.println("Cannot insert card in - " + currentState.getStateName());
        }
    }

    public void enterPin(int pin) {
        if(currentState instanceof HasCardState) {
            if(currentCard.validatePin(pin)) {
                System.out.println("PIN authenticated successfully.");
                this.currentAccount = accounts.get(currentCard.getAccountNumber());
                advanceState();
            } else {
                System.out.println("Invalid PIN. Please try again.");
            }
        } else {
            System.out.println("Cannot enter PIN in - " + currentState.getStateName());
        }
    }

    public void selectOperation(TransactionType transactionType) {
        if(currentState instanceof SelectOperationState) {
            System.out.println("Selected operation - " + transactionType);
            this.selectedOperation = transactionType;
            advanceState();
        } else {
            System.out.println("Cannot select operation in - " + currentState.getStateName());
        }
    }

    public void performOperation() {
        if(currentState instanceof TransactionState) {
            try {
                if(selectedOperation == TransactionType.WITHDRAW_CASH) {
                    System.out.print("Enter amount - ");
                    Scanner scanner = new Scanner(System.in);
                    int amount = scanner.nextInt();
                    scanner.close();
                    performWithdrawal(amount);
                } else if(selectedOperation == TransactionType.VIEW_BALANCE) {
                    checkBalance();
                }
                advanceState();
            }
            catch(Exception e) {
                System.out.println("Transaction failed - " + e.getMessage());
                currentState = stateFactory.createSelectOperationState();
            }
        } else {
            System.out.println("Cannot perform operation in - " + currentState.getStateName());
        }
    }

    public void cancelTransaction() {
        if(currentState instanceof TransactionState) {
            System.out.println("Transaction cancelled.");
            resetATM();
        } else {
            System.out.println("Cannot cancel transaction in - " + currentState.getStateName());
        }
    }

    public void returnCard() {
        if(currentState instanceof HasCardState || currentState instanceof SelectOperationState || currentState instanceof TransactionState) {
            System.out.println("Card returned.");
            resetATM();
        } else {
            System.out.println("Cannot return card in - " + currentState.getStateName());
        }
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public TransactionType getSelectedOperation() {
        return selectedOperation;
    }

    public ATMStateFactory getStateFactory() {
        return stateFactory;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
