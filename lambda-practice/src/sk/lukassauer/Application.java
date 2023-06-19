package sk.lukassauer;

public class Application {
    public static void main(String[] args) {
        Human lukas = new Human();
//        walker(lukas);

        Robot robot = new Robot();
//        walker(robot);

        walker(new Walkable(){
            @Override
            public void walk() {
                System.out.println("Custom object walking... ");
            }
        });

        walker(() -> System.out.println("Lambda object walking..."));

        Walkable blockOfCode = () -> System.out.println("Lambda block of code");

        walker(blockOfCode);

        Walkable lambdaSayHello = () -> System.out.println("Hello world");
        walker(lambdaSayHello);
        lambdaSayHello.walk();

        Sumable sum2numbers = (a, b) -> a + b;
        System.out.println(sum2numbers.sum(5, 10));

        Sumable divideNonZero = (a, b) -> {
            if(a == 0) {
                return 0;
            }
            return a / b;
        };

        System.out.println(divideNonZero.sum(0, 5));

        Stringable reverse = (s) -> {
            String result = "";
            for(int i = s.length() - 1; i >= 0; i--){
                result += s.charAt(i);
            }
            return result;
        };

        System.out.println(reverse.operation("Lukas"));

        Factorialable factorialable = n -> {
            int result = 1;
            for(int i = 1; i <= n; i++){
                result = i * result;
            }
            return result;
        };

        System.out.println(factorialable.calculate(5));
    }

    public static void walker(Walkable walkableEntity){
        walkableEntity.walk();
    }

    public int sum(int arg1, int arg2){
        return arg1 + arg2;
    }
    public void sayHello(){
        System.out.println("hello there");
    }

    public int nonZeroDivide(int a, int b){
        if(a == 0){
            return 0;
        }
        return a/b;
    }

    public String reverse(String str){
        String result = "";
        for(int i = str.length() - 1; i >= 0; i--){
            result += str.charAt(i);
        }
        return result;
    }

    public int factorial(int num){
        int result = 1;
        for(int i = 1; i <= num; i++){
            result = i * result;
        }
        return result;
    }
}
