package Inventory_Management_System.Utility;

import Inventory_Management_System.Product_Factory.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WareHouse {
    private int id;
    private String name;
    private String location;
    private Map<String, Product> products;

    public WareHouse(String name) {
        this.name = name;
        this.products = new HashMap<>();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addProduct(Product product, int quantity) {
        String SKU = product.getSKU();
        if (products.containsKey(SKU)) {
            Product existingProduct = products.get(SKU);
            existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
        } else {
            product.setQuantity(quantity);
        }
        products.put(SKU, product);
        System.out.println(quantity + " units of " + product.getName()
                + " (SKU - " + SKU + ") added to " + name
                + ". New quantity - " + getAvailableQuantity(SKU));
    }

    public boolean removeProduct(String SKU, int quantity) {
        if (products.containsKey(SKU)) {
            Product product = products.get(SKU);
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= quantity) {
                product.setQuantity(currentQuantity - quantity);
                System.out.println(quantity + " units of " + product.getName()
                        + " (SKU: " + SKU + ") removed from " + name
                        + ". Remaining quantity - " + product.getQuantity());
                if (Objects.equals(0, product.getQuantity())) {
                    products.remove(SKU);
                    System.out.println("Product " + product.getName()
                            + " removed from inventory as quantity is now zero.");
                }
                return true;
            } else {
                System.out.println("Error - Insufficient inventory. Requested - " + quantity + ", Available - " + currentQuantity);
                return false;
            }
        } else {
            System.out.println("Error - Product with SKU - " + SKU + " not found in " + name);
            return false;
        }
    }

    public int getAvailableQuantity(String SKU) {
        if (products.containsKey(SKU)) {
            return products.get(SKU).getQuantity();
        }
        return 0;
    }

    public Product getProductBySKU(String SKU) {
        return products.get(SKU);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
}
