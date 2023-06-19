package sk.lukassauer.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        for(String s : list){
            System.out.println(s);
        }

        System.out.println("-".repeat(10));
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(10));
        list.forEach(s -> {
            char first = s.charAt(0);
            System.out.println(s + " means " + first);
        });

        System.out.println("-".repeat(10));
        int result = calculator((a, b) -> a + b, 10, 15);
        var result2 = calculator((a, b) -> a / b, 10.5, 2.5);
        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Lukas", "Sauer");

        System.out.println("-".repeat(10));
        var coords = Arrays.asList(
                new double[]{50.4, 100.2},
                new double[]{112.154, 140.24},
                new double[]{124.124, 23.23214});

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%,3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("-".repeat(10));
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lng) -> System.out.printf("[lat:%.3f lon:%,3f]%n", lat, lng)));

        System.out.println("-".repeat(10));
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(10));
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(10));
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
            + switch (i){
                case 0 -> "one";
                case 1 -> "two";
                case 2 -> "three";
                default -> "";
        });
        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Ann", "Bob", "Karl"};
        String[] randomList = randomlySelectedValues(15, names,
                () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));
    }

    public static  <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[count];
        for(int i = 0; i < count; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }

//    Consumer, Function, Predicate, Supplier
}