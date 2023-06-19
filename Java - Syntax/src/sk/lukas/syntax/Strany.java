package sk.lukas.syntax;

public enum Strany {
	NORTH("N", "Sever", "S"), 
	EAST("E", "Vychod", "V"), 
	WEST("W", "Zapad", "Z"), 
	SOUTH("S", "JUH", "J");
	
	
	public String shortcutEN;
	public String stranaSK;
	public String skratkaSK;
	
	Strany(String shortcutEN, String stranaSK, String skratkaSK) {
		this.shortcutEN = shortcutEN;
		this.stranaSK = stranaSK;
		this.skratkaSK = skratkaSK;
	}
}
