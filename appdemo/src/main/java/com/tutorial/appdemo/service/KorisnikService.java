package com.tutorial.appdemo.service;

import java.util.List;

import com.tutorial.appdemo.model.Korisnik;

public interface KorisnikService {

	public List<Korisnik> getSveKorisnike();

	public void spremiKorisnika(Korisnik pKorisnik);
}
