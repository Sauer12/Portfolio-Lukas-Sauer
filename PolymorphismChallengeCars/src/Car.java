public class Car {
    private String description;

    public Car(String description){
        this.description = description;
    }

    public void startEngine(){
        System.out.println("Car engine started...");
    }

    public void drive(){
        System.out.println("Car is driving...");
    }

    protected void runEngine(){
        System.out.println("(Car) -> Engine running!");
    }
}
