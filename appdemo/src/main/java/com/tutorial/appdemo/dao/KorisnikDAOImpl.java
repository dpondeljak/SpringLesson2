package com.tutorial.appdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tutorial.appdemo.DatabaseSql;
import com.tutorial.appdemo.model.Korisnik;

public class KorisnikDAOImpl implements KorisnikDAO {

	@Autowired
	JdbcTemplate tJdbcTemplate;

	// private static final Logger logger =
	// LoggerFactory.getLogger(KorisnikDAOImpl.class);

	public List<Korisnik> getSveKorisnike() {

		// SQL komanda za sve korisnike
		// "SELECT * FROM korisnici";

		List<Korisnik> tKorisnici = tJdbcTemplate.query(DatabaseSql.SQL_GET_ALL_KORISNIKE, new RowMapper<Korisnik>() {
			// Mapiranje liste korisnika preko RowMapera
			@Override
			public Korisnik mapRow(ResultSet rs, int brojReda) throws SQLException {
				Korisnik tKorisnik = new Korisnik();
				tKorisnik.setId(rs.getInt("id"));
				tKorisnik.setIme(rs.getString("ime"));
				tKorisnik.setPrezime(rs.getString("prezime"));
				tKorisnik.setKorisnickoIme(rs.getString("username"));
				tKorisnik.setLozinka(rs.getString("password"));
				tKorisnik.setDatumUnosa(rs.getString("datum_unosa"));
				tKorisnik.setDatumPromjene(rs.getString("datum_promjene"));
				tKorisnik.setStatus(rs.getInt("status"));
				tKorisnik.setIpAdresa(rs.getString("ip_adresa"));
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

		// INSERT INTO korisnici (ime, prezime, username, password,datum_unosa,
		// datum_promjene, status)
		// VALUES (?, ?, ?, ?, ?, ?, ?)

		tJdbcTemplate.update(DatabaseSql.SQL_INSERT_KORISNIK,
				new Object[] { pKorisnik.getIme(), pKorisnik.getPrezime(), pKorisnik.getKorisnickoIme(),
						pKorisnik.getLozinka(), pKorisnik.getDatumUnosa(), pKorisnik.getDatumPromjene(),
						pKorisnik.getStatus() });

	}

	/**
	 * Dohvat korisnika po ID-u
	 * 
	 * @see com.tutorial.appdemo.dao.KorisnikDAO#getKoriniskById(java.lang.String)
	 */
	@Override
	public Korisnik getKorisnikById(String pId) {
		// stvori JDBCTemplate od korisnika
		// SQL komanda za sve korisnike
		// "SELECT * FROM korisnici WHERE id = ?";
		Korisnik tKorisnik = (Korisnik) tJdbcTemplate.queryForObject(DatabaseSql.SQL_FIND_KORISNIK_BY_ID,
				new Object[] { pId }, new RowMapper<Korisnik>() {

					@Override
					public Korisnik mapRow(ResultSet rs, int brojReda) throws SQLException {
						Korisnik tKorisnik = new Korisnik();
						tKorisnik.setId(rs.getInt("id"));
						tKorisnik.setIme(rs.getString("ime"));
						tKorisnik.setPrezime(rs.getString("prezime"));
						tKorisnik.setKorisnickoIme(rs.getString("username"));
						tKorisnik.setLozinka(rs.getString("password"));
						tKorisnik.setDatumUnosa(rs.getString("datum_unosa"));
						tKorisnik.setDatumPromjene(rs.getString("datum_promjene"));
						tKorisnik.setStatus(rs.getInt("status"));
						tKorisnik.setIpAdresa(rs.getString("ip_adresa"));
						return tKorisnik;
					}

				});
		return tKorisnik;
	}

	@Override
	public Korisnik updateKorisnik(Korisnik pKorisnik, String pId) {
		// UPDATE korisnici SET ime = ?, prezime = ?, username = ?, password = ?,
		// datum_promjene=NOW(),
		// status = ?, ip_adresa = ? WHERE id = ?

		tJdbcTemplate.update(DatabaseSql.SQL_UPDATE_KORISNIK,
				new Object[] { pKorisnik.getIme(), pKorisnik.getPrezime(), pKorisnik.getKorisnickoIme(),
						pKorisnik.getLozinka(), pKorisnik.getStatus(), pKorisnik.getIpAdresa(), pId });

		return null;
	}

	@Override
	public Korisnik getKorisnikByUsername(String pKorisnickoIme) {
		Korisnik tKorisnik = (Korisnik) tJdbcTemplate.queryForObject(DatabaseSql.SQL_FIND_KORISNIK_BY_USERNAME,
				new Object[] { pKorisnickoIme }, new RowMapper<Korisnik>() {

					@Override
					public Korisnik mapRow(ResultSet rs, int brojReda) throws SQLException {
						Korisnik rmKorisnik = new Korisnik();
						rmKorisnik.setId(rs.getInt("id"));
						rmKorisnik.setIme(rs.getString("ime"));
						rmKorisnik.setPrezime(rs.getString("prezime"));
						rmKorisnik.setKorisnickoIme(rs.getString("username"));
						rmKorisnik.setLozinka(rs.getString("password"));
						rmKorisnik.setDatumUnosa(rs.getString("datum_unosa"));
						rmKorisnik.setDatumPromjene(rs.getString("datum_promjene"));
						rmKorisnik.setStatus(rs.getInt("status"));
						rmKorisnik.setIpAdresa(rs.getString("ip_adresa"));
						return rmKorisnik;

					}

				});

		return tKorisnik;
	}

	@Override
	public void brisiKorisnika(String pId) {
		tJdbcTemplate.update(DatabaseSql.SQL_DELETE_KORISNIK, pId);
	}

}
