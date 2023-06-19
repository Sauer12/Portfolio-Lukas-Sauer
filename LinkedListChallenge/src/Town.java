public class Town {
    private String name;
    private int distanceFromSydney;

    public Town(String name, int distanceFromSydney) {
        this.name = name;
        this.distanceFromSydney = distanceFromSydney;
    }

    public String getName() {
        return name;
    }

    public int getDistanceFromSydney() {
        return distanceFromSydney;
    }
}
