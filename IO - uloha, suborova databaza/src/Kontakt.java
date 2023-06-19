
public class Kontakt {

	private String meno;
	private String telefon;
	private String mobil;
	private String email;
	
	public Kontakt(String meno, String telefon) {
		this.meno = meno;
		if(telefon.startsWith("09")) {
			this.mobil = telefon;
			this.telefon = "";
		} else {
			this.telefon = telefon;
			this.mobil = "";
		}
		this.email = "";
	}
	
	public Kontakt(String meno, String telefon, String mobil) {
		this.meno = meno;
		this.telefon = telefon;
		if(mobil.contains("@")) {
			this.email = mobil;
			this.mobil = "";
		} else {
			this.mobil = mobil;
			this.email = "";
		}
	}
	
	public Kontakt(String meno, String telefon, String mobil, String email) {
		this.meno = meno;
		this.telefon = telefon;
		this.mobil = mobil;
		this.email = email;
	}	
	
	public String getMeno() {
		return meno;
	}

	public String getTelefon() {
		return telefon;
	}

	public String getMobil() {
		return mobil;
	}

	public String getEmail() {
		return email;
	}
	
}
