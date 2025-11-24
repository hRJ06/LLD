package Inventory_Management_System.Product_Factory.Concrete_Product;

import Inventory_Management_System.Enum.ProductCategory;
import Inventory_Management_System.Product_Factory.Product;

import java.util.Date;

public class GroceryProduct extends Product {
    private Date expiryDate;
    private boolean isRefrigerated;

    public GroceryProduct(String SKU, String name, double price, int quantity, int threshold) {
        super();
        setSKU(SKU);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setCategory(ProductCategory.GROCERY);
        setThreshold(threshold);
    }

    /* GETTER */
    public Date getExpiryDate() {
        return expiryDate;
    }

    public boolean isRefrigerated() {
        return isRefrigerated;
    }

    /* SETTER */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setRefrigerated(boolean refrigerated) {
        isRefrigerated = refrigerated;
    }
}
