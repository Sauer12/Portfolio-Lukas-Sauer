package sk.lukassauer.stream.practical;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.print(x));
        System.out.println();

        int val = IntStream
                .range(1, 10)
                .sum();
        System.out.println(val);

        Stream.of("Hello", "bottle", "Africa")
                .sorted()
                .findFirst()
                .ifPresent(x -> System.out.println(x));


    }
}
