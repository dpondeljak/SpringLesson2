package com.tutorial.appdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tutorial.appdemo.AppConstants;
import com.tutorial.appdemo.model.Korisnik;
import com.tutorial.appdemo.model.Portir;
import com.tutorial.appdemo.service.PortirService;

@Controller
public class LoginController {

	@Autowired
	PortirService iPortirServis;

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

		// Pozivamo i iniciramo klasu za prijavu
		// Prijava tPrijava = new Prijava();

		boolean tPrijaviSe = iPortirServis.prijaviSe(tKorisnickoIme, tLozinka);

		ModelAndView tPrikazEkrana = null;

		// Provjera prijave
		if (tPrijaviSe) {
			// Prijava uspješna - otvori admin panel

			// dohvati portira
			Portir tPortir = iPortirServis.getPortirByName(tKorisnickoIme);

			logger.info(AppConstants.APP_TAG + "Prijava uspješna za portira: " + tKorisnickoIme + ".");

			pRequest.getSession().setAttribute("portir", tPortir);
			pRequest.getSession().setAttribute("token", tPortir.getToken());

			// Portir xPortir = (Portir) pRequest.getSession().getAttribute("portir");

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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView odjavaPortira(HttpServletRequest pRequest) {
		logger.info(AppConstants.APP_TAG + "Inicializiran Logout.");

		HttpSession tSession = pRequest.getSession();

		// provjera session - privremeno
		// TODO makni ovo
		if (tSession.isNew()) {
			System.out.println("New session is jutst created");
		} else {
			System.out.println("This is old session");
		}

		// Idemo po portira u session
		Portir tPortir = new Portir();
		tPortir = (Portir) tSession.getAttribute("portir");
		System.out.println(tPortir.toString());

		if (tPortir.getId() > 0) {
			// brisanje tokena iz baze
			tPortir.setToken("");
			tPortir.setPrijavljen(0);
			iPortirServis.urediPortira(tPortir, "" + tPortir.getId());
		}

		ModelAndView tModel = new ModelAndView("login");
		tModel.addObject("portir", new Portir());
		tSession.invalidate();
		return tModel;

	}

}
