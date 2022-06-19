package vistas;

import conexionDB.ConnectionToLapaletadb;
import javax.swing.table.AbstractTableModel;
import java.sql.*;

/**
 *
 * @author Saakve
 */
public class ProductTableModel extends AbstractTableModel {
    private int numberOfRows = 15;
    private String[] columnNames = {"Clave", "Nombre", "Precio", "Alias","Cantidad", "Categoria"};
    
    private Object[][] rows = new Object [numberOfRows][columnNames.length];
    
    public ProductTableModel() {
        try {
            String attributes[] = {"producto_id", "ptNombre", "ptPrecio", "ptAlias", "invpCantidad", "ctgNombre"};
            String statement = """
                               SELECT {columns}
                               FROM producto 
                               INNER JOIN inventarioproducto USING (inventario_id)
                               INNER JOIN categoria USING (categoria_id)
                               LIMIT {numberOfRows}
                               """.replace("{columns}", String.join(", ", attributes))
                                  .replace("{numberOfRows}",String.valueOf(numberOfRows));
            
            ConnectionToLapaletadb cn = new ConnectionToLapaletadb();
            ResultSet products = cn.executeQuery(statement);
            
            byte product = 0;
            while(products.next()){
                for (int attribute = 0; attribute < attributes.length; attribute++) {
                    rows[product][attribute] = products.getString(attributes[attribute]);
                }
                product++;
            }
            
        } catch (SQLException e){
            for (int i = 0; i < rows.length; i++) {
                for (int j = 0; j < rows[0].length; j++) {
                    rows[i][j] = "Error";
                }
            }
            System.out.println(e);
        }
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

}
