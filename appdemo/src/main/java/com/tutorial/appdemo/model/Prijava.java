package com.tutorial.appdemo.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.appdemo.service.PortirService;
import com.tutorial.appdemo.utils.Lozinka;

public class Prijava {

	@Autowired
	PortirService iPortirServis;

	public boolean prijaviSe(String pKorisnickoIme, String pLozinka) {

		Portir tPortir = new Portir();
		String tLozinka = Lozinka.kreirajZacinjenuLozinku(pLozinka);
		try {
			tPortir = iPortirServis.getPortirByName(pKorisnickoIme);

			if (tPortir.getKorisnickoIme().equalsIgnoreCase(pKorisnickoIme)
					&& tPortir.getLozinka().equalsIgnoreCase(tLozinka)) {
				// Imamo portira :)
				// TODO Spremanje u Session

				return true;
			}

			return false;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

		// String tLozinka = Lozinka.kreirajZacinjenuLozinku("admin123!");

		// Provjera korisnickog imena i hashirane lozinke
		// PRIMITIVNA Provjera - stvarna provjera se mora izvrsiti kroz podatke u bazi
		// if ("admin".equalsIgnoreCase(pKorisnickoIme) &&
		// tLozinka.equalsIgnoreCase(pLozinka)) {
		// return true;
		// } else {
		// return false;
		// }
	}
}
