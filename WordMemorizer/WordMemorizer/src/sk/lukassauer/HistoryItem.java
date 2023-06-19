package sk.lukassauer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HistoryItem {
    private Date date;
    private String name;
    private String score;
    private String maxScore;
    private String hour;
    private String minutes;
    private String seconds;

    public HistoryItem(Date date, String name, String score, String maxScore, String hour, String minutes, String seconds) {
        this.date = date;
        this.name = name;
        this.score = score;
        this.maxScore = maxScore;
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public LocalDate localDate(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public String getHour() {
        return hour;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return localDate(date) + " -> " + name + "(score " + score + "/" + maxScore + ", cas: " + hour + ":" + minutes + ":" + seconds + ")";
    }
}
