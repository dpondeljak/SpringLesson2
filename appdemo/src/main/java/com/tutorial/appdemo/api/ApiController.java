package com.tutorial.appdemo.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.appdemo.AppConstants;
import com.tutorial.appdemo.model.Korisnik;
import com.tutorial.appdemo.service.KorisnikService;

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
 * Greške se obraðuju pomoæu @RestControllerAdvice u klasi KorisnikAdvice.java
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
 * "Greï¿½ka kod prijave. Provjerite svoje korisnicke podatke" } , "code": 401 }
 * 
 */

@RestController
@RequestMapping("/api")
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private KorisnikService iKorisnikServis;

	public void setiKorisnikServis(KorisnikService pKorisnikServis) {
		this.iKorisnikServis = pKorisnikServis;
	}

	/*
	 * @RequestMapping(value = { "/", "/prijava" }, method = RequestMethod.GET,
	 * produces = "application/json;charset=UTF-8") public String home() { // TODO -
	 * defaultna strana/poruka za api // // npr: { "success": false, "error":
	 * {"code": 404, "message": "Greï¿½ka." } , // "code": 404 } //
	 * 
	 * return errorResponse(); }
	 */

	/**
	 * Login korisnka - POST metoda
	 * 
	 */
	@RequestMapping(value = "/prijava", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public void login() {
		// TODO - Prijava korisnika
		logger.info(AppConstants.APP_TAG + "REST - Prijava korisnika");

	}

	/**
	 * Lista korisnika - GET metoda
	 * 
	 * @return
	 * 
	 * @return
	 * 
	 */

	@RequestMapping(value = "/korisnici", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Korisnik> listaKorisnika() {
		logger.info(AppConstants.APP_TAG + "REST - Lista korisnika");
		return iKorisnikServis.getSveKorisnike();
	}

	/**
	 * Dohvat korisnika - GET metoda
	 * 
	 * @param pId
	 * @return
	 */
	@RequestMapping(path = "/korisnik/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody Korisnik getKorisnik(@PathVariable(name = "id") String pId) {
		logger.info(AppConstants.APP_TAG + "REST - dohvat korisnika po ID-u");
		return iKorisnikServis.getKorisnikaById(pId);
	}

	/**
	 * Spremanje korisnika nakon update-a - PUT metoda
	 * 
	 * @param pKorisnikUpdate
	 * @param pId
	 * @return
	 */
	@RequestMapping(value = "/korisnik/{id}", method = RequestMethod.PUT)
	public Korisnik urediKorisnika(@RequestBody Korisnik pKorisnikUpdate, @PathVariable(name = "id") String pId) {
		logger.info(AppConstants.APP_TAG + "REST - update korisnika");
		return iKorisnikServis.urediKorisnika(pKorisnikUpdate, pId);
	}

	/**
	 * Dodavanje korisnika - POST metoda
	 * 
	 * @param pKorisnik
	 */
	@RequestMapping(value = "/korisnik/dodaj", method = RequestMethod.POST)
	public void dodajKorisnika(@RequestBody Korisnik pKorisnik) {
		logger.info(AppConstants.APP_TAG + "REST - Novi korisnik");
		iKorisnikServis.spremiKorisnika(pKorisnik);
	}

	/**
	 * Brisanje korisnika - DELETE metoda
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/korisnik/{id}", method = RequestMethod.DELETE)
	public void brisanjeKorisnika(@PathVariable(name = "id") String pId) {
		// TODO - Brisanje korisnika
		logger.info(AppConstants.APP_TAG + "REST - Brisanje korisnika");
		iKorisnikServis.brisanjeKorisnika(pId);
	}

}