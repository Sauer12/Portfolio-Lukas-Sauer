// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        for (double rate = 7.5; rate <= 10.0; rate += 0.25){
            System.out.println("$100 at " + rate + "% interest = $" + calculateInterest(100.0, rate));
        }
    }

    public static double calculateInterest(double amount, double interestRate){
        return (amount * (interestRate / 100));
    }
}
