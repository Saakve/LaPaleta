package views;

import controllers.CategoryController;
import controllers.StockController;
import entities.Product;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Create a TableModel used to show the products in JTable.
 * @author Saakve
 */
public class ProductTableModel extends AbstractTableModel{
    private final String[] columnNames = {"Clave", "Nombre", "Precio", "Alias", "Cantidad", "Categoria"};
    private final int numberOfRows;
    private final Object[][] rows;
    private final ArrayList<Product> products;
    
    public ProductTableModel(ArrayList<Product> products) {
        this.products = products;
        numberOfRows = products.size();
        rows = new Object [numberOfRows][columnNames.length];
        
        for (int product = 0; product < numberOfRows; product++) {
            rows[product][0] = products.get(product).getProductId();
            rows[product][1] = products.get(product).getName();
            rows[product][2] = products.get(product).getPrice();
            rows[product][3] = products.get(product).getAlias();
            rows[product][4] = StockController.get(products.get(product).getInventoryId()).getAmount();
            rows[product][5] = CategoryController.getCategory(products.get(product).getCategoryId()).getName();
        }
    }

    /**
     * Return the products used to make the table.
     */
    public ArrayList<Product> getProducts(){
        return products;
    }
    
    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int col) {
            return columnNames[col];
    }
    
    public void fireTableRowsDeleted(){
        super.fireTableRowsDeleted(numberOfRows, numberOfRows);
    }
}
