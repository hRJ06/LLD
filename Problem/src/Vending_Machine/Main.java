package Vending_Machine;

import Vending_Machine.Enum.Coin;
import Vending_Machine.Enum.ItemType;
import Vending_Machine.State_Design_Pattern.VendingMachineContext;
import Vending_Machine.Utility.Item;
import Vending_Machine.Utility.ItemShelf;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachineContext vendingMachine = new VendingMachineContext();
        try {
            System.out.println("|");
            System.out.println("Filling up the inventory.");
            System.out.println("|");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);
            System.out.println("|");
            System.out.println("Inserting coin.");
            System.out.println("|");
            vendingMachine.clickOnInsertCoinButton(Coin.TEN_RUPEES);
            vendingMachine.clickOnInsertCoinButton(Coin.FIVE_RUPEES);
            System.out.println("|");
            System.out.println("Selecting product.");
            System.out.println("|");
            vendingMachine.clickOnStartProductSelectionButton(102);
            displayInventory(vendingMachine);
        } catch (Exception e) {
            System.out.println("Error - " + e.getMessage());
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachineContext vendingMachine) {
        for(int i = 0; i < 10; i++) {
            Item newItem = new Item();
            int codeNumber = 101 + i;
            if(i >= 0 && i < 3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            } else if(i >= 3 && i < 5) {
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if(i >= 5 && i < 7) {
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            } else if(i >= 7 && i < 10) {
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            for(int j = 0; j < 5; j++) {
                vendingMachine.updateInventory(newItem, codeNumber);
            }
        }
    }

    private static void displayInventory(VendingMachineContext vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(ItemShelf slot : slots) {
            List<Item> items = slot.getItems();
            if(!items.isEmpty()) {
                System.out.println("Code Number - " + slot.getCode() + " Items - ");
                for(Item item : items) {
                    System.out.println("    - Item - " + item.getType().name() + ", Price - " + item.getPrice());
                }
                System.out.println("SoldOut: " + slot.isSoldOut());
            } else {
                System.out.println("Code Number - " + slot.getCode() + " Items - EMPTY" + " Sold out -  " + slot.isSoldOut());
            }
        }
    }
}
