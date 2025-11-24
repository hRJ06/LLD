package Inventory_Management_System.Product_Factory.Concrete_Product;

import Inventory_Management_System.Enum.ProductCategory;
import Inventory_Management_System.Product_Factory.Product;

public class ClothingProduct extends Product {
    private String size;
    private String color;

    public ClothingProduct(String SKU, String name, double price, int quantity, int threshold) {
        super();
        setSKU(SKU);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setCategory(ProductCategory.CLOTHING);
        setThreshold(threshold);
    }

    /* GETTER */
    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    /* SETTER */
    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
