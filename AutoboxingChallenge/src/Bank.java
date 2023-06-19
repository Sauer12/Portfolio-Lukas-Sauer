import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addNewCustomer(Customer customer){
        if(!customers.contains(customer)){
            customers.add(customer);
        } else {
            System.out.println("Customer already exists in the bank!");
        }
    }
    public void addTransaction(Customer credit, Customer debit, double amount){
        if(customers.contains(debit) && customers.contains(credit)){
            credit.transaction(amount);
            debit.transaction(-amount);
            System.out.println(credit.getName() + " obtained " + amount + " from " + debit.getName());
        } else{
            System.out.println("Transaction failed!");
        }
    }
}
