package entities;

import controllers.StockController;

/**
 * It's used to represent a Stock.
 * A new Stock or some one from database.
 * @author Saakve
 */
public class Stock {
    
    private int stockId;
    private int amount;
   
    /**
     * Create a stock that represents a stock not found.
     */
    public Stock(){
        stockId = StockController.STOCK_NOT_FOUND;
        amount = -1;
    }

    /**
     * Create a product that represents a stock of the database.
     * @param stockId
     * @param amount 
     */
    public Stock(int stockId, int amount) {
        this.stockId = stockId;
        this.amount = amount;
    }
    
    public int getStockId() {
        return stockId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
