public class Card {
    private String type;
    private boolean isGuessed;
    private boolean isOpen;
    private int positionX;
    private int positionY;

    public Card(String type, int positionX, int positionY) {
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;
        isGuessed = false;
        isOpen = false;
    }

    public String getType() {
        return type;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setGuessed(boolean guessed) {
        isGuessed = guessed;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return type;
    }
}
