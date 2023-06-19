package sk.tuke.gamestudio.server.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.gamestudio.game.fifteenpuzzle.core.Field;
import sk.tuke.gamestudio.game.fifteenpuzzle.core.Tile;

@Controller
@RequestMapping("/puzzles")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class PuzzleController {

    private Field puzzleField = new Field(4, 4);

    @RequestMapping
    public String processUserInput(@RequestParam(required = false) Integer row,
                                   @RequestParam(required = false) Integer column){
        if(row != null && column != null){
            puzzleField.swapTilesWeb(row, column);
        }
        return ("puzzles");
    }

    public String getHtmlField(){
        StringBuilder sb = new StringBuilder();

        sb.append("<table class='minefield'> \n");

        int rowCount = puzzleField.getRowCount();
        int columnCount = puzzleField.getColumnCount();

        for(int row = 0; row < rowCount; row++){
            sb.append("<tr>");
            for(int column = 0; column < columnCount; column++){
                Tile tile = puzzleField.getTile(row, column);
                sb.append("<td>");

                sb.append("<a href='/puzzles?row="+row+"&column="+column+"'>");

                sb.append("<span>" + tile.toString() + "</span>");

                sb.append("</a>");

                sb.append("</td>\n");
            }
            sb.append("</tr> \n");
        }
        sb.append("</table> \n");
        return sb.toString();
    }




}
