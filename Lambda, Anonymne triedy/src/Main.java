import java.util.function.BiConsumer;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.vypisNieco(new VypisNaKonzolu());
		
		main.vypisNieco(new IVypisNaKonzolu() {
			@Override
			public void vypisNaSystemOut() {
				System.out.println("VypisNaKonzolu.vypisNaSystemOut");
			}

			@Override
			public void vypisNaSystemErr() {
				System.out.println("VypisNaKonzolu.vypisNaSystemErr");
				
			}			
		});

	}
	
	public void vypisNieco(IVypisNaKonzolu vypisNaKonzolu) {
		vypisNaKonzolu.vypisNaSystemOut();
		vypisNaKonzolu.vypisNaSystemErr();
	}
	
	public static void sumIt(int a, int b, BiConsumer<Integer, Integer> biConsumer) {
		biConsumer.accept(a, b);
	}

}
