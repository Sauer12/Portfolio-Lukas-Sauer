import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for(Integer i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for(String s : fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        Student lukas = new Student("Lukas");
        Student[] students = {new Student("Karol"), new Student("Peter"), new Student("Anna")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}

class Student  implements Comparable<Student>{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {  
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
