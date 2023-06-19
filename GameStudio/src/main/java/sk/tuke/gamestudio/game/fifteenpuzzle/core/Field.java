package sk.tuke.gamestudio.game.fifteenpuzzle.core;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    private final int columnCount;
    private final int rowCount;
    private int modeOfPossibleMoves;
    private int numberOfMoves;
    private long totalTimeMinutes;
    private long totalTimeSeconds;
    private long startTimeInMs = 0;
    private FieldState state = FieldState.PLAYING;
    private final Tile[][] tiles;
    public Field(int rowCount, int columnCount){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        tiles = new Tile[rowCount][columnCount];
        generate();
        startTimeInMs = System.currentTimeMillis();
    }

    private void generate(){
//        generateGameStones();
        fillNoRandom();
        setPossibleMoves();
    }

    private ArrayList<Integer> generateNumbers(){
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int numberOfTiles = rowCount * columnCount;

        for(int i = 0; i < numberOfTiles;){
            int number = random.nextInt(numberOfTiles);
            if(!numbers.contains(number)){
                numbers.add(number);
                i++;
            }
        }

        return numbers;
    }

    private void generateGameStones(){
        ArrayList<Integer> numbers = generateNumbers();
        int indexOfNumbers = 0;

        for(int row = 0; row < rowCount; row++)
            for(int column = 0; column < columnCount; column++, indexOfNumbers++){
            {
                if(numbers.get(indexOfNumbers) != 0)
                    tiles[row][column] = new GameStone(numbers.get(indexOfNumbers));
                else
                    tiles[row][column] = new EmptyTile();
            }
        }
    }

    private void setPossibleMoves(){
        for(int row = 0; row < rowCount; row++){
            for(int column = 0; column < columnCount; column++){
                if(tiles[row][column] instanceof EmptyTile){
                    modeOfPossibleMoves = findPossibleMoves(row, column);
                }
            }
        }
    }

    private int findPossibleMoves(int row, int column){
        int possibleMoves = NumberOfPossibleMoves(row, column);

        if(possibleMoves == 2){
            if(column + 1 < columnCount && row + 1 < rowCount)
               return 1;
            if(column - 1 >= 0 && row + 1 < rowCount)
                return 2;
            if(column + 1 < columnCount && row - 1 >= 0)
                return 3;
            else
                return 4;
        }
        else if(possibleMoves == 3){
            if(column + 1 < columnCount && row + 1 < rowCount && column - 1 >= 0)
                return 5;
            if(column + 1 < columnCount && row - 1 >= 0 && row + 1 < rowCount)
                return 6;
            if(column - 1 >= 0 && row + 1 < rowCount && row - 1 >= 0)
                return 7;
            else
                return 8;
        }
        else{
            return 9;
        }
    }

    private int NumberOfPossibleMoves(int row, int column) {
        int possibleMoves = 0;
        if(column + 1 < columnCount){
            possibleMoves++;
        }
        if(column - 1 >= 0){
            possibleMoves++;
        }
        if(row + 1 < rowCount){
            possibleMoves++;
        }
        if(row - 1 >= 0){
            possibleMoves++;
        }

        return possibleMoves;
    }

