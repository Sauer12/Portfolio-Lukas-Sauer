package sk.lukassauer.inventorymanager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {
    List<Product> soldProductsList = new CopyOnWriteArrayList<>();
    List<Product> purchasedProductList = new ArrayList<>();

    public void populateSoldPorudcts(){
        for(int i = 0; i < 1000; i++){
            Product product = new Product(i, "test_products_" + i);
            soldProductsList.add(product);
            System.out.println("ADDED: " + product);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts(){
        for(Product product : soldProductsList){
            System.out.println("PRINTING THE SOLD: " + product);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
