package sk.lukassauer;

import sk.lukassauer.model.LPAStudent;
import sk.lukassauer.model.Student;

import java.util.ArrayList;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < studentCount; i++){
            students.add(new Student());
        }
//        printList(students);

        List<LPAStudent> lpastudents = new ArrayList<>();
        for(int i = 0; i < studentCount; i++){
            lpastudents.add(new LPAStudent());
        }

        printMoreLists(lpastudents);
    }

    public static void printMoreLists(List<? extends Student> students){
        for(var student : students){
            System.out.println(student);
        }
        System.out.println();
    }

/*    public static <T extends Student> void printList(List<T> students){
        for(var student : students){
            System.out.println(student);
        }
        System.out.println();
    }*/

//    Zapis generickej metody!
    public <T> String myMethod(T input){
        return input.toString();
    }
}
