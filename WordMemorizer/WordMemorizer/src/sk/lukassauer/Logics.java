package sk.lukassauer;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logics {
    private ItemList itemList;
    private final FileManipulator fileManipulator;

    private HistoryList historyList;

    public Logics() {
        itemList = new ItemList();
        fileManipulator = new FileManipulator();
        historyList = new HistoryList();
    }

    public void createItemList(String name, int numberOfWords, Scanner scanner){
        itemList = new ItemList(name);
        String keyValue;
        boolean isValid = true;
        for(int i = 0; i < numberOfWords; i++){
            screenCleaner();
            do {
                System.out.println("Slovo " + (i + 1));
                System.out.print("Zadaj slovo a preklad v tvare [slovo;preklad]: ");
                keyValue = scanner.nextLine();
                if(keyValue.length() < 3 || (!isValidKeyValue(keyValue))){
                    System.out.println("Zadal si nespravny format! Skus to znova");
                    isValid = false;
                } else{
                    String[] words = keyValue.split(";");
                    if(!itemList.addItem(words[0], words[1])){
                        isValid = false;
                    } else{
                        isValid = true;
                    }
                }
            } while (!isValid);
        }

        itemList.showItems();
        fileManipulator.saveItemList(itemList);
    }

    public void showItemLists(Scanner scanner, boolean isLearningSection){
        int size = fileManipulator.showFilesInDirectories();
        String option;
        int choice = 0;
        boolean next = true;

        if(size < 1){
            System.out.println("Nemas vytvoreny ziadne list!");
            return;
        }
        do {
            System.out.print("Vyber si list(zadaj cislo): ");
            option = scanner.nextLine();
            if(!option.equals("X")) {
                try {
                    choice = Integer.parseInt(option);
                    if(choice <= size && choice > 0){
                        next = true;
                    } else{
                        System.out.println("Zadal si hodnotu mimo rozsahu, skus to znova!");
                        next = false;
                    }
                } catch (Exception e) {
                    System.out.println("Zadal si nespravnu moznost!");
                    next = false;
                }
            } else{
                return;
            }
        } while (!next);

        if(!isLearningSection)
            fileManipulator.readItemList(choice - 1);
        else{
            itemList.getWords().clear();
            fileManipulator.loadItemList(choice - 1, itemList);
        }
    }
    private boolean isValidKeyValue(String keyValue){
        int counter = 0;
        for(int i = 0; i < keyValue.length(); i++){
            if(keyValue.charAt(0) != ';') {
                if (keyValue.charAt(i) == ';' && i != keyValue.length() - 1)
                    counter++;
            }
        }
        if(counter == 1)
            return true;
        else
            return false;
    }

    public boolean checkFile(String name){
        itemList = new ItemList(name);
        return fileManipulator.checkFileExists(itemList);
    }

    public ItemList getItemList() {
        return itemList;
    }

    private void screenCleaner(){
        System.out.println("\n".repeat(100));
    }

    public void iterateItemList(){
        for(Item item : itemList.getWords()){
            System.out.println(item);
        }
    }
//    CLEAR ItemList
    public void clearItemList(){
        itemList = new ItemList();
    }

//    SETTINGS
    public void importSettings(){
        int[] settings = fileManipulator.loadSettings();
        itemList.setRepeating(settings[0]);
        itemList.setMode(settings[1]);
        itemList.setHintStart(settings[2]);
    }
    public void repeatSettings(Scanner scanner){
        boolean next = false;
        String opinion = "";
        int opinionInt = 0;
        do{
            System.out.print("\nZvol pocet opakovani(min 1, max 20): ");
            opinion = scanner.nextLine();
            try{
                opinionInt = Integer.parseInt(opinion);
                if(opinionInt < 1 || opinionInt > 20){
                    System.out.println("Zvolil si nespravny pocet opakovani, skus to znova!");
                } else{
                    next = true;
                }
            } catch (Exception e){
                System.out.println("Zadal si neplatnu hodnotu!");
            }
        } while (!next);

        fileManipulator.changeSettings(opinionInt, itemList.getMode(), itemList.getHintStart());
    }

    public void modeSettings(Scanner scanner){
        boolean next = false;
        String opinion = "";
        int opinionInt = 0;

        do{
            System.out.println("\n1 - Doplnovanie value");
            System.out.println("2 - Doplnovanie key");
            System.out.println("3 - Hybridny mod");
            System.out.print("Zvol mod: ");
            opinion = scanner.nextLine();
            try{
                opinionInt = Integer.parseInt(opinion);
                if(opinionInt < 1 || opinionInt > 3){
                    next = false;
                    System.out.println("Zvolil si nespravny mod!");
                } else{
                    next = true;
                }
            } catch (Exception e){
                System.out.println("Zadal si neplatnu hodnotu!");
            }
        } while (!next);

        fileManipulator.changeSettings(itemList.getRepeating(), opinionInt, itemList.getHintStart());
    }

    public void hintSettings(Scanner scanner){
        boolean next = false;
        String opinion = "";
        int opinionInt = 0;
        do{
            System.out.print("\nZvol po kolkych nespravnych pokusoch sa ma zacat zobrazovat napoveda: ");
            opinion = scanner.nextLine();
            try{
                opinionInt = Integer.parseInt(opinion);
                if(opinionInt < 0){
                    next = false;
                    System.out.println("Zvolil si neplatnu hodnotu!");
                } else{
                    next = true;
                }
            } catch (Exception e){
                System.out.println("Zadal si neplatnu hodnotu!");
            }
        } while (!next);

        fileManipulator.changeSettings(itemList.getRepeating(), itemList.getMode(), opinionInt);
    }

//    LEARNING SECTION
    public void learn(Scanner scanner){
        Random random = new Random();
        int size = itemList.getWords().size() * itemList.getRepeating();
        int numberOfWords = itemList.getWords().size();
        if(itemList.getMode() == 3){
            size *= 2;
        }
        boolean isValid;
        int numberOfTries = 0;
        int index;
        String word, type;
        String[] words;
        LocalTime timeStart = LocalTime.now();

        for(int i = 0; i < size; i++){
            screenCleaner();
            System.out.println("LEARNING...\n");
            isValid = true;

            do {
                words = returnWord(random, numberOfWords);
                word = words[0];
                type = words[1];
                index = Integer.parseInt(words[2]);
                if(type.equals("key")) {
                    if(itemList.getWords().get(index).getCounterKey() >= itemList.getRepeating()) {
                        isValid = false;
                    } else {
                        isValid = generatingWordHelper(word, numberOfTries, index, type, scanner);
                    }
                } else if(type.equals("value")){
                    if(itemList.getWords().get(index).getCounterValue() >= itemList.getRepeating()) {
                        isValid = false;
                    } else{
                        isValid = generatingWordHelper(word, numberOfTries, index, type, scanner);
                    }
                }
            }while (!isValid);


            System.out.println("\nTvoje hodnotenie -> " + itemList.getScore() + " / " + size);
        }

        LocalTime timeEnd = LocalTime.now();
        long input = ChronoUnit.SECONDS.between(timeStart, timeEnd);
        long minutes = 0;
        long hours = 0;
        long seconds = 0;

        if((input/3600) != 0){
            hours = input / 3600;
            input = input % 3600;
        }
        if((input/60) != 0){
            minutes = input / 60;
            input = input % 60;
        }
        if((input) != 0){
            seconds = input;
        }

        System.out.println("Ucenie si dokoncil za: " + hours + ":" + minutes + ":" + seconds);
        fileManipulator.saveLearningHistory(hours, minutes, seconds, itemList.getScore(), getItemList().getListName(), size);
    }

    public boolean generatingWordHelper(String word, int numberOfTries, int index, String type, Scanner scanner){
        do {
            System.out.print(word + " -> ");
            numberOfTries++;
            if (numberOfTries >= itemList.getHintStart()) {
                showHint(index, numberOfTries, type);
            }
        } while (!compareKeyWithValue(index, scanner, type, word));

        if (numberOfTries == 1) {
            itemList.setScore(1);
        }
        numberOfTries = 0;
        return true;
    }
    public String[] returnWord(Random random, int size){
        String[] words = new String[3];
        int index = random.nextInt(size);
        if(itemList.getMode() == 1){
            words[0] = itemList.getWords().get(index).getKey();
            words[1] = "key";
        } else if(itemList.getMode() == 2){
            words[0] = itemList.getWords().get(index).getValue();
            words[1] = "value";
        } else{
            int keyValue = random.nextInt(3);
            if(keyValue == 1){
                words[0] = itemList.getWords().get(index).getKey();
                words[1] = "key";
            } else{
                words[0] = itemList.getWords().get(index).getValue();
                words[1] = "value";
            }
        }
        words[2] = String.valueOf(index);

        return words;
    }

    public void showHint(int index, int numberOfTries, String type){
        int sizeOfHint = numberOfTries - itemList.getHintStart();
        if(type.equals("key")) {
            if (sizeOfHint > itemList.getWords().get(index).getValue().length()) {
                    System.out.print(itemList.getWords().get(index).getValue());
            } else {
                String hint = itemList.getWords().get(index).getValue();
                for (int i = 0; i < sizeOfHint; i++) {
                    System.out.print(hint.charAt(i));
                }
            }
        } else{
            if (sizeOfHint > itemList.getWords().get(index).getKey().length()) {
                System.out.print(itemList.getWords().get(index).getKey());
            } else {
                String hint = itemList.getWords().get(index).getKey();
                for (int i = 0; i < sizeOfHint; i++) {
                    System.out.print(hint.charAt(i));
                }
            }
        }
    }

    public boolean compareKeyWithValue(int index, Scanner scanner, String type, String word){
        String input;
        if(type.equals("key")) {
            System.out.print("(" + itemList.getWords().get(index).getValue().length() + "): ");
            input = scanner.nextLine();
            if(input.equals(itemList.getWords().get(index).getValue())){
                itemList.getWords().get(index).setCounterKey(1);
                System.out.println("\nSPRAVNE!!!");

                try {
                    Thread.sleep(1500);
                } catch (Exception e){
                    System.out.println("Nepodarilo sa uspat vlakno!");
                }

                return true;
            }
            return false;
        }else{
            System.out.print("(" + itemList.getWords().get(index).getKey().length() + "): ");
            input = scanner.nextLine();
            if(input.equals(itemList.getWords().get(index).getKey())){
                itemList.getWords().get(index).setCounterValue(1);
                System.out.println("\nSPRAVNE!!!");

                try {
                    Thread.sleep(1000);
                } catch (Exception e){
                    System.out.println("Nepodarilo sa uspat vlakno!");
                }

                return true;
            }
            return false;
        }
    }

// HISTORY LISTS SECTION
    public void importAllHistory(){
        historyList.setHistoryItems(fileManipulator.loadLearningHistory());
    }

    public void printHistory(){
        int i = 1;
        for(HistoryItem historyItem: historyList.getHistoryItems()){
            System.out.println(i + ". " + historyItem);
            i++;
        }
    }
}
