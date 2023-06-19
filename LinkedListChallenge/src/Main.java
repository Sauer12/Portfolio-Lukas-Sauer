import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Town> listOfCities = new LinkedList<>();
        listOfCities.add(new Town("Sydney", 0));
        listOfCities.add(new Town("Adelaide", 1374));
        listOfCities.add(new Town("Alice Springs", 2771));
        listOfCities.add(new Town("Brisbane", 917));
        listOfCities.add(new Town("Darwin", 3972));
        listOfCities.add(new Town("Melbourne", 877));
        listOfCities.add(new Town("Perth", 3923));

        CityDistanceComparator cityDistanceComparator = new CityDistanceComparator();
        listOfCities.sort(cityDistanceComparator);
        var iter = listOfCities.listIterator();

//         od najblizsie vzdialeneho po najviac vzdialene
        while(iter.hasNext()){
            System.out.println(iter.next().getName());
        }

        System.out.println("\n\n");
//        od najdalej vzdialeneho po najmenej vzdialene
        while (iter.hasPrevious()){
            System.out.println(iter.previous().getName());
        }
    }
}
