import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) throws IOException {
        try (var writer = new FileWriter("pokus.txt")) {
            writer.write("Hello world!");
        }

        try (var reader = new BufferedReader(new FileReader("pokus.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

//            while(true) {
//                 var line = reader.readLine();
//                 if(line == null)
//                     break;
//            }
        }
    }
}
