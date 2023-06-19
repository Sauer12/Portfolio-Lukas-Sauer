
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(100, false);
        printer.printPages(50);
        printer.printPages(51);
        printer.addToner(11);
        printer.printPages(11);
    }
}
