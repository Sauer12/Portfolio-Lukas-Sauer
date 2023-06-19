// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(sumDigits(823));
    }

    public static int sumDigits(int number){
        if(number <= 0){
            return -1;
        }
        else if(number > 0 && number < 10)
            return number;
        else{
            boolean exit = false;
            int digitSum = 0;
            while(!exit){
                digitSum += number % 10;
                if(number > 0 && number < 10)
                    break;
                number = number / 10;
            }
            return digitSum;
        }
    }
}
