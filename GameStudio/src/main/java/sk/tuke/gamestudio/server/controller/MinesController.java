package sk.tuke.gamestudio.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.game.minesweeper.core.*;
import sk.tuke.gamestudio.service.CommentService;
import sk.tuke.gamestudio.service.RatingService;
import sk.tuke.gamestudio.service.ScoreService;

import java.awt.*;
import java.util.Date;

@Controller
@RequestMapping("/mines")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class MinesController {

    private Field mineField = null;
//    private Field mineField = new Field(9, 9, 3);
    @Autowired
    private UserController userController;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RatingService ratingService;
    private boolean isPlaying = true;
    private boolean marking = false;
    @RequestMapping
    public String processUserInput(@RequestParam(required = false) Integer row,
                                   @RequestParam(required = false) Integer column,
                                   Model model){
        startOrUpdateGame(row, column);
        prepareModel(model);
        return("mines");
    }

    @RequestMapping("/mark")
    public String changeMode(Model model){
       changeGameMode();
       prepareModel(model);
       return ("mines");
    }

    @RequestMapping("/new")
    public String newGame(Model model){
        startNewGame();
        prepareModel(model);
        return ("mines");
    }
//Vyuzitie generovania JSONU v projekte!!!
    @RequestMapping(value ="/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Field processUserInputJson(@RequestParam(required = false) Integer row,
                                      @RequestParam(required = false) Integer column){
        startOrUpdateGame(row, column);
        mineField.setMarking(marking);
        return mineField;
    }

    @RequestMapping(value = "/jsonmark", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Field changeModeJson(){
        changeGameMode();
        mineField.setMarking(marking);
        return mineField;
    }
    @RequestMapping(value = "/jsonnew", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Field newGameJson(){
        startNewGame();
        mineField.setMarking(marking);
        return mineField;
    };



    private void changeGameMode(){
        if(mineField.getState() == FieldState.PLAYING){
            marking = !marking;
        }
    }

    private void startNewGame(){
        marking = false;
        mineField = new Field(9,9,3);
        isPlaying = true;
    }

    private void startOrUpdateGame(Integer row, Integer column) {
        if(mineField == null){
            startNewGame();
        }
        if(row != null && column != null){
            if(mineField.getState() == FieldState.PLAYING){
                if(marking) {
                    mineField.markTile(row.intValue(), column.intValue());
                } else {
                    mineField.openTile(row.intValue(), column.intValue());
                }
            }
        }

        if(mineField.getState() != FieldState.PLAYING && isPlaying){
            isPlaying = false;

            if(userController.isLogged() && mineField.getState() == FieldState.SOLVED){
                Score score = new Score("mines", userController.getLoggedUser(), mineField.getScore(), new Date());
                try {
                    scoreService.addScore(score);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void prepareModel(Model model) {
        model.addAttribute("marking", marking);
        model.addAttribute("gameStatus", getGameStatusMessage());
        model.addAttribute("mineFieldTiles", mineField.getTiles());
        model.addAttribute("isPlaying",mineField.getState() == FieldState.PLAYING);
        model.addAttribute("bestScores", scoreService.getBestScores("Mines"));
        model.addAttribute("avgRating", ratingService.getAverageRating("Mines"));
    }

    public String getHtmlField(){
        StringBuilder sb = new StringBuilder();

        sb.append("<table class='minefield'> \n");

        int rowCount = mineField.getRowCount();
        int columnCount = mineField.getColumnCount();

        for(int row = 0; row < rowCount; row++){
            sb.append("<tr>");
            for(int column = 0; column < columnCount; column++){
                Tile tile = mineField.getTile(row, column);
                sb.append("<td class='"+getTileClass(tile)+"'>");

                if(tile.getState() != TileState.OPEN && mineField.getState() == FieldState.PLAYING){
                    sb.append("<a href='/mines?row="+row+"&column="+column+"'>");
                }

                sb.append("<span>" + getTileText(tile) + "</span>");

                if(tile.getState() != TileState.OPEN && mineField.getState() == FieldState.PLAYING){
                    sb.append("</a>");
                }

                sb.append("</td>\n");
            }
            sb.append("</tr> \n");
        }
        sb.append("</table> \n");
        return sb.toString();
    }

    public String getTileClass(Tile tile){
        switch (tile.getState()) {
            case OPEN:
                if(tile instanceof Clue)
                    return "open" + ((Clue) tile).getValue();
                else
                    return "mine";
            case CLOSED:
                return "closed";
            case MARKED:
                return "marked";
            default:
                throw new RuntimeException("Unexpected tile state");
        }
    }

    public String getTileText(Tile tile){
        switch (tile.getState()){
            case CLOSED:
                return "-";
            case MARKED:
                return "M";
            case OPEN:
                if(tile instanceof Clue){
                    return String.valueOf(((Clue) tile).getValue());
                } else {
                    return "X";
                }
            default:
                throw new IllegalArgumentException("Unsupported tile state " + tile.getState());
        }
    }

    public String getGameStatusMessage(){
        String gameStatus = "";
        FieldState gameState = mineField.getState();
        if(gameState == FieldState.FAILED){
            gameStatus = "You failed";
        }else if(gameState == FieldState.SOLVED){
            gameStatus = "You won (score " + mineField.getScore()+")";
        }else {
            gameStatus = "Playing - ";
            if(marking){
                gameStatus += "marking";
            }else{
                gameStatus += "opening";
            }
        }

        return gameStatus;
    }

    public int averageRating() {
        return this.ratingService.getAverageRating("mines");
    }

    public boolean isMarking() {
        return marking;
    }
}



/*     @RequestMapping("/mark")
    public String changeMode(){
        marking = !marking;
        return ("mines");
    } */

/*    @RequestMapping("/new")
    public String newGame(){
        marking = false;
        mineField = new Field(9, 9, 3);
        return ("mines");
    }*/


   /*  if(row != null && column != null){
            if(mineField.getState() == FieldState.PLAYING) {
                if (marking) {
                    mineField.markTile(row.intValue(), column.intValue());
                } else
                    mineField.openTile(row.intValue(), column.intValue());
            }
        }*/
