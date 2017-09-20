package com.tutorial.appdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tutorial.appdemo.dao.KorisnikDAO;
import com.tutorial.appdemo.model.Korisnik;

@Service("korisnikServis")
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	@Qualifier("korisnikDAO")
	private KorisnikDAO korisnikDao;

	public List<Korisnik> getSveKorisnike() {
		List<Korisnik> tListaKorisnika = korisnikDao.getSveKorisnike();
		return tListaKorisnika;
	}

	public void spremiKorisnika(Korisnik pKorisnik) {
		korisnikDao.spremiKorisnika(pKorisnik);
	}

}
