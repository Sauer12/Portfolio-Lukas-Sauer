import java.util.Comparator;

public class CityDistanceComparator implements Comparator<Town> {
    @Override
    public int compare(Town o1, Town o2) {
        return Integer.compare(o1.getDistanceFromSydney(), o2.getDistanceFromSydney());
    }
}
