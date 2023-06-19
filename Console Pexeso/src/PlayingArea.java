import java.util.Random;

public class PlayingArea {
    private int rows;
    private int columns;
    private Card[][] cards;
    private boolean isFinish;
    private String cardsTypes;

    public PlayingArea() {
        this(7, 7, "ABCDEFGHIJKLMNOPQRSTVUVWXYZ");
    }

    public PlayingArea(int rows, int columns) {
        this(rows, columns, "ABCDEFGHIJKLMNOPQRSTVUVWXYZ");
    }

    public PlayingArea(int rows, int columns, String cardsTypes) {
        this.rows = rows;
        this.columns = columns;
        this.cardsTypes = cardsTypes;
        cards = new Card[rows][columns];
        isFinish = false;
    }
//    CREATING GAME AREA AND CARDS
    private void createEmptyCards(){
        for(int i = 0; i < cards.length; i++){
            for(int j = 0; j < cards[i].length; j++){
                cards[i][j] = new Card("", i, j);
            }
        }
    }
    public void createCardsWithTypes(){
        createEmptyCards();
        for(int i = 0; i < cards.length; i++){
            for(int j = 0; j < cards[i].length; j++){
                cards[i][j] = new Card(createCardType(), i, j);
            }
        }
    }
    private String createCardType(){
        Random random = new Random();

        while(true) {
            String type = String.valueOf(cardsTypes.charAt(random.nextInt(cardsTypes.length())));
            int counter = 0;
            boolean typeExist = false;

            for (Card[] i : cards) {
                var j = i;
                for (Card card : j) {
                    if (type.equals(card.toString())) {
                        counter++;
                    }
                    if (counter == 2) {
                        typeExist = true;
                    }
                }
            }

            if (!typeExist) {
                return type;
            }
        }
    }
    public void checkGame(){
        isFinish = true;
        for(Card[] i : cards){
            var j = i;
            for(Card card : j){
                if(!card.isGuessed()){
                    isFinish = false;
                }
            }
        }
    }
    public void displayArea(){
        System.out.println("\n".repeat(15));
        for(Card[] i : cards){
            var j = i;
            for (Card card : j){
                if(card.isOpen()) {
                    System.out.print(card + " ");
                }
                else{
                    System.out.print("█" + " ");
                }
            }
            System.out.println();
        }
    }

//    INPUT LOGIC
    public void moveOpen(int x, int y){
        cards[x][y].setOpen(true);
    }

    public void moveClose(int x, int y){
        cards[x][y].setOpen(false);
    }

    public boolean checkCardsEqual(int x1, int y1, int x2, int y2){
        if(cards[x1][y1].getType().equals(cards[x2][y2].getType())){
            cards[x1][y1].setGuessed(true);
            cards[x2][y2].setGuessed(true);
            return true;
        }
        return false;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isFinish() {
        return isFinish;
    }
}
