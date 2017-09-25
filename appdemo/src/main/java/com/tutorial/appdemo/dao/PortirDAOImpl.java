package com.tutorial.appdemo.dao;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tutorial.appdemo.AppConstants;
import com.tutorial.appdemo.DatabaseSql;
import com.tutorial.appdemo.model.Portir;
import com.tutorial.appdemo.utils.Lozinka;

public class PortirDAOImpl implements PortirDAO {

	@Autowired
	private JdbcTemplate tJdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PortirDAOImpl.class);

	public List<Portir> getSvePortire() {
		List<Portir> tPortiri = tJdbcTemplate.query(DatabaseSql.SQL_GET_ALL_PORTIRE,
				new BeanPropertyRowMapper<Portir>(Portir.class));

		return tPortiri;
	}

	@Override
	public Portir getPortirById(String pId) {
		// SELECT * FROM porta WHERE id = ?

		Portir tPortir = (Portir) tJdbcTemplate.queryForObject(DatabaseSql.SQL_FIND_PORTIR_BY_ID, new Object[] { pId },
				new BeanPropertyRowMapper<Portir>(Portir.class));
		return tPortir;
	}

	@Override
	public Portir getPortirByUsername(String pKorisnickoIme) {
		Portir tPortir = new Portir();
		try {
			// SELECT * FROM porta WHERE korisnicko_ime = ? AND status = ?
			tPortir = (Portir) tJdbcTemplate.queryForObject(DatabaseSql.SQL_FIND_PORTIR_BY_USERNAME,
					new Object[] { pKorisnickoIme }, new BeanPropertyRowMapper<Portir>(Portir.class));
			return tPortir;
		} catch (Exception e) {
			System.out.println("Greška :" + e.getMessage());
		}
		return tPortir;
	}

	@Override
	public void spremiPortira(Portir pPortir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void brisiPortira(String pID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void urediPortira(Portir pPortir, String pId) {
		// Uredjivanje portira
		// UPDATE porta SET korisnicko_ime = ?, lozinka = ?, zakljucan = ?,
		// prijavljen=?,
		// zadnji_pristup=NOW(), token= ?, status = ? WHERE id = ?

		tJdbcTemplate.update(DatabaseSql.SQL_UPDATE_PORTIR, pPortir.getKorisnickoIme(), pPortir.getLozinka(),
				pPortir.getZakljucan(), pPortir.getPrijavljen(), pPortir.getToken(), pPortir.getStatus(), pId);

	}

	@Override
	public String generirajToken(String pId) {
		String tKorisnickiToken;
		Date tDate = new Date();

		Portir tPortir = getPortirById(pId);
		// Pripremi token
		tKorisnickiToken = tDate.toString() + tPortir.getKorisnickoIme() + tPortir.getLozinka();
		// MD5 Hash
		tKorisnickiToken = Lozinka.MD5(tKorisnickiToken);
		return tKorisnickiToken;
	}

	@Override
	public boolean prijaviSe(String pKorisnickoIme, String pLozinka) {

		Portir tPortir = new Portir(pKorisnickoIme, pLozinka);

		tPortir = getPortirByUsername(pKorisnickoIme);

		String novaLozinka = null;

		if (tPortir.getId() > 0) {
			logger.info(AppConstants.APP_TAG + "Imamo korisnika: " + tPortir.getKorisnickoIme());
			// Provjera da li je lozinka u plain text formatu
			if (tPortir.getLozinka().equalsIgnoreCase(pLozinka)) {
				logger.info(AppConstants.APP_TAG + "s PLAIN lozinkom: " + tPortir.getLozinka());
				// Lozinka je u plain text formatu potrebno je hashirati lozinku
				novaLozinka = Lozinka.kreirajZacinjenuLozinku(pLozinka);
			} else if (tPortir.getLozinka().equalsIgnoreCase(Lozinka.MD5(pLozinka))) {
				logger.info(AppConstants.APP_TAG + "s MD5 lozinkom: " + tPortir.getLozinka());
				// Lozinka je u MD5 formatu i potrebno ju je hashirati sa novim algoritmom
				novaLozinka = Lozinka.kreirajZacinjenuLozinku(pLozinka);
			} else if (tPortir.getLozinka().equalsIgnoreCase(Lozinka.kreirajZacinjenuLozinku(pLozinka))) {
				logger.info(AppConstants.APP_TAG + "s OK lozinkom: " + tPortir.getLozinka());
				novaLozinka = tPortir.getLozinka();
			} else {
				logger.info(AppConstants.APP_TAG + "s Pogrešnom: " + pLozinka);
				// Lozinka ne odgovara nijednoj varijanti ( Plain, MD5 )
				return false;
			}

			String pId = "" + tPortir.getId();
			// Imamo novu lozinku potrebno update portira
			if (novaLozinka != null) {
				logger.info(AppConstants.APP_TAG + "Postava nove lozinke: " + novaLozinka);
				tPortir.setLozinka(novaLozinka);
				urediPortira(tPortir, pId);
			}

			// generiraj token za portira, postavi prijavu
			tPortir.setToken(generirajToken(pId));
			logger.info(AppConstants.APP_TAG + "Postava Portir TOKENa: " + tPortir.getToken());
			tPortir.setPrijavljen(1);
			// ponovo uredi portira
			urediPortira(tPortir, pId);

			return true;
		} else {
			return false;
		}
	}

}
