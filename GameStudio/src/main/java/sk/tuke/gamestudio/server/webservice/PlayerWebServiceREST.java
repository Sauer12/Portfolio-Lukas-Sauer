package sk.tuke.gamestudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Player;
import sk.tuke.gamestudio.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerWebServiceREST {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{uName}")
    Player getPlayerByUserName(@PathVariable String uName) {
        return playerService.getPlayerByUserName(uName);
    }

    @PostMapping
    void addPlayer(@RequestBody Player player){
        playerService.addPlayer(player);
    }
}

