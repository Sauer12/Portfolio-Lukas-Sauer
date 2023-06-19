
public class Main {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(5, 8));
    }

    public static double convertToCentimeters(int inchesHeight){
        return inchesHeight * 2.54;
    }

    public static double convertToCentimeters(int feetHeight, int inchesHeight){
        int inches = feetHeight * 12 + inchesHeight;
        return convertToCentimeters(inches);
    }
}
