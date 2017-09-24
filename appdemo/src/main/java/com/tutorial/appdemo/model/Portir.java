package com.tutorial.appdemo.model;

import java.sql.Timestamp;
import java.util.Date;

public class Portir {
	private int id;
	private String korisnickoIme;
	private String lozinka;
	private int zakljucan;
	private int prijavljen;
	private String token;
	private String zadnjiPristup;

	public Portir() {
	}

	public Portir(String korisnickoIme, String lozinka) {
		Date tDate = new Date();
		// this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.zakljucan = 0;
		this.prijavljen = 1;
		this.zadnjiPristup = new Timestamp(tDate.getTime()).toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public int getZakljucan() {
		return zakljucan;
	}

	public void setZakljucan(int zakljucan) {
		this.zakljucan = zakljucan;
	}

	public int getPrijavljen() {
		return prijavljen;
	}

	public void setPrijavljen(int prijavljen) {
		this.prijavljen = prijavljen;
	}

	public String getZadnjiPristup() {
		return zadnjiPristup;
	}

	public void setZadnjiPristup(String zadnjiPristup) {
		this.zadnjiPristup = zadnjiPristup;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
