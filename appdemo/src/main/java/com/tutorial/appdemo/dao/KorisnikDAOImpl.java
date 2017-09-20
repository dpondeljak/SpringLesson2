package com.tutorial.appdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;


import com.tutorial.appdemo.model.Korisnik;

@Repository("korisnikDAO")
public class KorisnikDAOImpl implements KorisnikDAO {

	@Autowired
	@Qualifier("wasDataSource")
	private DataSource dbDataSource;

	public KorisnikDAOImpl(DataSource dataSource) {
		this.dbDataSource = dataSource;
	}

	public List<Korisnik> getSveKorisnike() {

		// stvori JDBCTemplate od korisnika
		JdbcTemplate tJdbcTemplate = new JdbcTemplate(dbDataSource);
		// SQL komanda za sve korisnike
		String sql = "SELECT * FROM korisnici;";

		List<Korisnik> tKorisnici = tJdbcTemplate.query(sql, new RowMapper<Korisnik>() {
			// Mapiranje liste korisnika preko RowMapera
			@Override
			public Korisnik mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Korisnik tKorisnik = new Korisnik();
				tKorisnik.setId(rs.getInt("id"));
				tKorisnik.setKorisnickoIme(rs.getString("username"));
				tKorisnik.setLozinka(rs.getString("password"));
				tKorisnik.setDatumUnosa(rs.getString("datum_unosa"));
				tKorisnik.setDatumPromjene(rs.getString("datum_promjene"));
				tKorisnik.setStatus(rs.getInt("status"));
				return tKorisnik;
			}

		});

		// Vrati listu korisnika
		return tKorisnici;
	}

	/**
	 * Spremanje korisnika
	 */
	public void spremiKorisnika(Korisnik pKorisnik) {

	}

}
