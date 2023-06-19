
public class Main {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Lukas", "01.02.2000", "28.3.2023", 12, "1.2.2000",
                1300.50, false);
        salariedEmployee.retire();
        System.out.println(salariedEmployee.getAge());
    }
}
