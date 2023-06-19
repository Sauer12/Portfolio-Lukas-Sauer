
public abstract class ProductForSale {
    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity){
        return quantity * price;
    }

    public void pricedLine(int quantity){
        System.out.println(this.getClass().getSimpleName() + ": quantity: " + quantity + " , item price: " + price);
    }

    public abstract void showDetails();
}
