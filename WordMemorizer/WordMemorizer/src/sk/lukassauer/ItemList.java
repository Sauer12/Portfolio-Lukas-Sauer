package sk.lukassauer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ItemList {
    private ArrayList<Item> words;
    private String listName;
    private Date date;
    private int mode;
    private int hintStart;
    private int repeating;
    private int score;

    public ItemList(){
        words = new ArrayList<>();
    }
    public ItemList(String listName) {
        words = new ArrayList<>();
        this.listName = listName;
        score = 0;
    }

    public boolean addItem(String key, String value){
        if(words.size() > 0) {
            for (Item item : words) {
                if (item.getKey().equals(key) || item.getValue().equals(value)) {
                    return false;
                } else if (item.getKey().equals(value) || item.getValue().equals(key)) {
                    return false;
                } else {
                    words.add(new Item(key, value));
                    return true;
                }
            }
            return false;
        }
        else{
            words.add(new Item(key, value));
            return true;
        }
    }

    public void showItems(){
        System.out.println("\n\nNazov zoznamu: " + listName);
        for (Item item : words) {
            System.out.println(item);
        }
        System.out.println("\n\n");
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Item> getWords() {
        return words;
    }

    public Date getDate() {
        return date;
    }

    public String getListName() {
        return listName;
    }

    @Override
    public String toString() {
        return listName + " -> " + date;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getHintStart() {
        return hintStart;
    }

    public void setHintStart(int hintStart) {
        this.hintStart = hintStart;
    }

    public int getRepeating() {
        return repeating;
    }

    public void setRepeating(int repeating) {
        this.repeating = repeating;
    }

    public void setWords(ArrayList<Item> words) {
        this.words = words;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
}
