// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int i = 5;
        int oddCounter = 0;
        int evenCounter = 0;

        while(i <= 20){
            if(evenCounter == 5){
                break;
            }

            if(isEvenNumber(i)) {
                System.out.print(i + " ");
                evenCounter++;
            }
            else {
                oddCounter++;
            }
            i++;
        }

        System.out.println("\nOdd numbers: " + oddCounter + ", Even numbers: " + evenCounter);
    }

    public static boolean isEvenNumber(int number){
        if(number % 2 == 0)
            return true;
        else
            return false;
    }
}
