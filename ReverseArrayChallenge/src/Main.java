import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 10, 2, 5, 3, 17, 12};
        System.out.println(Arrays.toString(array));
        reverseArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array){
        int length = array.length / 2;
        for(int i = 0, j = array.length - 1; i < length; i++, j--){
            int swapper = array[i];
            array[i] = array[j];
            array[j] = swapper;
        }
    }
}
