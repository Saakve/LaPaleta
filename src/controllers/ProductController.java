package controllers;

import conexionDB.ConnectionToLapaletadb;
import entities.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * It controls all CRUD actions and comunicate with producto table.
 * in lapaletadb
 * @author Saakve
 */
public class ProductController {
    
    public static final String[] ATTRIBUTES = {
        "producto_id", 
        "ptNombre", 
        "ptPrecio", 
        "ptAlias", 
        "inventario_id", 
        "categoria_id"
    };
    
    public static final int NEW_PRODUCT = -1;
    public static final int NOT_FOUND = -2;
    public static final int ERROR_COUNT = -3;
    public static final int INVALID_INDEX = -4;
    
    /**
     * Return a string with the attributes of product table.
     * 
     * For example: 
     * SpreadAttributes(1);
     * //-> "ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id"
     * 
     * @param lowerLimit A int that indicate where to start
     */
    private static String spreadAttributes(int lowerLimit){
        ArrayList<String> Attributes = new ArrayList<>();
        
        for (int i = lowerLimit; i < ATTRIBUTES.length; i++) {
            Attributes.add(ATTRIBUTES[i]);
        }
        
        return String.join(", ", Attributes);
    }

    /**
     * Return a product whose identifier is equal to index.
     */
    public static Product get(int index) {
        String  statement = "SELECT * FROM producto WHERE {pkey} = {index}";
        statement = statement.replace("{pkey}", ATTRIBUTES[0]);
        statement = statement.replace("{index}", Integer.toString(index));

        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet productObject = cn.executeQuery(statement);

            if (productObject.next()) {
                return new Product(
                        productObject.getInt(ATTRIBUTES[0]),
                        productObject.getString(ATTRIBUTES[1]),
                        productObject.getDouble(ATTRIBUTES[2]),
                        productObject.getString(ATTRIBUTES[3]),
                        productObject.getInt(ATTRIBUTES[4]),
                        productObject.getInt(ATTRIBUTES[5])
                );
            }

        } catch (SQLException e) {
            System.out.println("Product.java says -> Error: " + e);
        } finally {
            cn.close();
        }

