public class MealOrder {
    private static Burger burger;
    private Drink drink;
    private SideItem sideItem;

    public MealOrder(){

    }

    public MealOrder(Burger burger){
        this.burger = burger;
    }

    public MealOrder(Burger burger, Drink drink, SideItem sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    public static void mealPrice(){
        System.out.println(burger);
    }

    @Override
    public String toString() {
        return burger.toString();
    }
}
