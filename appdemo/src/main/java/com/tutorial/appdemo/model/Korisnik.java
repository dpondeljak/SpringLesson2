package com.tutorial.appdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "korisnici")
public class Korisnik {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username")
	private String korisnickoIme;

	@Column(name = "password")
	private String lozinka;

	@Column(name = "datum_unosa")
	private String datumUnosa;

	@Column(name = "datum_promjene")
	private String datumPromjene;

	@Column(name = "status")
	private int status;

	@Column(name = "ip_addresa")
	private String ipAdresa;

	public Korisnik() {

	}

	public Korisnik(String pKorisnickoIme, String pLozinka) {
		this.korisnickoIme = pKorisnickoIme;
		this.lozinka = pLozinka;
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

	public void setKorisnickoIme(String pKorisnickoIme) {
		this.korisnickoIme = pKorisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String pLozinka) {
		this.lozinka = pLozinka;
	}

	public String getDatumUnosa() {
		return datumUnosa;
	}

	public void setDatumUnosa(String pDatumUnosa) {
		this.datumUnosa = pDatumUnosa;
	}

	public String getDatumPromjene() {
		return datumPromjene;
	}

	public void setDatumPromjene(String pDatumPromjene) {
		this.datumPromjene = pDatumPromjene;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIpAdresa() {
		return ipAdresa;
	}

	public void setIpAdresa(String ipAdresa) {
		this.ipAdresa = ipAdresa;
	}

	@Override
	public boolean equals(Object pObject) {
		if (this == pObject) {
			return true;
		}

		Korisnik tKorisnik = (Korisnik) pObject;

		if (korisnickoIme != null ? !korisnickoIme.equals(tKorisnik.korisnickoIme) : tKorisnik.korisnickoIme != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", korisnickoIme=" + korisnickoIme + ", lozinka= " + lozinka + ", datumUnosa="
				+ datumUnosa + ", datumPromjene=" + datumPromjene + ", status=" + status + "]";
	}

}
