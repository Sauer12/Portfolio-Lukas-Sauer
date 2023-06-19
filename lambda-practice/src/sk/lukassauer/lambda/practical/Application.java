package sk.lukassauer.lambda.practical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "red", 22000),
                new Car("Honda", "Civic", "Blue", 17700),
                new Car("Toyota", "Land Cruiser", "White", 50000),
                new Car("Toyota", "Corolla", "Black", 16200),
                new Car("Toyota", "Camry", "Blue", 24000),
                new Car("Nissan", "Sentra", "White", 17300),
                new Car("Nissan", "GTR", "Black", 150000));


//        printCars(cars, new CarCondition() {
//            @Override
//            public boolean test(Car c) {
//                return c.getPrice() >= 15000 && c.getPrice() <= 30000;
//            }
//        });

//        printCars(cars, c -> c.getPrice() >= 18000 && c.getPrice() <= 22000);
        printCars(cars, c -> c.getColor().equals("Blue"));

        Function<Car, String> priceAndColor = car -> "price = " + car.getColor() + " color = " + car.getColor();

        System.out.println(priceAndColor.apply(cars.get(3)));
    }

    public static void printCars(List<Car> cars, CarCondition condition){
        for(Car c : cars){
            if(condition.test(c)){
                c.printCar();
            }
        }
    }

    public static void printCarsPriceRange(List<Car> cars, int low, int high){
        for(Car c : cars){
            if(low <= c.getPrice() && c.getPrice() <= high){
                c.printCar();
            }
        }
    }

    public static void printCarByColor(List<Car> cars, String color){
        for(Car c : cars){
            if(c.getColor().equals(color)){
                c.printCar();
            }
        }
    }
}
