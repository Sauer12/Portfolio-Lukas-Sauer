package sk.lukassauer.lambda.practical;

@FunctionalInterface
public interface CarCondition {
    boolean test(Car c);
}
