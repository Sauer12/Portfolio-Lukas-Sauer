import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = readIntegers(scanner.nextLine());
        System.out.println(Arrays.toString(array));
        System.out.println(minimumValue(array));
    }

    public static int[] readIntegers(String input){
        String[] stringArray = input.split(",");
        int[] array = new int[stringArray.length];

        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(stringArray[i]);
        }

        return array;
    }

    public static int minimumValue(int[] array){
        int min = array[0];
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                min = array[i+1];
            }
        }

        return min;
    }
}
