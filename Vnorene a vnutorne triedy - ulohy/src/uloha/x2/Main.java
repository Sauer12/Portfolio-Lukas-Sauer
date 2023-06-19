package uloha.x2;

public class Main {

	public static void main(String[] args) {
		Hrdina hrdina = new Hrdina();
		hrdina.pouziSchopnost(new ISchopnosti() {
			@Override
			public void pouziSchopnost() {
				System.out.println("Pouzil som schopnost ohniva gula");
			}

			@Override
			public void zastavSchopnost() {
				System.out.println("Zastavil som schopnost ohniva gula");				
			}		
		});
	}
	

}
