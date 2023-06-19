public class Hamburger extends Burger{

    private int numberOfHams;
    public Hamburger(String size, int numberOfMeats, int numberOfIngredients, int numberOfHams) {
        super("Hamburger", size, numberOfMeats, numberOfIngredients);
        this.numberOfHams = numberOfHams;
        calculatePrice();
    }

    @Override
    public void calculatePrice() {
        super.calculatePrice();
        price += numberOfHams * 0.5;
    }

    public int getNumberOfHams() {
        return numberOfHams;
    }

    @Override
    public String toString() {
        return "Hamburger: " + getName() + "\nsize: " + getSize() + "\nnumber of hams: " + numberOfHams + "\nprice:" + getPrice();
    }
}
