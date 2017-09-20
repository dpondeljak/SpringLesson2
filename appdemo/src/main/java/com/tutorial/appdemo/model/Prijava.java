package com.tutorial.appdemo.model;

import com.tutorial.appdemo.utils.Lozinka;

public class Prijava {

	public boolean prijaviSe(String pKorisnickoIme, String pLozinka) {

		String tLozinka = Lozinka.kreirajZacinjenuLozinku("admin123!");

		// Provjera korisnickog imena i hashirane lozinke
		// PRIMITIVNA Provjera - stvarna provjera se mora izvrsiti kroz podatke u bazi
		if ("admin".equalsIgnoreCase(pKorisnickoIme) && tLozinka.equalsIgnoreCase(pLozinka)) {
			return true;
		} else {
			return false;
		}
	}
}
