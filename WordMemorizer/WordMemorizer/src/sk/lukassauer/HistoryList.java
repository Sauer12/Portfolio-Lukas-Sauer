package sk.lukassauer;

import sk.lukassauer.HistoryItem;

import java.util.ArrayList;

public class HistoryList {
    private ArrayList<HistoryItem> historyItems;

    public HistoryList() {
        this.historyItems = new ArrayList<>();
    }

    public ArrayList<HistoryItem> getHistoryItems() {
        return historyItems;
    }

    public void setHistoryItems(ArrayList<HistoryItem> historyItems) {
        this.historyItems = historyItems;
    }
}
