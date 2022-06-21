
import controllers.ProductController;
import controllers.StockController;
import entities.Product;
import java.util.ArrayList;

public class Pruebas {
    public static void main(String[] args) { 
        
        //System.out.println(StockController.updateStock(1, 100000));
        //System.out.println(ProductController.delete(1));
        //System.out.println(ProductController.add(p1));
        //System.out.println(ProductController.spreadAttributes(1));
        //System.out.println(ProductController.get(2).getName());
        System.out.println(ProductController.search("nieve de fresa").get(0).getName());
    }
}