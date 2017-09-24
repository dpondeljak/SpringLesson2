package com.tutorial.appdemo.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tutorial.appdemo.DatabaseSql;
import com.tutorial.appdemo.model.Portir;
import com.tutorial.appdemo.utils.Lozinka;

public class PortirDAOImpl implements PortirDAO {

	@Autowired
	JdbcTemplate tJdbcTemplate;

	@Override
	public Portir getPortirById(String pId) {
		// SELECT * FROM porta WHERE id = ?

		Portir tPortir = (Portir) tJdbcTemplate.queryForObject(DatabaseSql.SQL_FIND_PORTIR_BY_ID, new Object[] { pId },
				new BeanPropertyRowMapper<Portir>(Portir.class));
		return tPortir;
	}

	@Override
	public Portir getPortirByUsername(String pKorisnickoIme) {
		// SELECT * FROM porta WHERE korisnicko_ime = ?
		Portir tPortir = (Portir) tJdbcTemplate.queryForObject(DatabaseSql.SQL_FIND_PORTIR_BY_USERNAME,
				new Object[] { pKorisnickoIme }, new BeanPropertyRowMapper<Portir>(Portir.class));
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
		// TODO Auto-generated method stub

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

}
