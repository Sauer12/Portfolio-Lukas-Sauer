// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("0 is " + (isPrime(0) ? "" : "NOT") + "a prime number");

        int primeNumber = 0;

        for(int i = 200; i <= 500; i++){
            if(primeNumber == 3)
                break;
            else if(isPrime(i)) {
                System.out.println(i);
                primeNumber++;
            }
        }
    }

    public static boolean isPrime(int wholeNumber){
        if (wholeNumber <= 2){
            return (wholeNumber == 2);
        }

        for (int divisor = 2; divisor < wholeNumber; divisor++){
            if (wholeNumber % divisor == 0){
                return false;
            }
        }

        return true;
    }
}
