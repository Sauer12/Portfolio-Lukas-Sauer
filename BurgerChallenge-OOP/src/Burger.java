public class Burger {
    protected double price = 0;
    private String name;
    private String size;
    private int numberOfMeats;
    private int numberOfIngredients;

    public Burger(){
        name = "Classic Burger";
        size = "medium";
        numberOfMeats = 1;
        numberOfIngredients = 3;
        calculatePrice();
    }

    public Burger(String name, String size, int numberOfMeats, int numberOfIngredients) {
        this.name = name;
        this.size = size;
        this.numberOfMeats = numberOfMeats;
        this.numberOfIngredients = numberOfIngredients;
        calculatePrice();
    }

    public void calculatePrice(){
        price += numberOfMeats * 2 + numberOfIngredients * 0.5;
        if(size.equals("medium")){
            price += 3;
        } else if(size.equals("small")){
            price += 2;
        } else if(size.equals("large")){
            price += 4;
        }
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getNumberOfMeats() {
        return numberOfMeats;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    @Override
    public String toString() {
        return "Burger: " + name + "\nsize: " + size + "\nprice: " + price + "€";
    }
}
