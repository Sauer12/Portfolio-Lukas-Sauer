
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Customer customer2 = new Customer("Karol", 1000, "email@test.com");
        Customer customer3 = new Customer("Peter", "Peter@petrovsky.com");

        System.out.println(customer);
        System.out.println(customer2);
        System.out.println(customer3);
    }
}
