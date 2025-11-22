package Vending_Machine.Utility;

import java.util.Objects;

public class Inventory {
    private ItemShelf[] inventory;

    public Inventory(int itemCount) {
        this.inventory = new ItemShelf[itemCount];
        initializeInventory();
    }

    private void initializeInventory() {
        int startCode = 101;
        for(int i = 0; i<inventory.length; i++) {
            ItemShelf space = new ItemShelf(startCode);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(Objects.equals(itemShelf.getCode(), codeNumber)) {
                itemShelf.addItem(item);
                return;
            }
        }
        throw new Exception("Invalid code.");
    }

    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(Objects.equals(itemShelf.getCode(), codeNumber)) {
                if(itemShelf.isSoldOut()) {
                    throw new Exception("Item sold out.");
                } else {
                    return itemShelf.getItems().get(0);
                }
            }
        }
        throw new Exception("Invalid code.");
    }

    public void removeItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(Objects.equals(itemShelf.getCode(), codeNumber)) {
                itemShelf.removeItem(getItem(codeNumber));
            }
        }
        throw new Exception("Invalid code.");
    }

    public void updateSoldOutItem(int codeNumber) {
        for(ItemShelf itemShelf : inventory) {
            if(Objects.equals(itemShelf.getCode(), codeNumber)) {
                if(itemShelf.getItems().isEmpty()) {
                    itemShelf.setSoldOut(true);
                }
            }
        }
    }

    public boolean hasItem() {
        for(ItemShelf shelf : inventory) {
            if(!shelf.isSoldOut()) return true;
        }
        return false;
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }
}
