package kniznica;

import java.awt.Window.Type;

public class GenerickeMedium<T extends Medium>{	
	
	private T medium;
	
	public GenerickeMedium(T medium) {
		this.medium = medium;
	}
	
	@Override
	public String toString() {
		return medium.toString();
	}
}
