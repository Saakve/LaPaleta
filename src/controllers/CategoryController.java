package controllers;

import conexionDB.ConnectionToLapaletadb;
import entities.Category;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * It controls all CRUD actions and comunicate with categoria table
 * in lapaletadb.
 * @author Saakve
 */
public class CategoryController {
    public static String[] ATTRIBUTES = {"categoria_id","ctgNombre"};
    public static int NOT_FOUND = -1;
    public static int ERROR_COUNT = -2;
    public static int INVALID_INDEX = -3;
    
    /**
     * Return the index of the last category added.
     */
    private static int getLastIndex(){
        String statement = "SELECT MAX({pkey}) FROM categoria"
                           .replace("{pkey}", ATTRIBUTES[0]);
        int index = 0;
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet lastIndexObject = cn.executeQuery(statement);
            if(!lastIndexObject.next()) return INVALID_INDEX;
            index = lastIndexObject.getInt(1);
            
        } catch (SQLException e) {
            System.out.println("Category.java says -> Error: " + e);
            return INVALID_INDEX;
        }
        
        return index;
    }
    
    /**
     * Add a new category to lapaletadb database
     *
     * @param newCategory A Categoy that will be added.
     * @return A boolean value that represents if the category was added or not. 
     */
    public static boolean addCategory(String newCategory){
        String statement = """
                           INSERT INTO categoria
                           ({columns}) 
                           VALUES ('{name}')
                           """
                .replace("{columns}", ATTRIBUTES[1])
                .replace("{name}", newCategory);
        
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            
            if(cn.executeUpdate(statement) != 1){
                return ConnectionToLapaletadb.UPDATE_FAILED;
            } 
            
        } catch (SQLException e) {
            System.out.println("Category.java says -> Error: " + e);
            return ConnectionToLapaletadb.UPDATE_FAILED;
        }
        
        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }
    
    /**
     * Return a product whose identifier is equal to index.
     */
    public static Category getCategory(int index){
        String statement = """
                           SELECT {columns}
                           FROM categorias WHERE {pkey} = {index}
                           """
                           .replace("{columns}", String.join(", ", ATTRIBUTES))
                           .replace("{pkey}", ATTRIBUTES[0])
                           .replace("{index}", Integer.toString(index));
        
        Category category  = new Category();
        
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet categoryObject = cn.executeQuery(statement);
            
            if(categoryObject.next()) {
                category = new Category(categoryObject.getInt(ATTRIBUTES[0]), categoryObject.getString(ATTRIBUTES[1]));
            }
            
        } catch (SQLException e) {
            System.out.println("Category.java says -> Error: " + e);
        }
        
        return category;
    }
    
    /***
     * Search for a category that have same name and return its index. 
     *
     * @param name A string that represents the name of the category that will be
     * searched.
     * @return A int that represents the index of the category.
     *         -1 is for not found.
     */
    public static int findCategory(String name){
        String statement = "SELECT {pkey} FROM categoria WHERE ctgNombre = '{name}'"
                .replace("{pkey}", ATTRIBUTES[0])
                .replace("{name}", name);
        
        int index = 0;
        
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet indexObject = cn.executeQuery(statement);
            if(!indexObject.next()) return NOT_FOUND;
            index = indexObject.getInt(ATTRIBUTES[0]);
            
        } catch(SQLException e) {
            System.out.println("Category.java says -> Eror: " + e);
        }
        
        return index;
    }
    
    /**
     * Return a array with Categories.
     * @param lowerLimit A integer that represents a index to start
     * @param upperLimit A integer that represents a index to end
     */
    public static Category[] getCategories(int lowerLimit, int upperLimit){
        int offset = lowerLimit - 1;
        int rowcount = upperLimit - offset;
        Category[] categories = new Category[rowcount];
        
        String statement = "SELECT {columns} FROM categoria LIMIT {offset}, {rowcount}"
                           .replace("{columns}", String.join(", ", ATTRIBUTES))
                           .replace("{offset}", Integer.toString(offset))
                           .replace("{rowcount}", Integer.toString(rowcount));
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet categoryObjects = cn.executeQuery(statement);
            
            if(categoryObjects.next()) {
                int i = 0;
                do {
                    categories[i] = new Category (
                        categoryObjects.getInt(ATTRIBUTES[0]),
                        categoryObjects.getString(ATTRIBUTES[1])
                    );
                    i++;
                } while(categoryObjects.next());
            }
            
        } catch (SQLException e){
            System.out.println("Category.java says -> Error: " + e);
        }
        
        return categories;
    }
    
    public static int getNumberOfCategories() {
        String statement = "SELECT COUNT(*) FROM categoria";
        int numberOfCategories = 0;
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet numbersOfCategoriesObject = cn.executeQuery(statement);
            
            if(!numbersOfCategoriesObject.next()) numberOfCategories = ERROR_COUNT;
            
            numberOfCategories = numbersOfCategoriesObject.getInt(1);
            
        } catch (SQLException e) {
            numberOfCategories = ERROR_COUNT;
            System.out.println("Category.java says -> Error: " + e);
        }
        
        return numberOfCategories;
    }

}
