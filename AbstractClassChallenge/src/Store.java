import java.util.ArrayList;

public class Store {
    public static void main(String[] args) {
        ArrayList<ProductForSale> products = new ArrayList<>();
        products.add(new Vegetables("Tomato", 3.0, "This is a tomato!"));
        products.add(new Fruit("Blueberry", 5.50, "There are some blueberries!"));
        products.add(new MilkProduct("Joghurt", 1.25, "This is a joghurt!"));

        for(ProductForSale product : products){
            product.showDetails();
            product.pricedLine(5);
            System.out.println(product.getSalesPrice(5));
        }
    }
}
