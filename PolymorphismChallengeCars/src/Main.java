
public class Main {
    public static void main(String[] args) {
        GasPoweredCar gasPoweredCar = new GasPoweredCar("BMW 550M", 10, 8);
        ElectricCar electricCar = new ElectricCar("Tesla S", 500, 1000);
        HybridCar hybridCar = new HybridCar("Porsche Panamera hybrid", 5.5, 400, 8);

        gasPoweredCar.drive();
        electricCar.drive();
        hybridCar.drive();
    }
}
