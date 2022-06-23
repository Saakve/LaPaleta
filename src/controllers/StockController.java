package controllers;

import conexionDB.ConnectionToLapaletadb;
import entities.Stock;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * It controls all CRUD actions and comunicate with inventarioProducto table
 * in lapaletadb
 * @author Saakve
 */
public class StockController {

    public static final String[] ATTRIBUTES = {"inventario_id", "invpCantidad"};
    public static final int STOCK_NOT_FOUND = -1;
    public static final int ERROR_COUNT = -2;
    public static final int INVALID_INDEX = -3;

    /**
     * Return the index of the last stock added.
     */
    public static int getLastIndex() {
        String statement = "SELECT MAX({pkey}) FROM inventarioProducto";
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
            System.out.println("Stock.java says -> Error: " + e);
        } finally {
            cn.close();
        }
        
        return index;
    }

    /**
     * Add a new stock to lapaletadb database
     * @param amount
     * @return A boolean value that represents if the product was added or not.
     */
    public static boolean add(int amount) {
        String statement = """
                           INSERT INTO inventarioProducto
                           ({columns}) 
                           VALUES ({amount})
                           """;
        statement = statement.replace("{columns}", ATTRIBUTES[1]);
        statement = statement.replace("{amount}", Integer.toString(amount));

        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            if (cn.executeUpdate(statement) != 1) {
                return ConnectionToLapaletadb.UPDATE_FAILED;
            }

        } catch (SQLException e) {
            System.out.println("Stock.java says -> Error: " + e);
        } finally {
            cn.close();
        }

        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }

    /**
     * Return a stock whose identifier is equal to index.
     * @param index
     */
    public static Stock get(int index) {
        String statement = """
                           SELECT {columns} FROM inventarioProducto
                           WHERE {pkey} = {index}
                           """;
        statement = statement.replace("{columns}", String.join(", ", ATTRIBUTES));
        statement = statement.replace("{pkey}", ATTRIBUTES[0]); 
        statement = statement.replace("{index}", Integer.toString(index));

        Stock stock = new Stock();

        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet stockObject = cn.executeQuery(statement);

            if (!stockObject.next()) {
                return stock;
            }

            stock = new Stock(stockObject.getInt(ATTRIBUTES[0]), stockObject.getInt(ATTRIBUTES[1]));

        } catch (SQLException e) {
            System.out.println("Stock.java says -> Erro: " + e);
        } finally {
            cn.close();
        }

        return stock;
    }

    /**
     * Return a array with Stocks.
     * @param lowerLimit A integer that represents a index to start
     * @param upperLimit A integer that represents a index to end
     */
    public static Stock[] getStocks(int lowerLimit, int upperLimit) {
        int offset = lowerLimit - 1;
        int rowcount = upperLimit - offset;
        Stock[] stocks = new Stock[rowcount];

        String statement = """
                           SELECT {columns}
                           FROM inventarioProducto
                           LIMIT {offset}, {rowcount}
                           """;
        statement = statement.replace("{columns}", String.join(", ", ATTRIBUTES));
        statement = statement.replace("{offset}", Integer.toString(offset));
        statement = statement.replace("{rowcount}", Integer.toString(rowcount));
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet stockObjects = cn.executeQuery(statement);

            if (stockObjects.next()) {
                int i = 0;
                do {
                    stocks[i] = new Stock(stockObjects.getInt(ATTRIBUTES[0]), stockObjects.getInt(ATTRIBUTES[1]));
                    i++;
                } while (stockObjects.next());
            }

        } catch (SQLException e) {
            System.out.println("Stock.java says -> Error: " + e);
        } finally {
            cn.close();
        }

        return stocks;
    }

    public static int getNumberOfStocks() {
        String statement = "SELECT COUNT(*) FROM inventarioProducto";
        int numberOfStocks = 0;

        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            ResultSet numberOfStocksObject = cn.executeQuery(statement);

            if (!numberOfStocksObject.next()) {
                return ERROR_COUNT;
            }

            numberOfStocks = numberOfStocksObject.getInt(1);

        } catch (SQLException e) {
            System.out.println("Stock.java says -> Erro: " + e);
        } finally {
            cn.close();
        }

        return numberOfStocks;
    }
    
    /**
     * Delete a stock from database.
     *
     * @param index A int value that represents the index of the stock
     * @return A boolean value that represents if the stock was deleted or not
     */
    public static boolean delete(int index) {
        String statement = "DELETE from inventarioProducto WHERE {pkey} = {index}";
        statement = statement.replace("{pkey}", ATTRIBUTES[0]);
        statement = statement.replace("{index}", Integer.toString(index));
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {
            if(cn.executeUpdate(statement) != 1) {
                return ConnectionToLapaletadb.UPDATE_FAILED;
            }
            
        } catch(SQLException e) {
            System.out.println("StockController.java says -> Error: " + e);
        } finally {
            cn.close();
        }
        
        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }
    
    /**
     * Update a stock from database.
     * 
     * @param index A int value that represents the index of the stock
     * @param amount A amount that will replace the old one.
     * @return A boolean value that represents if the stock was updated or not.
     */
    public static boolean update(int index, int amount) {
        String statement = "UPDATE inventarioproducto SET {1} = {amount} WHERE {0} = {pkey}";
        statement = statement.replace("{0}", ATTRIBUTES[0]).replace("{pkey}", Integer.toString(index));
        statement = statement.replace("{1}", ATTRIBUTES[1]).replace("{amount}", Integer.toString(amount));
        
        ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
        try {   
            if(cn.executeUpdate(statement)!= 1 ){
                return ConnectionToLapaletadb.UPDATE_FAILED;
            }
            
        } catch (SQLException e) {
            System.out.println("Stock.java says -> Error: " + e);
            System.out.println("Statement: " + statement);
        } finally {
            cn.close();
        }
        
        return ConnectionToLapaletadb.UPDATE_SUCCESSFULL;
    }
}
