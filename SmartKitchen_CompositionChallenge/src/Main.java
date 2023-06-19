
public class Main {
    public static void main(String[] args) {
        SmartKitchen smartKitchen = new SmartKitchen(new CoffeeMaker(true),
                new DishWasher(true), new Refrigerator(true));
        smartKitchen.doKitchenWork();
        System.out.println();
        smartKitchen.doKitchenWork();
        System.out.println();
        smartKitchen.setKitchenState(false, true, false);
        smartKitchen.doKitchenWork();
    }
}
