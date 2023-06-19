package sk.tuke.gamestudio.game.fifteenpuzzle.core;

public class GameStone extends Tile {
    private final int number;

    public GameStone(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
