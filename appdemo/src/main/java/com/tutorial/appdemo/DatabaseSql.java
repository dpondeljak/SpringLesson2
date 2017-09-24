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
	// Ure�ivanje korisnika
	public static String SQL_UPDATE_KORISNIK = "UPDATE korisnici SET ime = ?, prezime = ?, username = ?, password = ?, datum_promjene=NOW(), status = ?, ip_adresa = ? WHERE id = ?";
	// Na�i korisnika po ID-u
	public static String SQL_FIND_KORISNIK_BY_ID = "SELECT * FROM korisnici WHERE id = ?";
	// Na�i korisnika po imenu
	public static String SQL_FIND_KORISNIK_BY_NAME = "SELECT * FROM korisnici WHERE ime = ?";
	// Na�i korisnika po korisnickom imenu
	public static String SQL_FIND_KORISNIK_BY_USERNAME = "SELECT * FROM korisnici WHERE username = ?";
	// Obri�i korisnika
	public static String SQL_DELETE_KORISNIK = "DELETE FROM korisnici WHERE id = ?";
	// Dohvati sve korisnike
	public static String SQL_GET_ALL_KORISNIKE = "SELECT * FROM korisnici";

	/**
	 * Tabela Porta
	 */
	// Dohvati portira po korisnickom imenu
	public static String SQL_FIND_PORTIR_BY_USERNAME = "SELECT * FROM porta WHERE korisnicko_ime = ?";
	public static String SQL_FIND_PORTIR_BY_ID = "SELECT * FROM porta WHERE id = ?";

}
