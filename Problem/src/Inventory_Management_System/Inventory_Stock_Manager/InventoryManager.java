package Inventory_Management_System.Inventory_Stock_Manager;

import Inventory_Management_System.Product_Factory.Product;
import Inventory_Management_System.Product_Factory.ProductFactory;
import Inventory_Management_System.Product_Replenishment_Strategy.ReplenishmentStrategy;
import Inventory_Management_System.Utility.WareHouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventoryManager {
    private static InventoryManager instance;
    private List<WareHouse> wareHouseList;
    private ProductFactory productFactory;
    private ReplenishmentStrategy replenishmentStrategy;

    private InventoryManager(ReplenishmentStrategy replenishmentStrategy) {
        wareHouseList = new ArrayList<>();
        productFactory = new ProductFactory();
        this.replenishmentStrategy = replenishmentStrategy;
    }

    public static InventoryManager getInstance(ReplenishmentStrategy replenishmentStrategy) {
        if(Objects.isNull(instance)) {
            instance = new InventoryManager(replenishmentStrategy);
        }
        return instance;
    }

    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
    }

    public void addWareHouse(WareHouse wareHouse) {
        wareHouseList.add(wareHouse);
    }

    public void removeWareHouse(WareHouse wareHouse) {
        wareHouseList.remove(wareHouse);
    }

    public Product getProductBySKU(String SKU) {
        for(WareHouse wareHouse : wareHouseList) {
            Product product = wareHouse.getProductBySKU(SKU);
            if(Objects.nonNull(product)) {
                return product;
            }
        }
        return null;
    }

    public void checkAndReplenish(String SKU) {
        Product product = getProductBySKU(SKU);
        if(Objects.nonNull(product)) {
            if(product.getQuantity() < product.getThreshold()) {
                if(Objects.nonNull(replenishmentStrategy)) {
                    replenishmentStrategy.replenish(product);
                }
            }
        }
    }

    public void performInventoryCheck() {
        for(WareHouse wareHouse : wareHouseList) {
            for(Product product : wareHouse.getAllProducts()) {
                if(product.getQuantity() < product.getThreshold()) {
                    if(Objects.nonNull(replenishmentStrategy)) {
                        replenishmentStrategy.replenish(product);
                    }
                }
            }
        }
    }

}
