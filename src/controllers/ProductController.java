package controllers;

import conexionDB.ConnectionToLapaletadb;
import entities.Product;
import entities.Stock;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * It controls all CRUD actions and comunicate with product table.
 * in lapaletadb
 * @author Saakve
 */
public class ProductController {
    public static final String[] ATTRIBUTES = {"producto_id", "ptNombre", "ptPrecio", "ptAlias", "invpCantidad", "ctgNombre"};
    public static final int NEW_PRODUCT = -1;
    public static final int NOT_FOUND = -2;
    public static final int ERROR_COUNT = -3;

    public static Product getProduct(int index) {
        String statement
                = """
                SELECT {columns}
                FROM producto 
                INNER JOIN inventarioproducto USING (inventario_id)
                INNER JOIN categoria USING (categoria_id)
                WHERE {pkey} = {index}
                """
                        .replace("{columns}", String.join(", ", ATTRIBUTES))
                        .replace("{pkey}", ATTRIBUTES[0])
                        .replace("{index}", Integer.toString(index));

        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
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
        }

        return new Product();
    }

    /**
     * Search for a product that have same name and return its index. -1 is for
     * not found.
     *
     * @param name A string that represents the name of the product that will be
     * searched
     * @return A int that represents the index of the product.
     */
    public static int findProduct(String name) {
        String statement = "SELECT {pkey} FROM producto WHERE ptNombre = '{name}'"
                .replace("{pkey}", ATTRIBUTES[0])
                .replace("{name}", name);

        int index = 0;

        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet indexObject = cn.executeQuery(statement);

            if (!indexObject.next()) {
                return NOT_FOUND;
            }

            index = indexObject.getInt(ATTRIBUTES[0]);

        } catch (SQLException e) {
            System.out.println("Product.java says -> Eror: " + e);
        }

        return index;
    }

    public static int getNumberOfProducts() {
        String statement = "SELECT COUNT(*) FROM producto";

        int numberOfProducts = 0;

        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet totalObject = cn.executeQuery(statement);

            if (!totalObject.next()) {
                return ERROR_COUNT;
            }

            numberOfProducts = totalObject.getInt(1);

        } catch (SQLException e) {
            System.out.println("Product.java says -> Error: " + e);
        }

        return numberOfProducts;
    }

    public static Product[] getProducts(int lowerLimit, int upperLimit) {
        int offset = lowerLimit - 1;
        int rowcount = upperLimit - offset;
        Product[] products = new Product[rowcount];

        String statement
                = """
                SELECT {columns}
                FROM producto 
                INNER JOIN inventarioproducto USING (inventario_id)
                INNER JOIN categoria USING (categoria_id)
                LIMIT {offset}, {rowcount}
                """
                        .replace("{columns}", String.join(", ", ATTRIBUTES))
                        .replace("{offset}", Integer.toString(offset))
                        .replace("{rowcount}", Integer.toString(rowcount));
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet productObjects = cn.executeQuery(statement);

            if (productObjects.next()) {
                int i = 0;
                do {
                    products[i] = new Product(
                            productObjects.getInt(ATTRIBUTES[0]),
                            productObjects.getString(ATTRIBUTES[1]),
                            productObjects.getDouble(ATTRIBUTES[2]),
                            productObjects.getString(ATTRIBUTES[3]),
                            productObjects.getInt(ATTRIBUTES[4]),
                            productObjects.getInt(ATTRIBUTES[5])
                    );
                    i++;
                } while (productObjects.next());
            }

        } catch (SQLException e) {
            System.out.println("Product.java says -> Error: " + e);
        }

        return products;
    }

    /**
     * Delete a product from the database.
     *
     * @param index A int value that represents the index of the product
     * @return A boolean value that represents if the product was delete or not
     */
    public static boolean deleteProduct(int index) {
        String statement = "DELETE FROM producto WHERE {pkey} = {index}"
                .replace("{pkey}", ATTRIBUTES[0])
                .replace("{index}", Integer.toString(index));
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();

            if (cn.executeUpdate(statement) != 1 || !StockController.deleteStock(index)) {
                return ConnectionToLapaletadb.UPDATE_FAILED;
            }

        } catch (SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
        }

        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }

    public static boolean addProduct(Product newProduct) {
        int inventory_id = Stock.addStock(newProduct.getAmount());
        String statement = """
                           INSERT INTO producto 
                           (ptNombre, ptPrecio, ptAlias, inventario_id, categoria_id) 
                           VALUES ('{name}', {price}, '{alias}', {inventory_id}, {category_id})
                           """
                .replace("{name}", newProduct.getName())
                .replace("{price}", Double.toString(newProduct.getPrice()))
                .replace("{alias}", newProduct.getAlias())
                .replace("{inventory_id}", Integer.toString(inventory_id))
                .replace("{category_id}",Integer.toString(newProduct.getCategory()));

        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            int resultado = cn.executeUpdate(statement);
            
            if(resultado != 1){
                return ConnectionToLapaletadb.UPDATE_FAILED;
            }
            
        } catch (SQLException e) {
            System.out.println("ProductController.java says -> Error: " + e);
            System.out.println("Statement: " + statement);
        }
        
        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }
    
    public static boolean updateProduct(int index, Product newProduct){
        String statement = "";
        
        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }

}
