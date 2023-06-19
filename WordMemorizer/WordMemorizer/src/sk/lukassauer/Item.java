package sk.lukassauer;

public class Item {
    private String key;
    private String value;
    private int counterKey;
    private int counterValue;
    public Item(String key, String value) {
        this.key = key;
        this.value = value;
        counterKey = 0;
        counterValue = 0;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public int getCounterKey() {
        return counterKey;
    }

    public void setCounterKey(int counterKey) {
        this.counterKey += counterKey;
    }

    public int getCounterValue() {
        return counterValue;
    }

    public void setCounterValue(int counterValue) {
        this.counterValue += counterValue;
    }

    @Override
    public String toString() {
        return key + " -> " + value;
    }
}
