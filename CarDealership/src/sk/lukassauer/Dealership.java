package sk.lukassauer;

public class Dealership {
    public static void main(String[] args) {
        Customer customer = new Customer("Lukas", "Mala Ida", 10000);
        Vehicle vehicle = new Vehicle("Germany","BMW", 9000);
        Employee employee = new Employee();

        customer.purchaseCar(vehicle, employee, false);
    }
}
