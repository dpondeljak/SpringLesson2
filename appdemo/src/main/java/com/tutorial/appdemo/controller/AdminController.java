package com.tutorial.appdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutorial.appdemo.AppConstants;
import com.tutorial.appdemo.model.Korisnik;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	// private KorisnikService iKorisnikServis;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String displayDashboard(HttpServletRequest pRequest, HttpServletResponse pResponse, Korisnik pKorisnik) {
		logger.info(AppConstants.APP_TAG + "Display admin CPanel.");

		// List<Korisnik> tListaKorisnika = iKorisnikServis.getSveKorisnike();

		return "admin\\admincp";

	}

}
