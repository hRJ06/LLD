package Vending_Machine.State_Design_Pattern;

import Vending_Machine.Enum.Coin;
import Vending_Machine.State_Design_Pattern.Concrete_State.DispenseState;
import Vending_Machine.State_Design_Pattern.Concrete_State.HasMoneyState;
import Vending_Machine.State_Design_Pattern.Concrete_State.IdleState;
import Vending_Machine.State_Design_Pattern.Concrete_State.SelectionState;
import Vending_Machine.Utility.Inventory;
import Vending_Machine.Utility.Item;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineContext {
    private Inventory inventory;
    private VendingMachineState currentState;
    private List<Coin> coinList;
    private int selectedItemCode;

    public VendingMachineContext() {
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
        currentState = new IdleState();
        System.out.println("Initialized - " + currentState.getName());
    }

    private void advanceState() {
        VendingMachineState nextState = currentState.next(this);
        currentState = nextState;
        System.out.println("Current state - " + nextState.getName());
    }

    private int getBalance() {
        int balance = 0;
        for(Coin coin : coinList) {
            balance += coin.value;
        }
        return balance;
    }

    private void resetBalance() {
        coinList.clear();
    }

    private void resetSelection() {
        selectedItemCode = 0;
    }

    private void dispenseItem(int codeNumber) {
        if(currentState instanceof DispenseState) {
            try {
                Item item = inventory.getItem(codeNumber);
                System.out.println("Dispensing - " + item.getType());
                inventory.removeItem(codeNumber);
                inventory.updateSoldOutItem(codeNumber);
                resetBalance();
                resetSelection();
                advanceState();
            } catch (Exception e) {
                System.out.println("Error - " + e.getMessage());
            }
        } else {
            System.out.println("System cannot dispense in " + currentState.getName());
        }
    }

    private void selectProduct(int codeNumber) {
        if(currentState instanceof SelectionState) {
            try {
                Item item = inventory.getItem(codeNumber);
                int balance = getBalance();
                if (balance < item.getPrice()) {
                    System.out.println("Insufficient amount. Product price - " + item.getPrice() + ", paid - " + balance);
                    return;
                }
                setSelectedItemCode(codeNumber);
                advanceState();
                dispenseItem(codeNumber);
                if(balance >= item.getPrice()) {
                    int change = balance - item.getPrice();
                    System.out.println("Returning change - " + change);
                }

            } catch (Exception e) {
                System.out.println("Error - " + e.getMessage());
            }
        } else {
            System.out.println("Cannot select product in " + currentState.getName());
        }
    }

    public void clickOnInsertCoinButton(Coin coin) {
        if(currentState instanceof IdleState || currentState instanceof HasMoneyState) {
            System.out.println("Inserted " + coin.name() + " worth " + coin.value);
            coinList.add(coin);
            advanceState();
        } else {
            System.out.println("Cannot insert coin in " + currentState.getName());
        }
    }

    public void clickOnStartProductSelectionButton(int codeNumber) {
        if(currentState instanceof HasMoneyState) {
            currentState = new SelectionState();
            selectProduct(codeNumber);
        } else {
            System.out.println("Cannot select product in " + currentState.getName());
        }
    }

    /* GETTER */
    public Inventory getInventory() {
        return inventory;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public int getSelectedItemCode() {
        return selectedItemCode;
    }

    /* SETTER */
    public void setSelectedItemCode(int itemCode) {
        selectedItemCode = itemCode;
    }

    public void updateInventory(Item item, int codeNumber) {
        if(currentState instanceof IdleState) {
            try {
                inventory.addItem(item, codeNumber);
                System.out.println("Added " + item.getType() + " to slot - " + codeNumber);
            } catch (Exception e) {
                System.out.println("Error - " + e.getMessage());
            }
        } else {
            System.out.println("Cannot update Inventory in - " + currentState.getName());
        }
    }
}
