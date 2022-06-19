package entities;
import controllers.ProductController;
/**
 *
 * @author Saakve
 */
public class Product {
    
    private int product_id;
    private String name;
    private double price;
    private String alias;
    private int amount;
    private int category;
    /**
     * Create a product that represents a product of the database.
     * @param product_id
     * @param name
     * @param price
     * @param alias
     * @param amount
     * @param category 
     */
    public Product(int product_id, String name, double price, String alias, int amount, int category) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.alias = alias;
        this.amount = amount;
        this.category = category;
    }
    
    /**
     * Create a new product that will be added to the database.
     * @param name
     * @param price
     * @param alias
     * @param category 
     */
    public Product(String name, double price, String alias, int category) {
        this.product_id = ProductController.NEW_PRODUCT;
        this.name = name;
        this.price = price;
        this.alias = alias;
        this.amount = 0;
        this.category = category;
    }
    
    /**
     * Create a product that represents a product not found.
     */
    public Product(){
        product_id = ProductController.NOT_FOUND;
        name = "";
        price = 0.0;
        alias = "";
        amount = 0;
        category = -1;
    }

    public int getProduct_id() {
        return product_id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int newCategory) {
        this.category = newCategory;
    }
}
