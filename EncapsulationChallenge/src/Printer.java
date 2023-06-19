public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel;
        this.duplex = duplex;
        pagesPrinted = 0;
    }

    public int addToner(int tonerAmount){
        if(tonerLevel + tonerAmount < 0){
            return -1;
        } else if (tonerLevel + tonerAmount > 100) {
            return  -1;
        } else {
            tonerLevel += tonerAmount;
            return  tonerLevel;
        }
    }

    public void printPages(int pages) {
        if (duplex) {
            if ((pages * 2 >= 0) && (pages * 2 <= tonerLevel)) {
                System.out.println("Printing " + pages + " pages!");
                pagesPrinted += pages * 2;
                tonerLevel -= pages * 2;
            } else if (pages < 0)
                System.out.println("You cannot print less than 1 page...");
            else {
                System.out.println("You cannot print more than 100 page...");
            }
        }
        else{
            if ((pages >= 0) && (pages <= tonerLevel)) {
                System.out.println("Printing " + pages + " pages!");
                pagesPrinted += pages;
                tonerLevel -= pages;
            } else if (pages < 0)
                System.out.println("You cannot print less than 1 page...");
            else {
                System.out.println("You cannot print more than 100 page...");
            }
        }
    }
}
