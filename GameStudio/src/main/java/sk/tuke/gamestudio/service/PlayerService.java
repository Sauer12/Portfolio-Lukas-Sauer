package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Player;

public interface PlayerService {
    public Player getPlayerByUserName(String userName);

    public void addPlayer(Player player);
}
