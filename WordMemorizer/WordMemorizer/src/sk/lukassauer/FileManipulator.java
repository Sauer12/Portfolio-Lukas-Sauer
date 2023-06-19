package sk.lukassauer;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManipulator {
    private LocalDate date;
    private String pattern = "dd.MM.yyyy";
    private String dirName = "/Users/lsauer/Desktop/WordMemorizer/WordMemorizer/src/sk/lukassauer/lists/";
    private String dirNameSettings = "/Users/lsauer/Desktop/WordMemorizer/WordMemorizer/src/sk/lukassauer/settings/";
    private String dirNameHistory =  "//Users/lsauer/Desktop/WordMemorizer/WordMemorizer/src/sk/lukassauer/history/";

    public void saveItemList(ItemList itemList){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateString = simpleDateFormat.format(new Date());

            FileWriter fileWriter = new FileWriter(dirName + itemList.getListName() + ".txt");
            fileWriter.write(itemList.getListName() + "\n");
            fileWriter.write(dateString + "\n");
            for (int i = 0; i < itemList.getWords().size(); i++) {
                fileWriter.write(itemList.getWords().get(i).getKey() + ";" + itemList.getWords().get(i).getValue() + "\n");
            }
            fileWriter.close();
        } catch (IOException e){
            System.out.println("List nebol ulozeny! Nastala chyba pri ukladani suboru!");
        }
    }

    public void loadItemList(int choice, ItemList itemList){
        String listName = itemListName(choice);
        try{
            File file = new File(dirName + listName);
            Scanner reader = new Scanner(file);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

            int counter = 0;
            while (reader.hasNextLine()){
                if(counter == 0){
                    itemList.setListName(reader.nextLine());
                } else if(counter == 1){
                    itemList.setDate((Date) dateFormat.parse(reader.nextLine()));

                } else{
                    String[] values = reader.nextLine().split(";");
                    itemList.addItem(values[0], values[1]);
                }
                counter++;
            }
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("Nastala chyba!");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void readItemList(int choice){
        String listName = itemListName(choice);
        try {
            System.out.println("\n\n");
            File file = new File(dirName + listName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("Pri nacitani subora nastala chyba!");
        }
    }

    public int showFilesInDirectories(){
        File directoryPath = new File(dirName);
        String[] itemLists = directoryPath.list();
        for(int i = 0; i < itemLists.length; i++){
            System.out.println((i + 1) + " - " + itemLists[i]);
        }

        return itemLists.length;
    }

    private String itemListName(int choice){
        File directoryPath = new File(dirName);
        String[] itemLists = directoryPath.list();
        return itemLists[choice];
    }

    public boolean checkFileExists(ItemList itemList){
        File file = new File(dirName + itemList.getListName() + ".txt");
        if(file.exists())
            return true;
        return false;
    }

//    SETTINGS
    public int[] loadSettings(){
        File file = new File(dirNameSettings + "settings.txt");
        int[] settings = {3, 1, 3};
        if(file.exists()){
            try {
                file = new File(dirNameSettings + "settings.txt");
                Scanner reader = new Scanner(file);
                int counter = 0;
                while (reader.hasNextLine()) {
                    settings[counter] = Integer.parseInt(reader.nextLine());
                    counter++;
                }
                reader.close();
            }catch (FileNotFoundException e){
                System.out.println("Subor nebol najdeny!");
            }
        } else{
            try {
                FileWriter fileWriter = new FileWriter(dirNameSettings + "settings.txt");
                fileWriter.write("3\n1\n3");
                fileWriter.close();
            }catch (IOException e){
                System.out.println("Nastala chyba pri importovani nastaveni!");
            }
        }

        return settings;
    }

    public void changeSettings(int repeat, int mode, int hint){
        try{
            FileWriter fileWriter = new FileWriter(dirNameSettings + "settings.txt", false);
            fileWriter.write(repeat + "\n" + mode + "\n" + hint);
            fileWriter.close();
        } catch (Exception e){
            System.out.println("Nepodarilo sa upravit nastavenia!");
        }
    }

//    HISTORY SAVING
    public void saveLearningHistory(long hours, long minutes, long seconds, int score, String listName, int maxScore){
        File file = new File(dirNameHistory + "history.txt");
        String line = LocalDate.now() + ";" + listName + ";" + score + ";" + maxScore + ";" + hours + ";" + minutes + ";" + seconds;
        if(file.exists()) {
            try {
               FileWriter fileWriter = new FileWriter(file, true);
               PrintWriter out = new PrintWriter(fileWriter);
               out.println(line);
               out.close();
            } catch (Exception e){
                System.out.println("Nepodarilo sa pripisat historiu ucenia do suboru!");
            }
        } else{
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(line + "\n");
                fileWriter.close();
            }catch (IOException e){
                System.out.println("Nastala chyba pri vytvarani suboru 'history' !");
            }
        }
    }

    public ArrayList<HistoryItem> loadLearningHistory(){
        ArrayList<HistoryItem> arrayList = new ArrayList<>();
        String[] items;
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            File file = new File(dirNameHistory + "history.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                items = reader.nextLine().split(";");
                try {
                    date = ((Date) dateFormat.parse(items[0]));
                    arrayList.add(new HistoryItem(date, items[1], items[2], items[3], items[4], items[5], items[6]));
                } catch (Exception e){
                    System.out.println("Nepodarilo sa ulozit datum!");
                }
            }
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("Pri nacitani suboru 'history' nastala chyba!");
        }

        return arrayList;
    }
}
