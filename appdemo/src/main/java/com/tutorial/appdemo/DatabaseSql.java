package com.tutorial.appdemo;

/**
 * Konstante SQL query prema bazama
 * 
 * @author dpondeljak
 *
 */
public class DatabaseSql {
	/**
	 * Tabela Korisnici
	 */
	// Kreiranje korisnika
	public static String SQL_INSERT_KORISNIK = "INSERT INTO korisnici  (ime, prezime, username, password,datum_unosa, datum_promjene, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	// Ureðivanje korisnika
	public static String SQL_UPDATE_KORISNIK = "UPDATE korisnici SET ime = ?, prezime = ?, username = ?, password = ?, datum_promjene=NOW(), status = ?, ip_adresa = ? WHERE id = ?";
	// Naði korisnika po ID-u
	public static String SQL_FIND_KORISNIK_BY_ID = "SELECT * FROM korisnici WHERE id = ?";
	// Naði korisnika po imenu
	public static String SQL_FIND_KORISNIK_BY_NAME = "SELECT * FROM korisnici WHERE ime = ?";
	// Naði korisnika po korisnickom imenu
	public static String SQL_FIND_KORISNIK_BY_USERNAME = "SELECT * FROM korisnici WHERE username = ?";
	// Obriši korisnika
	public static String SQL_DELETE_KORISNIK = "DELETE FROM korisnici WHERE id = ?";
	// Dohvati sve korisnike
	public static String SQL_GET_ALL_KORISNIKE = "SELECT * FROM korisnici";

	/**
	 * Tabela Porta
	 */
	// Dohvati sve portire
	public static String SQL_GET_ALL_PORTIRE = "SELECT * FROM porta";
	// Dohvati portira po korisnickom imenu i statusu
	public static String SQL_FIND_PORTIR_BY_USERNAME = "SELECT * FROM porta WHERE korisnicko_ime = ? AND status = 1";
	// dohvati po id-u
	public static String SQL_FIND_PORTIR_BY_ID = "SELECT * FROM porta WHERE id = ?";
	// update lozinke za portira id
	public static String SQL_UPDATE_PORTIR_PASSWORD = "UPDATE porta SET lozinka = ? WHERE id = ?";
	// update kompletnog portira po ID-u
	public static String SQL_UPDATE_PORTIR = "UPDATE porta SET korisnicko_ime = ?, lozinka = ?, zakljucan = ?, prijavljen=?, zadnji_pristup=NOW(), token= ?, status = ? WHERE id = ?";

}
