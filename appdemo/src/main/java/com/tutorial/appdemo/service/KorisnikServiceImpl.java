package com.tutorial.appdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.appdemo.dao.KorisnikDAO;
import com.tutorial.appdemo.model.Korisnik;

@Service("korisnikServis")
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikDAO korisnikDao;

	public List<Korisnik> getSveKorisnike() {
		List<Korisnik> tListaKorisnika = korisnikDao.getSveKorisnike();
		return tListaKorisnika;
	}

	public void spremiKorisnika(Korisnik pKorisnik) {
		korisnikDao.spremiKorisnika(pKorisnik);
	}

	@Override
	public Korisnik getKorisnikaById(String pId) {
		// TODO Auto-generated method stub
		return korisnikDao.getKorisnikById(pId);

	}

	@Override
	public Korisnik urediKorisnika(Korisnik pKorisnik, String pId) {
		return korisnikDao.updateKorisnik(pKorisnik, pId);

	}

	@Override
	public void brisanjeKorisnika(String pId) {
		korisnikDao.brisiKorisnika(pId);
	}

}
