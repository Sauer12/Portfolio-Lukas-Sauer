package ExceptionsAndFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {
    public Scanner scanner = new Scanner(System.in);

    public void inputTest(){
        System.out.print("Enter your age: ");
        String age = scanner.nextLine();
        System.out.println("Your age -> " + age);
    }

    //    Metoda zobere file a precita z neho riadky ktore vypise
    public void fileRead() {
        try {
            File file = new File("myfile.txt");
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("file not found!");
//            e.printStackTrace();
        }
    }

    public int subtract10FromLargerNumber(int number) throws FooRuntimeException{
        if(number < 10){
            throw new FooRuntimeException("The number passed was smaller than 10");
        }
        return number - 10;
    }
}
