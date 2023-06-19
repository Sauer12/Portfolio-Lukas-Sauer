package sk.lukas.sauer;

import sk.lukas.sauer.people.Player;

public class Main {
	
	public static void main(String[] args) {
		Player player = new Player("Player", 35);
		player.doskok();
		player.obrana();
	}
}
