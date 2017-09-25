package com.tutorial.appdemo.controller;

import java.util.List;

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
import com.tutorial.appdemo.service.KorisnikService;
import com.tutorial.appdemo.service.PortirService;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private KorisnikService iKorisnikServis;

	@Autowired
	private PortirService iPortirServis;

	private Portir prijavljeniPortir;
	// private String token;

	public Portir getPrijavljeniPortir() {
		return prijavljeniPortir;
	}

	public void setPrijavljeniPortir(Portir prijavljeniPortir) {
		this.prijavljeniPortir = prijavljeniPortir;
	}

	// public String getToken() {
	// return token;
	// }
	//
	// public void setToken(String token) {
	// this.token = token;
	// }

	public void setiKorisnikServis(KorisnikService pKorisnikServis) {
		this.iKorisnikServis = pKorisnikServis;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView displayDashboard(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		logger.info(AppConstants.APP_TAG + "Provjera autorizacije.");
		Portir xPortir, tPortir = new Portir();
		String xToken = "";
		HttpSession tSession = pRequest.getSession();
		try {
			xPortir = (Portir) tSession.getAttribute("portir");
			xToken = (String) tSession.getAttribute("token");

			if (xPortir != null) {
				setPrijavljeniPortir(xPortir);
				// setToken(xToken);
			} else {
				ModelAndView model = new ModelAndView("login");
				return model;
			}

		} catch (Exception e) {
			System.out.println("GRESKA displayDashboard() - portir iz sessiona: " + e.getMessage());
		}

		tPortir = iPortirServis.getPortirByName(prijavljeniPortir.getKorisnickoIme());

		// Usporedi token prijevljenog portira s session tokenom
		if (!tPortir.getToken().equalsIgnoreCase(prijavljeniPortir.getToken())) {
			ModelAndView model = new ModelAndView("login");
			return model;
		}

		logger.info(AppConstants.APP_TAG + "Display admin CPanel.");

		List<Korisnik> tListaKorisnika = iKorisnikServis.getSveKorisnike();
		logger.info(AppConstants.APP_TAG + "lista Korisnika: " + tListaKorisnika.toString());
		ModelAndView model = new ModelAndView("admin\\admincp");
		model.addObject("listaKorisnika", tListaKorisnika);

		List<Portir> tListaPortira = iPortirServis.getSvePortire();
		model.addObject("listaPortira", tListaPortira);

		return model;

	}

	public void changePassword() {
	}

	public void editProfile() {
	}

}