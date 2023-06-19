
public class Main {
    public static void main(String[] args) {
        Customer lukas = new Customer("Lukáš");
        Customer anna = new Customer("Anna");
        Bank bank = new Bank();
        bank.addNewCustomer(lukas);
        bank.addNewCustomer(anna);
        bank.addTransaction(lukas, anna, 500);
        System.out.println("Lukas: " + lukas.getTransactions());
        System.out.println("Anna: " + anna.getTransactions());
    }
}
