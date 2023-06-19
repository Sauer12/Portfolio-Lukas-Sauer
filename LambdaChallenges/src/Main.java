import java.util.function.Consumer;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for(String part : parts){
                    System.out.println(part);
                }
            }
        };


    }

    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();

        for(int i = 0; i < source.length(); i++){
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }
}
