package sk.tuke.gamestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.entity.Player;

public class PlayerServiceREST implements PlayerService{

    private final String url = "http://localhost:8080/api";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Player getPlayerByUserName(String uName) {
//        List<Player> players = Arrays.asList(restTemplate.getForEntity(url + "/player/" + userName, Player.class).getBody());
//        if(players.size() > 0)
//            return players.get(0);
//        else
//            return null;
        Player player = restTemplate.getForEntity(url + "/player/" + uName, Player.class).getBody();
        return player;

    }

    @Override
    public void addPlayer(Player player) {
        restTemplate.postForEntity(url + "/player", player, Player.class);
    }
}


