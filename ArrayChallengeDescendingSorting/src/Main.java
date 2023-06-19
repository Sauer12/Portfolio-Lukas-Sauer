import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] unsortedRandomArray = randomFill(12, 100);
        System.out.println(Arrays.toString(unsortedRandomArray));
        int[] sortedRandomArray = descendingSort(unsortedRandomArray);
        System.out.println(Arrays.toString(sortedRandomArray));
    }

    private static int[] descendingSort(int[] array) {
        for(int i = array.length - 1; i > 0; i--){
            for(int j = array.length - 1; j > 0; j--){
                if(array[j] > array[j - 1]){
                    int changer = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = changer;
                }
            }
        }
        return array;
    }

    public static int[] randomFill(int length, int maxValue){
        Random random = new Random();
        int[] array = new int[length];
        for(int i = 0; i < length; i++){
            array[i] = random.nextInt(maxValue + 1);
        }
        return array;
    }
}
