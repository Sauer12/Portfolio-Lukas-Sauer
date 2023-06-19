package sk.tuke.gamestudio.game.lightsout.core;

import java.util.Random;

public class Field {
    private int numberOfMoves;
    private long totalTimeMinutes;
    private long totalTimeSeconds;
    private final int rowCount;
    private final int columnCount;
    private FieldState state = FieldState.PLAYING;
    private final Light[][] tiles;

    private long startTimeInMs = 0;

    public Field(int rowCount, int columnCount){
        numberOfMoves = 0;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        tiles = new Light[rowCount][columnCount];
        generateNoRandom();
        startTimeInMs = System.currentTimeMillis();
    }

    private void generate(){
        Random random = new Random();

        for(int row = 0; row < getRowCount(); row++){
            for(int column = 0; column < getColumnCount(); column++){
                int tileState = random.nextInt(2);
                if(tileState == 0)
                    tiles[row][column] = new Light(LightState.LIGHTOFF);
                else
                    tiles[row][column] = new Light(LightState.LIGHTON);
            }
        }
    }

    private void generateNoRandom(){
        for(int row = 0; row < getRowCount(); row++){
            for(int column = 0; column < getColumnCount(); column++){
                tiles[row][column] = new Light(LightState.LIGHTOFF);
            }
        }
        tiles[4][4].setState(LightState.LIGHTON);
        tiles[4][3].setState(LightState.LIGHTON);
        tiles[3][4].setState(LightState.LIGHTON);
    }

    public boolean winControl(){
        for(int row = 0; row < getRowCount(); row++){
            for(int column = 0; column < getColumnCount(); column++) {
                if(tiles[row][column].getState() == LightState.LIGHTON)
                    return false;
            }
        }
        state = FieldState.SOLVED;
        return true;
    }

    public void changeTiles(int row, int column){
        int stateOfGame = findStateOfGame(row, column);
        turnOffOrTurnOn(row, column);
        if(stateOfGame == 1){
            turnOffOrTurnOn(row + 1, column);
            turnOffOrTurnOn(row, column + 1);
        }
        else if(stateOfGame == 2){
            turnOffOrTurnOn(row + 1, column);
            turnOffOrTurnOn(row, column -1);
        }
        else if(stateOfGame == 3){
            turnOffOrTurnOn(row -1, column);
            turnOffOrTurnOn(row, column - 1);
        }
        else if(stateOfGame == 4){
            turnOffOrTurnOn(row -1, column);
            turnOffOrTurnOn(row, column + 1);
        }
        else if(stateOfGame == 5){
            turnOffOrTurnOn(row + 1, column);
            turnOffOrTurnOn(row, column - 1);
            turnOffOrTurnOn(row, column + 1);
        }
        else if(stateOfGame == 6){
            turnOffOrTurnOn(row + 1, column);
            turnOffOrTurnOn(row - 1, column);
            turnOffOrTurnOn(row, column - 1);
        }
        else if(stateOfGame == 7){
            turnOffOrTurnOn(row - 1, column);
            turnOffOrTurnOn(row, column - 1);
            turnOffOrTurnOn(row, column + 1);
        }
        else if(stateOfGame == 8){
            turnOffOrTurnOn(row + 1, column);
            turnOffOrTurnOn(row - 1, column);
            turnOffOrTurnOn(row, column + 1);
        }
        else{
            turnOffOrTurnOn(row + 1, column);
            turnOffOrTurnOn(row - 1, column);
            turnOffOrTurnOn(row, column + 1);
            turnOffOrTurnOn(row, column - 1);
        }
    }


//  Hra ma 9 roznych moznosti kliknutia - Polia[riadok, stlpec]: [0,0] = MOD 1, [0,5] = MOD 2, [5,5] = MOD 3, [5, 0] = MOD 4,
// [0, stlpec > 0 || < 4] = MOD 5 atd.. spolu je 9 moznosti.
    private int findStateOfGame(int row, int column){
        if (column - 1 < 0) {
            if (row - 1 < 0)
                return 1;
            else if (row + 1 >= getRowCount())
                return 4;
            else
                return 8;
        }
        else if (column + 1 >= getColumnCount()) {
            if (row - 1 < 0)
                return 2;
            else if (row + 1 >= getRowCount())
                return 3;
            else
                return 6;
        }
        else {
            if(row == 0)
                return 5;
            if (row + 1 >= getRowCount())
                return 7;
            else
                return 9;
        }
    }

    private void turnOffOrTurnOn(int row, int column) {
        if(tiles[row][column].getState() == LightState.LIGHTOFF)
            tiles[row][column].setState(LightState.LIGHTON);
        else
            tiles[row][column].setState(LightState.LIGHTOFF);
    }

    public int computeScore(){
        if(this.state == sk.tuke.gamestudio.game.lightsout.core.FieldState.SOLVED){
            final long rawScore =
                    rowCount * columnCount * 10 - (System.currentTimeMillis() - startTimeInMs) / 1000;
            if(rawScore <= 0){
                return 0;
            }else
                return (int) rawScore;
        }else{
            return 0;
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public Light getTile(int row, int column) {
        return tiles[row][column];
    }

    public FieldState getState() {
        return state;
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
