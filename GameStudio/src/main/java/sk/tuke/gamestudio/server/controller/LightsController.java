package sk.tuke.gamestudio.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.gamestudio.game.fifteenpuzzle.core.Tile;
import sk.tuke.gamestudio.game.lightsout.core.Field;
import sk.tuke.gamestudio.game.lightsout.core.Light;
import sk.tuke.gamestudio.game.lightsout.core.LightState;
import sk.tuke.gamestudio.service.CommentService;
import sk.tuke.gamestudio.service.RatingService;
import sk.tuke.gamestudio.service.ScoreService;

@Controller
@RequestMapping("/lights")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class LightsController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RatingService ratingService;
    private Field lightsField = new Field(5, 5);

    @RequestMapping
    public String processUserInput(@RequestParam(required = false) Integer row,
                                   @RequestParam(required = false) Integer column){
        if(row != null && column != null){
            lightsField.changeTiles(row, column);
        }
        return ("lights");
    }

    public String getHtmlField() {
        StringBuilder sb = new StringBuilder();

        sb.append("<table class='minefield'> \n");

        int rowCount = lightsField.getRowCount();
        int columnCount = lightsField.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            sb.append("<tr>");
            for (int column = 0; column < columnCount; column++) {
                Light light = lightsField.getTile(row, column);
                sb.append("<td>");

                sb.append("<a href='/lights?row=" + row + "&column=" + column + "'>");

                if(lightsField.getTile(row, column).getState() == LightState.LIGHTOFF){
                    sb.append("<span>" + " X " + "</span>");
                }
                else
                    sb.append("<span>" + " O " + "</span>");

                sb.append("</a>");

                sb.append("</td>\n");
            }
            sb.append("</tr> \n");
        }
        sb.append("</table> \n");
        return sb.toString();
    }

    public int averageRating() {
        return this.ratingService.getAverageRating("mines");
    }
}
