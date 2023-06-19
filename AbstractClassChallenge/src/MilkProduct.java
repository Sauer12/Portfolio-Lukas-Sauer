public class MilkProduct extends ProductForSale{

    public MilkProduct(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(this.getClass().getSimpleName() + ", " + description + ", " + price);
    }
}
