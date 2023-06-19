package fiktivnyProgram;

import dbaccess.SormManager;
import fiktivnyProgram.entity.Osoba;

public class Main {

	public static void main(String[] args) {
		SormManager manager = new SormManager();
		Osoba osoba = manager.getEntityByid(0L, Osoba.class);
	}

}
