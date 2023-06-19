package sk.tuke.gamestudio.server.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.gamestudio.game.tictactoe.core.Field;
import sk.tuke.gamestudio.game.tictactoe.core.FieldState;
import sk.tuke.gamestudio.game.tictactoe.core.Stone;
import sk.tuke.gamestudio.game.tictactoe.core.StoneState;

@Controller
@RequestMapping("/tictactoe")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class TicTacToeController {

    private Field ticTacToeField = new Field(9,9);

    @RequestMapping
    public String processUserInput(@RequestParam(required = false) Integer row,
                                   @RequestParam(required = false) Integer column){
        if((row != null && column != null) && (ticTacToeField.getState() == FieldState.PLAYING)){
            ticTacToeField.setStone(row, column, true);
            ticTacToeField.computerSetStone(false);
        }
        return ("tictactoe");
    }

    public String getHtmlField(){
        StringBuilder sb = new StringBuilder();

        sb.append("<table class='minefield'> \n");

        int rowCount = ticTacToeField.getRowCount();
        int columnCount = ticTacToeField.getColumnCount();

        for(int row = 0; row < rowCount; row++){
            sb.append("<tr>");
            for(int column = 0; column < columnCount; column++){
                Stone stone = ticTacToeField.getStone(row, column);
                sb.append("<td>");

                sb.append("<a href='/tictactoe?row=" + row + "&column=" + column + "'>");

                sb.append("<span>" + stone.toString() + "</span>");

                sb.append("</a>");

                sb.append("</td>\n");
            }
            sb.append("</tr> \n");
        }
        sb.append("</table> \n");
        return sb.toString();
    }

    @RequestMapping("/new")
    public String newGame(){
        ticTacToeField = new Field(9, 9);
        return ("tictactoe");
    }

    public String getGameStatusMessage(){
        String gameStatus = "";
        FieldState gameState = ticTacToeField.getState();
        if(gameState == FieldState.OWIN){
            gameStatus = "O player win!";
        }else if(gameState == FieldState.XWIN){
            gameStatus = "X player win!";
        }else {
            gameStatus = "Playing";
        }

        return gameStatus;
    }
}
