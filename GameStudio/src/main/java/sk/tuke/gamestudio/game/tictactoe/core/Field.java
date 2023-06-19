package sk.tuke.gamestudio.game.tictactoe.core;

import java.util.Random;

public class Field {

    private final int rowCount;
    private final int columnCount;
    private final Stone[][] stones;
    private FieldState state = FieldState.PLAYING;

    private int score = 0;
    private long startTimeInMs = 0;


    public Field(int rowCount, int columnCount){
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        stones = new Stone[rowCount][columnCount];
        generate();
        startTimeInMs = System.currentTimeMillis();
    }

    private void generate(){
        generateStones();
    }

    private void generateStones() {
        for(int row = 0; row < rowCount; row++){
            for(int column = 0; column < columnCount; column++){
                stones[row][column] = new Stone();
            }
        }
    }

    public void setStone(int row, int column, boolean xStone){
        if(xStone){
            stones[row][column].setStoneState(StoneState.X);
        }
        else{
            stones[row][column].setStoneState(StoneState.O);
        }
        winControl();
    }

    private void winControl(){
        horizontalWinControl();
        verticalWinControl();
        diagonalWinControl();
    }

    private void horizontalWinControl(){
        int sequenceX = 0;
        int sequenceO = 0;
        for(int row = 0; row < rowCount; row++){
            for(int column = 0; column < columnCount; column++){
                if(getStone(row, column).getStoneState() == StoneState.X){
                    sequenceX++;
                    sequenceO = 0;
                }
                else if(getStone(row, column).getStoneState() == StoneState.O){
                    sequenceO++;
                    sequenceX = 0;
                }
                else {
                    sequenceX = 0;
                    sequenceO = 0;
                }

                if(sequenceX >= 5)
                    state = FieldState.XWIN;
                else if(sequenceO >= 5)
                    state = FieldState.OWIN;
            }
            sequenceX = 0;
            sequenceO =0;
        }
    }

    private void verticalWinControl(){
        int sequenceX = 0;
        int sequenceO = 0;
        for(int column = 0; column < columnCount; column++){
            for(int row = 0; row < rowCount; row++){
                if(getStone(row, column).getStoneState() == StoneState.X){
                    sequenceX++;
                    sequenceO = 0;
                }
                else if(getStone(row, column).getStoneState() == StoneState.O){
                    sequenceO++;
                    sequenceX = 0;
                }
                else {
                    sequenceX = 0;
                    sequenceO = 0;
                }

                if(sequenceX >= 5)
                    state = FieldState.XWIN;
                else if(sequenceO >= 5)
                    state = FieldState.OWIN;
            }
            sequenceX = 0;
            sequenceO = 0;
        }
    }

    private void diagonalWinControl(){
        int sequenceX = 0;
        int sequenceO = 0;
        int directionX = columnCount - 5;
        int directionY = rowCount - 5;

        //zlava doprava, lavy horny roh
        for(int start = 0; start <= directionX; start++){
            for(int diagonalLength = 0, x = start, y = 0; diagonalLength < columnCount - start; diagonalLength++, x++, y++){
                if(getStone(y, x).getStoneState() == StoneState.X){
                    sequenceX++;
                    sequenceO = 0;
                }
                else if(getStone(y, x).getStoneState() == StoneState.O){
                    sequenceO++;
                    sequenceX = 0;
                }
                else{
                    sequenceX = 0;
                    sequenceO = 0;
                }
                if(sequenceX >= 5)
                    state = FieldState.XWIN;
                else if(sequenceO >= 5)
                    state = FieldState.OWIN;
            }

            sequenceX = 0;
            sequenceO = 0;
        }

        for(int start = 0; start <= directionY; start++){
            for(int diagonalLength = 0, y = start, x = 0; diagonalLength < columnCount - start; diagonalLength++, x++, y++){
                if(getStone(y, x).getStoneState() == StoneState.X){
                    sequenceX++;
                    sequenceO = 0;
                }
                else if(getStone(y, x).getStoneState() == StoneState.O){
                    sequenceO++;
                    sequenceX = 0;
                }
                else{
                    sequenceX = 0;
                    sequenceO = 0;
                }
                if(sequenceX >= 5)
                    state = FieldState.XWIN;
                else if(sequenceO >= 5)
                    state = FieldState.OWIN;
            }

            sequenceX = 0;
            sequenceO = 0;
        }

        for(int start = 8, diagonalSize = 0; start >= directionX; start--, diagonalSize++){
            for(int diagonalLength = 0, x = start, y = 0; diagonalLength < columnCount - diagonalSize; diagonalLength++, x--, y++){
                if(getStone(y, x).getStoneState() == StoneState.X){
                    sequenceX++;
                    sequenceO = 0;
                }
                else if(getStone(y, x).getStoneState() == StoneState.O){
                    sequenceO++;
                    sequenceX = 0;
                }
                else{
                    sequenceX = 0;
                    sequenceO = 0;
                }
                if(sequenceX >= 5)
                    state = FieldState.XWIN;
                else if(sequenceO >= 5)
                    state = FieldState.OWIN;
            }

            sequenceX = 0;
            sequenceO = 0;
        }

        for(int start = 8, diagonalSize = 0; start >= directionX; start--, diagonalSize++){
            for(int diagonalLength = 0, x = columnCount - 1, y = diagonalSize; diagonalLength < columnCount - diagonalSize; diagonalLength++, x--, y++){
                if(getStone(y, x).getStoneState() == StoneState.X){
                    sequenceX++;
                    sequenceO = 0;
                }
                else if(getStone(y, x).getStoneState() == StoneState.O){
                    sequenceO++;
                    sequenceX = 0;
                }
                else{
                    sequenceX = 0;
                    sequenceO = 0;
                }
                if(sequenceX >= 5)
                    state = FieldState.XWIN;
                else if(sequenceO >= 5)
                    state = FieldState.OWIN;
            }

            sequenceX = 0;
            sequenceO = 0;
        }
    }

    public void computerSetStone(boolean xStone){
        Random random = new Random();
        boolean isEmpty = false;
        do {
            int row = random.nextInt(9);
            int column = random.nextInt(9);
            if (stones[row][column].getStoneState() == StoneState.EMPTY) {
                setStone(row, column, xStone);
                isEmpty = true;
            }
        }while(!isEmpty);
    }

    public int computeScore(){
        if(this.state == FieldState.OWIN || this.state == FieldState.XWIN){
            final long rawScore =
                    rowCount*columnCount*10 - (System.currentTimeMillis() - startTimeInMs)/1000;

            if(rawScore <= 0){
                return 0;
            }else {
                score = (int) rawScore;
                return (int) rawScore;
            }
        }else{
            return 0;
        }
    }

    public FieldState getState() {
        return state;
    }

    public Stone getStone(int row, int column){
        return stones[row][column];
    }

    public Stone[][] getStones(){
        return stones;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getScore() {
        return score;
    }
}
