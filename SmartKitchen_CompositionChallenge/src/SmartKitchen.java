public class SmartKitchen {
    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    private void addWater(boolean x){
        brewMaster.setHasWorkToDo(x);
    }

    private void pourMilk(boolean x){
        iceBox.setHasWorkToDo(x);
    }

    private void loadDishwasher(boolean x){
        dishWasher.setHasWorkToDo(x);
    }

    public void setKitchenState(boolean coffee, boolean dish, boolean food){
        addWater(coffee);
        loadDishwasher(dish);
        pourMilk(food);
    }

    public void doKitchenWork(){
        brewMaster.brewCoffee();
        dishWasher.doDishes();
        iceBox.orderFood();
    }
}
