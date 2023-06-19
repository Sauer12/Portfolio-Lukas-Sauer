package sk.lukassauer;

public class BookingAgent {
    public static void main(String[] args) {
        int rows = 10;
        int totalSeats = 100;
        Theatre x = new Theatre("Theater X", rows, totalSeats);

        x.printSeatMap();

        bookSeat(x, 'A', 1);
        bookSeat(x, 'A', 2);
        bookSeat(x, 'B', 1);

        bookSeats(x, 4,'B', 3, 10);
        bookSeats(x, 5, 'C', 4, 8);
    }

    private static void bookSeat(Theatre theatre, char row, int seatNo){
        String seat = theatre.reserveSeat(row, seatNo);
        if(seat != null){
            System.out.println("Congratulations! Your reserved seat is " + seat);
            theatre.printSeatMap();
        } else{
            System.out.println("Sorry! Unable to reserver " + row + seatNo);
        }
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat){
        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, char maxRow, int minSeat, int maxSeat){
        var seats = theatre.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
        if(seats != null){
            System.out.println("Congratulations! Your reserved seats are " + seats);
            theatre.printSeatMap();
        } else{
            System.out.println("Sorry! No matching contiguous seats in rows: "  + minRow + " - " + maxRow);
        }
    }


}