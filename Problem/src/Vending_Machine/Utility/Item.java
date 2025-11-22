package Vending_Machine.Utility;

import Vending_Machine.Enum.ItemType;

public class Item {
    private ItemType type;
    private int price;

    public ItemType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
