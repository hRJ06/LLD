package Inventory_Management_System.Product_Factory.Concrete_Product;

import Inventory_Management_System.Enum.ProductCategory;
import Inventory_Management_System.Product_Factory.Product;

public class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;

    public ElectronicProduct(String SKU, String name, double price, int quantity, int threshold) {
        super();
        setSKU(SKU);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setCategory(ProductCategory.ELECTRONICS);
        setThreshold(threshold);
    }

    /* GETTER */
    public String getBrand() {
        return brand;
    }

    /* SETTER */
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
