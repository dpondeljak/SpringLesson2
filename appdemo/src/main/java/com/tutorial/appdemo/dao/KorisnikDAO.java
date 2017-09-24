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

	/**
	 * Dohvat Korisnika po ID-u
	 * 
	 * @param pId
	 * @return Korisnik
	 */
	public Korisnik getKorisnikById(String pId);

	/**
	 * Dohvat Korisnika po korisnickom imenu
	 * 
	 * @param pKorisnickoIme
	 * @return Korisnik
	 */
	public Korisnik getKorisnikByUsername(String pKorisnickoIme);

	/**
	 * Ureðivanje korisnika po id-u
	 * 
	 * @param pKorisnik
	 * @param pId
	 * @return Korisnik
	 */
	public Korisnik updateKorisnik(Korisnik pKorisnik, String pId);

	/**
	 * Brisanje korisnika
	 * 
	 * @param pId
	 */
	public void brisiKorisnika(String pId);

}
