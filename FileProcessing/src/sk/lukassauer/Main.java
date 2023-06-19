package sk.lukassauer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Citanie zo suboru
        File file = new File("test");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Util util = new Util();
        try {
            util.number(5);
        } catch (FooRuntimeException e) {
            e.printStackTrace();
        }

    }
}
