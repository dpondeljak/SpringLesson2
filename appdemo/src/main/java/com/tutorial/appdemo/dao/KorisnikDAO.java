package com.tutorial.appdemo.dao;

import java.util.List;

import com.tutorial.appdemo.model.Korisnik;

/**
 * Klasa za pristup podacima u bazi
 * 
 * @author dpondeljak
 *
 */
public interface KorisnikDAO {

	/**
	 * Metoda vraæa listu korisnika u bazi
	 * 
	 * @return List - lista korisnika u bazi
	 */
	public List<Korisnik> getSveKorisnike();

	/**
	 * Metoda za spremanje korisnika u bazu
	 * 
	 * @param Korisnik
	 *            pKorisnik
	 */
	public void spremiKorisnika(Korisnik pKorisnik);

}
