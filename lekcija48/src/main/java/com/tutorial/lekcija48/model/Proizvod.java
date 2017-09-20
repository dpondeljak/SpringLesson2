package com.tutorial.lekcija48.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proizvod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String naziv;
	private String kategorija;
	private String tip;
	private String opis;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getKategorija() {
		return kategorija;
	}
	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	@Override
	public String toString() {
		return "Proizvod [id=" + id + ", naziv=" + naziv + ", kategorija=" + kategorija + ", tip=" + tip + ", opis="
				+ opis + "]";
	}
	
	
	

}
