public class SalariedEmployee extends Employee{
    protected double annualSalary;
    protected boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String endDate, long employeeId, String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, endDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public void retire(){
        isRetired = true;
        System.out.println(name + " retired!");
    }


}
