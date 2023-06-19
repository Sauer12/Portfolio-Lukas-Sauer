package ExceptionsAndFiles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FooRuntimeException{
     /*   Application app = new Application();
//        app.inputTest();
//        app.fileRead();
        app.subtract10FromLargerNumber(5);*/
//        System.out.println(99 % 10);
//       1 System.out.println(hasSharedDigit(12, 13));
//        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(5 % 5);
        System.out.println(1 / 2);
    }

    public static boolean hasSharedDigit(int a, int b){
        if((a < 10 || a > 99) || (b < 10 || b > 99)){
            return false;
        }

        int digitA = 0;
        int digitB = 0;
        int copyB = b;
        while(a != 0){
            digitA = a % 10;
            while(copyB != 0){
                digitB = copyB % 10;
                if(digitA == digitB)
                    return true;
                copyB = copyB / 10;
            }
            a = a / 10;
        }
        return false;
    }

    public static int getGreatestCommonDivisor(int first, int second){
        if(first < 10 || second < 10)
            return -1;

        for(int i = first; i > 0; i--){
            if(first % i == 0){
                for(int j = second; j > 0; j--){
                    if(second % j == 0 && second % j == i){
                        return i;
                    }
                }
            }
        }

        return 1;
    }
}
