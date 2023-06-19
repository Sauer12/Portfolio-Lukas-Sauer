// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(getDurationString(5000));
    }

    public static String getDurationString(int seconds){
        if(seconds >= 0) {
            int minutes = seconds / 60;
            seconds = seconds % 60;
            return getDurationString(minutes, seconds);
        }
        else
            return "Seconds cant be negative!";
    }

    public static String getDurationString(int minutes, int seconds){
        if(minutes >= 0 && (seconds >=0 && seconds <= 59)) {
            int hours = minutes / 60;
            minutes = minutes % 60;
            return hours + "h " + minutes + "m " + seconds + "s";
        }
        else
            return "Minutes cant be negative!";
    }
}
