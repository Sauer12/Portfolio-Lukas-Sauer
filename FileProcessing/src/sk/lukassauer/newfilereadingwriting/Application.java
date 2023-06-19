package sk.lukassauer.newfilereadingwriting;

import java.io.*;

public class Application{
    public static void main(String[] args){
        File file = new File("test");
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Problem reading line from file -> " + file.getName());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e){
                System.out.println("File is not possible to close!");
            } catch (NullPointerException){
                System.out.println("Null pointer exception!");
            }
        }

    }
}
