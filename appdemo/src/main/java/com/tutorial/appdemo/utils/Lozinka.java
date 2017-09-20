package com.tutorial.appdemo.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Klasa za generiranje korisnickih lozinki sa i bez zacina
 * 
 * @author dpondeljak
 *
 */
public class Lozinka {
	// Aplikativno definiran zacin
	public static final String SALT = "APP-SkElEtOn123!";

	// dužina lozinke
	private int iDuzinaLozinke;

	// Zacinjena lozinka
	private String iZacinjenaLozinka;

	public Lozinka() {
	}

	// konstruktor za brzo kreiranje lozinke s internim zacinom
	public Lozinka(String pLozinka) {
		iDuzinaLozinke = pLozinka.length();
		iZacinjenaLozinka = kreirajZacinjenuLozinku(pLozinka);
	}

	/**
	 * funkcija za Generiranje MD5 hash stringa
	 * 
	 * @param pLozinka
	 * @return String MD5 hash
	 */
	public static String MD5(String pLozinka) {
		String tMd5Hash = "";

		if (null == pLozinka) {
			return null;
		}

		try {
			// Create MD object
			MessageDigest tDigest = MessageDigest.getInstance("MD5");

			// Update input string in message digest object
			tDigest.update(pLozinka.getBytes(), 0, pLozinka.length());

			// Convert message digest object value in base 16 (hex)
			tMd5Hash = new BigInteger(1, tDigest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return tMd5Hash;
	}

	/**
	 * Kreiranje zacinjene lozinke sa definiranim zacinom
	 * 
	 * @param pLozinka
	 * @return String zacinjena lozinka
	 */
	public static String kreirajZacinjenuLozinku(String pLozinka) {
		String tZacinjenaLozinka = "";
		tZacinjenaLozinka = MD5(pLozinka + SALT);
		return tZacinjenaLozinka;
	}

	/**
	 * Kreiranje zacinjene lozinke sa korisnicki definiranim zacinom
	 * 
	 * @param pLozinka
	 * @return String zacinjena lozinka
	 */
	public static String kreirajZacinjenuLozinku(String pLozinka, String pZacin) {
		String tZacinjenaLozinka = "";
		tZacinjenaLozinka = MD5(pLozinka + pZacin);
		return tZacinjenaLozinka;
	}

	/**
	 * Vraca duzinu lozinke ( prije hash-iranja )
	 * 
	 * @return int - duzina lozinke
	 */
	public int getDuzinuLozinke() {
		return iDuzinaLozinke;
	}

	/**
	 * Vraca generiranu zacinjenu lozinku
	 * 
	 * @return
	 */
	public String getZacinjenuLozinku() {
		return iZacinjenaLozinka;
	}

	/**
	 * Postavlja zacinjenu lozinku ( sa definiranim zacinom )
	 * 
	 * @param pLozinka
	 */
	public void setSaltedPassword(String pLozinka) {
		this.iZacinjenaLozinka = kreirajZacinjenuLozinku(pLozinka);
	}

}
