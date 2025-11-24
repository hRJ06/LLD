package Inventory_Management_System.Product_Replenishment_Strategy.Concrete_Replenishment_Strategy;

import Inventory_Management_System.Product_Factory.Product;
import Inventory_Management_System.Product_Replenishment_Strategy.ReplenishmentStrategy;

public class JustInTimeStrategy implements ReplenishmentStrategy {
    @Override
    public void replenish(Product product) {
        System.out.println("Applying Just-In-Time replenishment for " + product.getName());
    }
}
