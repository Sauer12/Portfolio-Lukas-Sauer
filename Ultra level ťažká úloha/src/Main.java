public class Main {
	
	public static void main(String[] args) {
		
		char[][] map = new char[5][5];
		map[0] = new char[]{'O', 'X', 'X', 'O', 'O'};
		map[1] = new char[]{'X', 'X', 'X', 'O', 'O'};
		map[2] = new char[]{'O', 'O', 'O', 'X', 'X'};
		map[3] = new char[]{'O', 'O', 'X', 'X', 'X'};
		map[4] = new char[]{'O', 'O', 'O', 'O', 'O'};

		char[][] house = new char[2][2];
		house[0] = new char[]{'H','H'};
		house[1] = new char[]{'H','-'};
		
		postavDom(map, house);
	}
	
	
	public static void postavDom(char[][] map, char[][] house) {
		
		String domy = "";
		
		for(int i = 0; i < map[0].length; i++) {
			for(int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
				if(map[i][j] == 'X') {
					if(j+1 < map[i].length && map[i][j + 1] == 'X') {
						if(i+1 < map.length && map[i+1][j] == 'X') {
							if(map[i+1][j+1] == 'X') {
								domy+= "H{" + i + ", " + j + "}; ";
							}
						}
					}
				}
			}
			System.out.println();			
		}
		
		System.out.println("Domy mozu byt na tychto poziciach: " + domy);		
	}
	
}
