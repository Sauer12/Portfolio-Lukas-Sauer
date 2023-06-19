package sk.lukassauer;

public class Customer {
    private String name;
    private String address;
    private double cashOnHand;

    public Customer(String name, String address, double cashOnHand){
        this.name = name;
        this.address = address;
        this.cashOnHand = cashOnHand;
    }
    public void purchaseCar(Vehicle vehicle, Employee employee, boolean finance){
        employee.handleCustomer(this, finance, vehicle);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getCashOnHand() {
        return cashOnHand;
    }
}
