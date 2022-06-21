package entities;

import controllers.ProductController;

/**
 * It's used to represent a Product.
 * A new Product or some one from database.
 * @author Saakve
 */
public class Product {
    
    private int productId;
    private String name;
    private double price;
    private String alias;
    private int inventoryId;
    private int categoryId;
    
    /**
     * Create a product that represents a product of the database.
     * @param productId
     * @param name
     * @param price
     * @param alias
     * @param inventoryId A identifier of category table
     * @param categoryId A identifier of inventory table
     */
    public Product(int productId, String name, double price, String alias, int inventoryId, int categoryId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.alias = alias;
        this.inventoryId = inventoryId;
        this.categoryId = categoryId;
    }
    
    /**
     * Create a new product that will be added to the database.
     * @param name
     * @param price
     * @param alias
     * @param categoryId A identifier of category table
     */
    public Product(String name, double price, String alias, int categoryId) {
        this.productId = ProductController.NEW_PRODUCT;
        this.name = name;
        this.price = price;
        this.alias = alias;
        this.categoryId = categoryId;
    }
    
    /**
     * Create a product that represents a product not found.
     */
    public Product(){
        productId = ProductController.NOT_FOUND;
        name = "";
        price = 0.0;
        alias = "";
        categoryId = -1;
        inventoryId = -1;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String newAlias) {
        this.alias = newAlias;
    }
    
    /**
     * @return A identifier of inventory table
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId A identifier of category table
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    /**
     * @return A identifier of inventory table
     */
    public int getInventoryId(){
        return inventoryId;
    }
    
    /**
     * @param inventoryId A identifier of category table
     */
    public void setInventoryId(int inventoryId){
        this.inventoryId = inventoryId;
    }
}