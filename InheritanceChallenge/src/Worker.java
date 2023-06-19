public class Worker {
    protected String name;
    protected String birthDate;
    protected String endDate;

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    public int getAge(){
        int currentYear = 2023;
        return (currentYear - Integer.parseInt(birthDate.substring(6)));
    }

    public double collectPay(){
        return 1000;
    }

    public void terminate(String endDate){
        System.out.println("End date: " + endDate);
    }
}
