package com.tutorial.appdemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.appdemo.model.Korisnik;

/**
 * <h1>API za mobilni dio</h1>
 * <p>
 * <ul>
 * <li>POST: /api/prijava - prijava korisnika</li>
 * <li>GET: /api/korisnisci - lista korisnika</li>
 * <li>GET: /api/korisnik/{id} - dohvat korisnika po ID-u</li>
 * <li>POST: /api/korisnik/{id} - spremanje korisnika</li>
 * <li>POST: /api/korisnik/dodaj - dodavanje novog korisnika</li>
 * </ul>
 * <p>
 * 
 * @author dpondeljak
 *
 */

/*
 * JSON SAMPLE Success poruka { "success": true, "data": [ {"id": 1, "username":
 * "kor1", "password": "kor123!", "datum_ulaza": "12.09.2017 11:24",
 * "datum_promjene" : "12.09.2017 11:24", "status" : 1 }, {"id": 2, "username":
 * "kor2", "password": "kor123!", "datum_ulaza": "12.09.2017 11:24",
 * "datum_promjene" : "12.09.2017 11:24", "status" : 1 }, {"id": 3, "username":
 * "kor1", "password": "kor123!", "datum_ulaza": "12.09.2017 11:24",
 * "datum_promjene" : "12.09.2017 11:24", "status" : 1 } ], "code": 123 }
 * 
 * Error Poruka
 * 
 * { "success": false, "error": {"code": 401, "message":
 * "Greška kod prijave. Provjerite svoje korisnicke podatke" } , "code": 401 }
 * 
 */

@RestController
@RequestMapping("/api")
public class ApiController {

	@RequestMapping(value = { "/",
			"/prijava" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String home() {
		// TODO - defaultna strana/poruka za api
		/*
		 * npr: { "success": false, "error": {"code": 404, "message": "Greška." } ,
		 * "code": 404 }
		 */

		return errorResponse();
	}

	/**
	 * Login korisnka - POST metoda
	 * 
	 */
	@RequestMapping(value = "/prijava", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public void login() {
		// TODO - Prijava korisnika
	}

	/**
	 * Lista korisnika - GET metoda
	 * 
	 */
	@RequestMapping(value = "/korisnici", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public void listaKorisnika() {
		// TODO - lista korisnika
	}

	/**
	 * Dohvat korisnika - GET metoda
	 * 
	 * @param pId
	 */
	@RequestMapping(value = "/korisnik/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public void getKorisnik(@PathVariable(name = "id") String pId) {
		// TODO - dohvat korisnika po ID-u
	}

	/**
	 * Spremanje korisnika nakon update-a - PUT metoda
	 * 
	 * @param pKorisnikUpdate
	 * @param pId
	 */
	@RequestMapping(value = "/korisnik/{id}", method = RequestMethod.PUT)
	public void spremiKorisnika(@RequestBody Korisnik pKorisnikUpdate, @PathVariable(name = "id") String pId) {
		// TODO - spremi korisnika po ID-u
	}

	/**
	 * Dodavanje korisnika - POST metoda
	 * 
	 * @param pKorisnik
	 */
	@RequestMapping(value = "/korisnik/dodaj", method = RequestMethod.POST)
	public void dodajKorisnika(@RequestBody Korisnik pKorisnik) {
		// TODO - dodaj novog korisnika
	}

	/**
	 * Brisanje korisnika - DELETE metoda
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/korisnik/{id}", method = RequestMethod.DELETE)
	public void brisanjeKorisnika(@PathVariable(name = "id") String id) {
		// TODO - Brisanje korisnika
	}

	/**
	 * Generièka poruka o grešci
	 * 
	 * @return String - Greška i kod
	 */
	private String errorResponse() {
		String tGreska = "{ \"success\": false, \"error\": {\"code\": 404, \"message\": \"Greška.\" },  \"code\": 404 }";

		return tGreska;
	}
}