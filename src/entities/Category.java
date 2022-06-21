package entities;

import controllers.CategoryController;

/**
 * It's used to represent a Category.
 * A new Category or some one from database.
 * @author Saakve
 */
public class Category {
    int categoryId;
    String name;
    
    /**
     * Create a category that represents a category not found.
     */
    public Category(){
        this.categoryId = CategoryController.NOT_FOUND;
        this.name = "";
    }
    /**
     * Create a product that represents a product of the database.
     * @param categoryId
     * @param name 
     */
    public Category(int categoryId, String name){
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}