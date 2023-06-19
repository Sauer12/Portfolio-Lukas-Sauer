package org.example;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
//        1. - uloha
//        double a = 20.00;
//        double b = 80.00;
//        double c = (a + b) * 100;
//        double remainder = c % 40;
//        boolean isZero = remainder == 0;
//        System.out.println(isZero);
//        if(isZero)
//            System.out.println("0");
//        else
//            System.out.println("got some remainder: " + remainder);

//        2 - uloha
//        boolean gameOver = true;
//        int score = 10000;
//        int levelCompleted = 8;
//        int bonus = 200;
//
//        int finalScore = score;
//
//        if (gameOver) {
//            finalScore += (levelCompleted * bonus);
//            System.out.println("Your final score was " + finalScore);
//        }
        int[] scores = {1500, 1000, 500, 100, 25};

        for(int i = 0; i < scores.length; i++){
            displayHighScorePosition("Lukas", calculateHighScorePosition(scores[i]));
        }

        printMegaBytesAndKiloBytes(2500);
        System.out.println();
        printMegaBytesAndKiloBytes(5000);
    }

//    3. uloha
    public static void displayHighScorePosition(String playerName, int playerPosition){
        System.out.println(playerName + " managed to get into position " + playerPosition + " on the high score list.");
    }

//    3. uloha
    public static int calculateHighScorePosition(int score){
        if(score >= 1000)
            return 1;
        else if(score >= 500)
            return 2;
        else if(score >= 100)
            return 3;
        else
            return 4;
    }

    public static long toMilesPerHour(double kilometeresPerHour){
        double result = kilometeresPerHour / 1.609344d;
        if(kilometeresPerHour < 0)
            return -1;
        else
            return (long)result;
    }

//    KB to MB converter
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0)
            System.out.print("Invalid Value");
        else {
            int megaBytes = kiloBytes / 1024;
            int remainingKiloBytes = kiloBytes - megaBytes * 1024;
            System.out.print(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKiloBytes + " KB");
        }
    }
}
