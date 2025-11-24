package Inventory_Management_System.Product_Factory;

import Inventory_Management_System.Enum.ProductCategory;
import Inventory_Management_System.Product_Factory.Concrete_Product.ClothingProduct;
import Inventory_Management_System.Product_Factory.Concrete_Product.ElectronicProduct;
import Inventory_Management_System.Product_Factory.Concrete_Product.GroceryProduct;

public class ProductFactory {
    public Product createProduct(ProductCategory category, String sku, String name, double price, int quantity, int threshold) {
        switch (category) {
            case ELECTRONICS -> {
                return new ElectronicProduct(sku, name, price, quantity, threshold);
            }
            case CLOTHING -> {
                return new ClothingProduct(sku, name, price, quantity, threshold);
            }
            case GROCERY -> {
                return new GroceryProduct(sku, name, price, quantity, threshold);
            }
            default -> {
                throw new IllegalArgumentException("Unsupported Product Category - " + category);
            }
        }
    }
}
