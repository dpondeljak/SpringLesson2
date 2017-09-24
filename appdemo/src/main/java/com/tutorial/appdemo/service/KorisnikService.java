package com.tutorial.appdemo.service;

import java.util.List;

import com.tutorial.appdemo.model.Korisnik;

public interface KorisnikService {

	public List<Korisnik> getSveKorisnike();

	public void spremiKorisnika(Korisnik pKorisnik);

	public Korisnik getKorisnikaById(String pId);

	public Korisnik urediKorisnika(Korisnik pKorisnik, String pId);

	public void brisanjeKorisnika(String pId);
}
