package sk.lukassauer.inventorymanager;

public class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id: " + id + " | name: " + name;
    }
}
