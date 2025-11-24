package Inventory_Management_System.Product_Factory;

import Inventory_Management_System.Enum.ProductCategory;

public abstract class Product {
    private String SKU;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory category;

    /* GETTER */
    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public ProductCategory getCategory() {
        return category;
    }

    /* SETTER */
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