        return new Product();
    }

    /**
     * Search for a product that have same name and return its index. 
     *
     * @param name A string that represents the name of the product that will be
     * searched.
     * @return A int that represents the index of the product.
     *         -1 is for not found.
     */
    public static int find(String name) {
        String statement = "SELECT {pkey} FROM producto WHERE ptNombre = '{name}'";
        statement = statement.replace("{pkey}", ATTRIBUTES[0]);
        statement = statement.replace("{name}", name);

        int index = 0;

        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet indexObject = cn.executeQuery(statement);

            if (!indexObject.next()) {
                return NOT_FOUND;
            }

            index = indexObject.getInt(ATTRIBUTES[0]);

        } catch (SQLException e) {
            System.out.println("Product.java says -> Eror: " + e);
        } finally {
            cn.close();
        }

        return index;
    }
    
    /***
     * Find products where its category has the same index.
     * 
     * @param index
     * @return A ArrayList of products found.
     *         Size 0 indicates no coincidence.
     */
    public static ArrayList<Product> findByCategory(int index){
         ArrayList<Product> products = new ArrayList<>();
        
        String statement = "SELECT * FROM producto WHERE {inventoryId} = {index}";
        statement = statement.replace("{inventoryId}", ATTRIBUTES[5]);
        statement = statement.replace("{index}", Integer.toHexString(index));
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet coincidences = cn.executeQuery(statement);
            
            while(coincidences.next()) {
                products.add(new Product(
                        coincidences.getInt(ATTRIBUTES[0]), 
                        coincidences.getString(ATTRIBUTES[1]), 
                        coincidences.getDouble(ATTRIBUTES[2]), 
                        coincidences.getString(ATTRIBUTES[3]), 
                        coincidences.getInt(ATTRIBUTES[4]),
                        coincidences.getInt(ATTRIBUTES[5])));
            }
            
        } catch(SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
            System.out.println("Statement: " + statement);
        } finally {
            cn.close();
        }
        
        return products;
    }
    
    /**
     * Search a product where its name, alias or index contains the specified
     * pattern.
     * 
     * @param pattern A String that will be use to search.
     * @return A ArrayList with products found.
     *         Size 0 indicates no coincidence.
     */
    public static ArrayList<Product> search(String pattern){
        ArrayList<Product> products = new ArrayList<>();
        
        String statement = """
                           SELECT * FROM producto 
                           WHERE {1} LIKE "%{pattern}%" OR 
                                 {3} LIKE "%{pattern}%" OR 
                                 {0} LIKE "%{pattern}%";
                           """;
        statement = statement.replace("{1}", ATTRIBUTES[1]);
        statement = statement.replace("{3}", ATTRIBUTES[3]);
        statement = statement.replace("{0}", ATTRIBUTES[0]);
        statement = statement.replace("{pattern}", pattern);
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet coincidences = cn.executeQuery(statement);
            
            while(coincidences.next()) {
                products.add(new Product(
                        coincidences.getInt(ATTRIBUTES[0]), 
                        coincidences.getString(ATTRIBUTES[1]), 
                        coincidences.getDouble(ATTRIBUTES[2]), 
                        coincidences.getString(ATTRIBUTES[3]), 
                        coincidences.getInt(ATTRIBUTES[4]),
                        coincidences.getInt(ATTRIBUTES[5])));
            }
            
        } catch(SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
            System.out.println("Statement: " + statement);
        } finally {
            cn.close();
        }
        
        return products;
    }

    public static int getNumberOfProducts() {
        String statement = "SELECT COUNT(*) FROM producto";

        int numberOfProducts = 0;

        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet totalObject = cn.executeQuery(statement);

            if (!totalObject.next()) {
                return ERROR_COUNT;
            }

            numberOfProducts = totalObject.getInt(1);

        } catch (SQLException e) {
            System.out.println("Product.java says -> Error: " + e);
        } finally {
            cn.close();
        }

        return numberOfProducts;
    }

    /**
     * Return a ArrayList with products.
     * @param lowerLimit A integer that represents a index to start
     * @param upperLimit A integer that represents a index to end
     */
    public static ArrayList<Product> getProducts(int lowerLimit, int upperLimit) {
        int offset = lowerLimit - 1;
        int rowcount = upperLimit - offset;
        
        ArrayList<Product> products = new ArrayList<>(rowcount);

        String statement = "SELECT * FROM producto LIMIT {offset}, {rowcount}";
        statement = statement.replace("{offset}", Integer.toString(offset));
        statement = statement.replace("{rowcount}", Integer.toString(rowcount));
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet productObjects = cn.executeQuery(statement);

            if (productObjects.next()) {
                do {
                    products.add(new Product(
                            productObjects.getInt(ATTRIBUTES[0]),
                            productObjects.getString(ATTRIBUTES[1]),
                            productObjects.getDouble(ATTRIBUTES[2]),
                            productObjects.getString(ATTRIBUTES[3]),
                            productObjects.getInt(ATTRIBUTES[4]),
                            productObjects.getInt(ATTRIBUTES[5])
                    ));
                } while (productObjects.next());
            }

        } catch (SQLException e) {
            System.out.println("Product.java says -> Error: " + e);
        } finally {
            cn.close();
        }

        return products;
    }

    /**
     * Delete a product from database.
     *
     * @param index A int value that represents the index of the product
     * @return A boolean value that represents if the product was deleted or not
     */
    public static boolean delete(int index) {
        String statement = "DELETE FROM producto WHERE {pkey} = {index}";
        statement = statement.replace("{pkey}", ATTRIBUTES[0]);
        statement = statement.replace("{index}", Integer.toString(index));
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            if (cn.executeUpdate(statement) != 1 || !StockController.delete(index)) {
                return ConnectionToLapaletadb.UPDATE_FAILED;
            }

        } catch (SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
        } finally {
            cn.close();
        }

        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }

    /**
     * Add a new product to lapaletadb database
     *
     * @param newProduct A Product that will be added.
     * @return A boolean value that represents if the product was added or not.
     */
    public static boolean add(Product newProduct) {
        StockController.add(0);
        int inventory_id = StockController.getLastIndex();
        
        String statement = """
                           INSERT INTO producto ({ATTRIBUTES})
                           VALUES ('{name}', {price}, '{alias}', {inventory_id}, {category_id})
                           """;
        
        statement = statement.replace("{ATTRIBUTES}", spreadAttributes(1));
        statement = statement.replace("{name}", newProduct.getName());
        statement = statement.replace("{price}", Double.toString(newProduct.getPrice()));
        statement = statement.replace("{alias}", newProduct.getAlias());
        statement = statement.replace("{inventory_id}", Integer.toString(inventory_id));
        statement = statement.replace("{category_id}",Integer.toString(newProduct.getCategoryId()));

        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            int resultado = cn.executeUpdate(statement);
            
            if(resultado != 1){
                return ConnectionToLapaletadb.UPDATE_FAILED;
            }
            
        } catch (SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
            System.out.println("Statement: " + statement);
            return ConnectionToLapaletadb.UPDATE_FAILED;
        } finally {
            cn.close();
        }
        
        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }
    
    /**
     * Update a product from database.
     * 
     * @param index A int value that represents the index of the product
     * @param newProduct A product that will replace the old one.
     * @return A boolean value that represents if the product was updated or not.
     */
    public static boolean update(int index, Product newProduct){
        String statement = """
                           UPDATE producto
                           SET {1} = "{name}",
                               {2} = {price},
                               {3} = "{alias}",
                               {4} = {inventory_id}, 
                               {5} = {category_id}
                           WHERE {0} = {pkey};
                           """;
        statement = statement.replace("{0}",ATTRIBUTES[0]).replace("{pkey}", Integer.toString(index));
        statement = statement.replace("{1}", ATTRIBUTES[1]).replace("{name}", newProduct.getName());
        statement = statement.replace("{2}", ATTRIBUTES[2]).replace("{price}", Double.toString(newProduct.getPrice()));
        statement = statement.replace("{3}", ATTRIBUTES[3]).replace("{alias}",newProduct.getAlias());
        statement = statement.replace("{4}", ATTRIBUTES[4]).replace("{inventory_id}", Integer.toString(newProduct.getInventoryId()));
        statement = statement.replace("{5}", ATTRIBUTES[5]).replace("{category_id}", Integer.toString(newProduct.getCategoryId()));
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            if(cn.executeUpdate(statement) != 1){
                return ConnectionToLapaletadb.UPDATE_FAILED;
            }
            
        } catch (SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
            System.out.println("Statement: " + statement);
            return ConnectionToLapaletadb.UPDATE_FAILED;
        } finally {
            cn.close();
        }
        
        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }
    
    /**
     * Return the last product added;
     */
    public static Product getLastProduct(){
        String statement = "SELECT * FROM producto WHERE {pkey} = {index}";
        statement = statement.replace("{pkey}", ATTRIBUTES[0]);
        statement = statement.replace("{index}", Integer.toString(getLastIndex()));
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet lastProduct = cn.executeQuery(statement);
            
            if (lastProduct.next()) {
                return new Product(
                        lastProduct.getInt(ATTRIBUTES[0]),
                        lastProduct.getString(ATTRIBUTES[1]),
                        lastProduct.getDouble(ATTRIBUTES[2]),
                        lastProduct.getString(ATTRIBUTES[3]),
                        lastProduct.getInt(ATTRIBUTES[4]),
                        lastProduct.getInt(ATTRIBUTES[5])
                );
            }
            
        } catch (SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
        } finally {
            cn.close();
        }
        
        return new Product();
    }
    
    /**
     * Return a int that represens the index of the last product added.
     */
    public static int getLastIndex() {
        String statement = "SELECT MAX({pkey}) FROM producto";
        statement = statement.replace("{pkey}", ATTRIBUTES[0]);
        int index = 0;
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet lastIndexObject = cn.executeQuery(statement);
            
            if (!lastIndexObject.next()) {
                return INVALID_INDEX;
            }
            
            index = lastIndexObject.getInt(1);

        } catch (SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
            return INVALID_INDEX;
        } finally {
            cn.close();
        }
        
        return index;
    }
}
