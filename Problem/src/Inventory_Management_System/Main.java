package Inventory_Management_System;

import Inventory_Management_System.Enum.ProductCategory;
import Inventory_Management_System.Inventory_Stock_Manager.InventoryManager;
import Inventory_Management_System.Product_Factory.Product;
import Inventory_Management_System.Product_Factory.ProductFactory;
import Inventory_Management_System.Product_Replenishment_Strategy.Concrete_Replenishment_Strategy.BulkOrderStrategy;
import Inventory_Management_System.Product_Replenishment_Strategy.Concrete_Replenishment_Strategy.JustInTimeStrategy;
import Inventory_Management_System.Product_Replenishment_Strategy.ReplenishmentStrategy;
import Inventory_Management_System.Utility.WareHouse;

public class Main {
    public static void main(String[] args) {
        ReplenishmentStrategy replenishmentStrategy = new JustInTimeStrategy();
        InventoryManager inventoryManager = InventoryManager.getInstance(replenishmentStrategy);

        WareHouse wareHouse1 = new WareHouse("WareHouse 1");
        WareHouse wareHouse2 = new WareHouse("WareHouse 2");
        inventoryManager.addWareHouse(wareHouse1);
        inventoryManager.addWareHouse(wareHouse2);

        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct(ProductCategory.ELECTRONICS, "SKU123", "Laptop", 1000.0, 50, 25);
        Product tShirt = productFactory.createProduct(ProductCategory.CLOTHING, "SKU456", "T-Shirt", 20.0, 200, 100);
        Product apple = productFactory.createProduct(ProductCategory.GROCERY, "SKU789", "Apple", 1.0, 100, 200);

        wareHouse1.addProduct(laptop, 15);
        wareHouse1.addProduct(tShirt, 20);
        wareHouse2.addProduct(apple, 50);


        inventoryManager.performInventoryCheck();

        inventoryManager.setReplenishmentStrategy(new BulkOrderStrategy());

        inventoryManager.checkAndReplenish("SKU123");
    }
}
