import java.util.Arrays;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                sum = nums[i] + nums[j];
                if(sum == target) {
                    array[0] = i;
                    array[1] = i+1;
                }
            }
        }

        return array;
    }
}
