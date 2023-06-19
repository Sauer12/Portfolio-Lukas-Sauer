
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountBalance(15000);
        System.out.println(bankAccount.getAccountBalance());
        bankAccount.deposit(1000);
        System.out.println("After deposit: " + bankAccount.getAccountBalance());
        bankAccount.withdraw(500.235);
        System.out.println("After withdraw: " + bankAccount.getAccountBalance());
    }
}