//    private Tile findEmptyTile(){
//        for(int row = 0; row < rowCount; row++){
//            for(int column = 0; column < columnCount; column++){
//                if(tiles[row][column] instanceof EmptyTile){
//                    return tiles[row][column];
//                }
//            }
//        }
//    }

    private int findEmptyTileY(){
        for(int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (tiles[row][column] instanceof EmptyTile) {
                    return row;
                }
            }
        }
        return -1;
    }

    private int findEmptyTileX(){
        for(int row = 0; row < rowCount; row++) {
            for(int column = 0; column < columnCount; column++) {
                if(tiles[row][column] instanceof EmptyTile) {
                    return column;
                }
            }
        }
        return -1;
    }

     public void swapTilesWeb(int row, int column){
        int y = findEmptyTileY();
        int x = findEmptyTileX();
        Tile helpVariable = tiles[y][x];


        if(row + 1 == y && column == x){
            tiles[y][x] = tiles[row][column];
            tiles[row][column] = new EmptyTile();
        }
        else if(row == y && column + 1 == x){
            tiles[y][x] = tiles[row][column];
            tiles[row][column] = new EmptyTile();
        }
        else if(row - 1 == y && column == x){
            tiles[y][x] = tiles[row][column];
            tiles[row][column] = new EmptyTile();
        }
        else if(row == y && column - 1 == x){
            tiles[y][x] = tiles[row][column];
            tiles[row][column] = new EmptyTile();
        }
     }


    public void swapTiles(int codeOfKey){
        setPossibleMoves();
        int y = findEmptyTileY();
        int x = findEmptyTileX();
        int possibleMoves = getModePossibleMoves();
        Tile helpVariable = tiles[y][x];

        switch (codeOfKey){
            case 37, 38, 39, 40, 65, 68, 87, 83:
                setNumberOfMoves(getNumberOfMoves() + 1);
                break;
        }

        if(possibleMoves == 1){
            if(codeOfKey == 37 || codeOfKey == 65){
                tiles[y][x] = tiles[y][x+1];
                tiles[y][x+1] = helpVariable;
            }
            else if(codeOfKey == 38 || codeOfKey == 87){
                tiles[y][x] = tiles[y+1][x];
                tiles[y+1][x] = helpVariable;
            }
        }
        else if(possibleMoves == 2){
            if(codeOfKey == 39 || codeOfKey == 68){
                tiles[y][x] = tiles[y][x-1];
                tiles[y][x-1] = helpVariable;
            }
            else if(codeOfKey == 38 || codeOfKey == 87){
                tiles[y][x] = tiles[y+1][x];
                tiles[y+1][x] = helpVariable;
            }
        }
        else if(possibleMoves == 3){
            if(codeOfKey == 37 || codeOfKey == 65){
                tiles[y][x] = tiles[y][x+1];
                tiles[y][x+1] = helpVariable;
            }
            else if(codeOfKey == 40 || codeOfKey == 83){
                tiles[y][x] = tiles[y-1][x];
                tiles[y-1][x] = helpVariable;
            }
        }
        else if(possibleMoves == 4){
            if(codeOfKey == 39 || codeOfKey == 68){
                tiles[y][x] = tiles[y][x-1];
                tiles[y][x-1] = helpVariable;
            }
            else if(codeOfKey == 40 || codeOfKey == 83){
                tiles[y][x] = tiles[y-1][x];
                tiles[y-1][x] = helpVariable;
            }
        }
        else if(possibleMoves == 5){
            if(codeOfKey == 37 || codeOfKey == 65){
                tiles[y][x] = tiles[y][x+1];
                tiles[y][x+1] = helpVariable;
            }
            else if(codeOfKey == 38 || codeOfKey == 87){
                tiles[y][x] = tiles[y+1][x];
                tiles[y+1][x] = helpVariable;
            }
            else if(codeOfKey == 39 || codeOfKey == 68){
                tiles[y][x] = tiles[y][x-1];
                tiles[y][x-1] = helpVariable;
            }
        }
        else if(possibleMoves == 6){
            if(codeOfKey == 37 || codeOfKey == 65){
                tiles[y][x] = tiles[y][x+1];
                tiles[y][x+1] = helpVariable;
            }
            else if(codeOfKey == 38 || codeOfKey == 87){
                tiles[y][x] = tiles[y+1][x];
                tiles[y+1][x] = helpVariable;
            }
            else if(codeOfKey == 40 || codeOfKey == 83){
                tiles[y][x] = tiles[y-1][x];
                tiles[y-1][x] = helpVariable;
            }
        }
        else if(possibleMoves == 7){
            if(codeOfKey == 39 || codeOfKey == 68){
                tiles[y][x] = tiles[y][x-1];
                tiles[y][x-1] = helpVariable;
            }
            else if(codeOfKey == 38 || codeOfKey == 87){
                tiles[y][x] = tiles[y+1][x];
                tiles[y+1][x] = helpVariable;
            }
            else if(codeOfKey == 40 || codeOfKey == 83){
                tiles[y][x] = tiles[y-1][x];
                tiles[y-1][x] = helpVariable;
            }
        }
        else if(possibleMoves == 8){
            if(codeOfKey == 37 || codeOfKey == 65){
                tiles[y][x] = tiles[y][x+1];
                tiles[y][x+1] = helpVariable;
            }
            else if(codeOfKey == 39 || codeOfKey == 68){
                tiles[y][x] = tiles[y][x-1];
                tiles[y][x-1] = helpVariable;
            }
            else if(codeOfKey == 40 || codeOfKey == 83) {
                tiles[y][x] = tiles[y - 1][x];
                tiles[y - 1][x] = helpVariable;
            }
        }
        else if(possibleMoves == 9){
            if(codeOfKey == 37 || codeOfKey == 65){
                tiles[y][x] = tiles[y][x+1];
                tiles[y][x+1] = helpVariable;
            }
            else if(codeOfKey == 38 || codeOfKey == 87){
                tiles[y][x] = tiles[y+1][x];
                tiles[y+1][x] = helpVariable;
            }
            else if(codeOfKey == 39 || codeOfKey == 68){
                tiles[y][x] = tiles[y][x-1];
                tiles[y][x-1] = helpVariable;
            }
            else if(codeOfKey == 40 || codeOfKey == 83){
                tiles[y][x] = tiles[y-1][x];
                tiles[y-1][x] = helpVariable;
            }
        }
    }

    public boolean winControl(){
        int indexOfNumbers = 1;

        for(int row = 0; row < rowCount; row++) {
            for(int column = 0; column < columnCount; column++){
                if(indexOfNumbers <= 15) {
                    if(tiles[row][column] instanceof EmptyTile){
                        return false;
                    }
                    else if(tiles[row][column] instanceof GameStone) {
                        if (((GameStone) tiles[row][column]).getNumber() == indexOfNumbers) {
                            indexOfNumbers++;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void printTiles(){
        System.out.println();
        for(int column = 0; column < columnCount; column++) {
            for (int row = 0; row < rowCount; row++) {
                if (tiles[column][row] instanceof GameStone) {
                    if (((GameStone) tiles[column][row]).getNumber() > 9) {
                        System.out.print(tiles[column][row] + "  ");
                    } else {
                        System.out.print(tiles[column][row] + "   ");
                    }
                } else
                    System.out.print(tiles[column][row] + "   ");
            }
            System.out.println();
        }
    }

    public void fillNoRandom(){
        int indexOfNumbers = 1;

        for(int row = 0; row < rowCount; row++)
            for(int column = 0; column < columnCount; column++, indexOfNumbers++){
                {
                    if(column == columnCount - 1 && row == rowCount - 1){
                        tiles[row][column] = new EmptyTile();
                    }
                    else
                        tiles[row][column] = new GameStone(indexOfNumbers);
                }
            }
        tiles[3][3] = new GameStone(15);
        tiles[3][2] = new EmptyTile();
    }

    public int computeScore(){
        if(this.state == sk.tuke.gamestudio.game.fifteenpuzzle.core.FieldState.SOLVED){
            final long rawScore =
                    rowCount*columnCount*10 - (System.currentTimeMillis() - startTimeInMs)/1000;

            if(rawScore <= 0){
                return 0;
            }else
                return (int) rawScore;
        }else{
            return 0;
        }
    }

    public Tile getTile(int row, int column){
        return tiles[row][column];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setState(FieldState state) {
        this.state = state;
    }
    public FieldState getState() {
        return state;
    }

    public int getModePossibleMoves() {
        return modeOfPossibleMoves;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public long getTotalTimeMinutes() {
        return totalTimeMinutes;
    }

    public void setTotalTimeMinutes(long totalTimeMinutes) {
        this.totalTimeMinutes = totalTimeMinutes;
    }

    public long getTotalTimeSeconds() {
        return totalTimeSeconds;
    }

    public void setTotalTimeSeconds(long totalTimeSeconds) {
        this.totalTimeSeconds = totalTimeSeconds;
    }
}
