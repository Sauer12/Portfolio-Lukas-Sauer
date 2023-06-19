public class HourlyEmployee extends Employee{
    protected double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, String endDate, long employeeId, String hireDate, double hourlyPayRate) {
        super(name, birthDate, endDate, employeeId, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public void getDoublePay(){
        hourlyPayRate *= 2;
        System.out.println("HourlyPayRate(double pay): " + hourlyPayRate);
    }
}
