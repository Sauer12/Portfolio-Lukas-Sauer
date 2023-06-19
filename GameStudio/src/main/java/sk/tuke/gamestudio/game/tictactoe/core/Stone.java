package sk.tuke.gamestudio.game.tictactoe.core;

public class Stone {
    StoneState stoneState = StoneState.EMPTY;

    public StoneState getStoneState() {
        return stoneState;
    }

    public void setStoneState(StoneState stoneState) {
        this.stoneState = stoneState;
    }

    @Override
    public String toString() {
        if(stoneState == StoneState.EMPTY)
            return " - ";
        else
            return String.valueOf(stoneState);
    }
}
