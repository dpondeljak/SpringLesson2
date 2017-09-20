package com.tutorial.appdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tutorial.appdemo.AppConstants;
import com.tutorial.appdemo.model.Korisnik;
import com.tutorial.appdemo.model.Prijava;
import com.tutorial.appdemo.utils.Lozinka;

@Controller
public class LoginController {

	private int tBrojPokusajaUkupno = 3;
	private int tBrojPokusaja = 0;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView prikaziLoginFormu(HttpServletRequest pRequest, HttpServletResponse pResponse,
			Korisnik pKorisnik) {
		logger.info(AppConstants.APP_TAG + "Display Login formu.");

		ModelAndView tModel = new ModelAndView("login");
		tModel.addObject("korisnik", pKorisnik);
		return tModel;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView procesirajLoginFormu(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		logger.info(AppConstants.APP_TAG + "Procesiranje Login forme.");

		String tKorisnickoIme = pRequest.getParameter("korisnickoIme");
		String tLozinka = pRequest.getParameter("lozinka");
		logger.info(AppConstants.APP_TAG + " Korisnik: " + tKorisnickoIme + " Lozinka: " + tLozinka);

		tLozinka = Lozinka.kreirajZacinjenuLozinku(tLozinka);

		logger.info(AppConstants.APP_TAG + " Hash Lozinke: " + tLozinka);

		// Pozivamo i iniciramo klasu za prijavu
		Prijava tPrijava = new Prijava();

		boolean tPrijaviSe = tPrijava.prijaviSe(tKorisnickoIme, tLozinka);

		ModelAndView tPrikazEkrana = null;

		// Provjera prijave
		if (tPrijaviSe) {
			// Prijava uspješna - otvori admin panel

			logger.info(AppConstants.APP_TAG + "Prijava uspješna za korisnika: " + tKorisnickoIme + ".");

			// Reset broja pokušaja
			tBrojPokusaja = 0;

			/**
			 * Sa redirect:/path mijenja se url kod klijenta, a sa forward:/path
			 * "redirekcija" se odvija na serverskoj strani, a korisniku ostaje isti path
			 */
			tPrikazEkrana = new ModelAndView("redirect:/admin");
		} else {
			// Prijava nije uspjela pokušaj ponovo

			logger.info(AppConstants.APP_TAG + "Neuspješna prijava ::> Korisnik: " + tKorisnickoIme + " Lozinka: "
					+ tLozinka);
			// Povecaj broj pokusaja
			tBrojPokusaja++;

			tPrikazEkrana = new ModelAndView("login");
			tPrikazEkrana.addObject("poruka", "Neispravno korisnièko ime ili lozinka");

			// Kontrola broja pokusaja
			// Brojevi pokusaja mogu se implementirati u bazu ( zasebna tabela ), ili se
			// moze koristiti spring-security modul
			if (tBrojPokusaja < tBrojPokusajaUkupno) {
				// Poruka sa preostalim brojem pokusaja
				int preostaloPokusaja = tBrojPokusajaUkupno - tBrojPokusaja;
				tPrikazEkrana.addObject("pokusaji", "Imate jos " + preostaloPokusaja + " pokusaja!");
			} else if (tBrojPokusaja == tBrojPokusajaUkupno) {
				// Zakljucani account - primitivni nacina
				tPrikazEkrana.addObject("pokusaji", "Iskoristili ste sve pokusaje. Vas raèun je blokiran na 60 min.");
				tPrikazEkrana.addObject("disabled", "disabled");
			}

		}
		return tPrikazEkrana;
	}

}
