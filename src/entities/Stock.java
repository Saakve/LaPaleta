package entities;

import conexionDB.ConnectionToLapaletadb;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Saakve
 */
public class Stock {
    public static final String[] ATTRIBUTES = {"inventario_id","invpCantidad"};
    public static final int STOCK_NOT_FOUND = -1;
    public static final int ERROR_COUNT = -2;
    public static final int INVALID_INDEX = -3;
    
    private int stock_id;
    private int amount;
    
    private static int getLastIndex(){
        String statement = "SELECT MAX({pkey}) FROM inventarioProducto"
                           .replace("{pkey}", ATTRIBUTES[0]);
        int index = 0;
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet lastIndexObject = cn.executeQuery(statement);
            if(!lastIndexObject.next()) return INVALID_INDEX;
            index = lastIndexObject.getInt(1);
            
        } catch (SQLException e) {
            System.out.println("Stock.java says -> Error: " + e);
        }
        return index;
    }
    
    public static int addStock(int amount){
        String statement = """
                           INSERT INTO inventarioProducto
                           ({columns}) 
                           VALUES ({amount})
                           """
                .replace("{columns}", ATTRIBUTES[1])
                .replace("{amount}", Integer.toString(amount));
        
        try {
            
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            if(cn.executeUpdate(statement) != 1) return INVALID_INDEX;
            
        } catch (SQLException e) {
            System.out.println("Stock.java says -> Error: " + e);
        }
        
        return getLastIndex();
    }
    
    public static Stock getStock(int index){
        String statement = """
                           SELECT {columns} FROM inventarioProducto
                           WHERE {pkey} = {index}
                           """
                           .replace("{columns}", String.join(", ", ATTRIBUTES))
                           .replace("{pkey}", ATTRIBUTES[0])
                           .replace("{index}", Integer.toString(index));
        
        Stock stock = new Stock();
        
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet stockObject = cn.executeQuery(statement);
            
            if(!stockObject.next()) return stock;
            
            stock = new Stock(stockObject.getInt(ATTRIBUTES[0]), stockObject.getInt(ATTRIBUTES[1]));
            
        } catch (SQLException e) {
            System.out.println("Stock.java says -> Erro: " + e);
        }
        
        return stock;
    }
    
    public static Stock[] getStocks(int lowerLimit, int upperLimit) {
        int offset = lowerLimit - 1;
        int rowcount = upperLimit - offset;
        Stock[] stocks = new Stock[rowcount];
        
        String statement = 
                """
                SELECT {columns}
                FROM inventarioProducto
                LIMIT {offset}, {rowcount}
                """
                .replace("{columns}", String.join(", ", ATTRIBUTES))
                .replace("{offset}", Integer.toString(offset))
                .replace("{rowcount}", Integer.toString(rowcount));
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet stockObjects = cn.executeQuery(statement);
            
            if(stockObjects.next()) {
                int i = 0;
                do {
                    stocks[i] = new Stock(stockObjects.getInt(ATTRIBUTES[0]), stockObjects.getInt(ATTRIBUTES[1]));
                    i++;
                } while(stockObjects.next());
            }
            
        } catch (SQLException e){
            System.out.println("Stock.java says -> Error: " + e);
        }
        
        return stocks;
    }
    
    public static int getNumberOfStocks(){
        String statement = "SELECT COUNT(*) FROM inventarioProducto";
        int numberOfStocks = 0;
        
        try {
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet numberOfStocksObject = cn.executeQuery(statement);
            
            if(!numberOfStocksObject.next()) return ERROR_COUNT;
            
            numberOfStocks = numberOfStocksObject.getInt(1);
            
        } catch (SQLException e) {
            System.out.println("Stock.java says -> Erro: " + e);
        }
        
        return numberOfStocks;
    }
    
    /**
     * Create a stock that represents a stock not found.
     */
    public Stock(){
        stock_id = STOCK_NOT_FOUND;
        amount = -1;
    }
    
    public Stock(int stock_id, int amount) {
        this.stock_id = stock_id;
        this.amount = amount;
    }
    
    public int getStock_id() {
        return stock_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
