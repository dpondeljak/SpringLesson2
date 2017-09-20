package com.tutorial.appdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tutorial.appdemo.AppConstants;
import com.tutorial.appdemo.model.Korisnik;
import com.tutorial.appdemo.service.KorisnikService;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	@Qualifier("korisnikServis")
	private KorisnikService iKorisnikServis;

	public void setiKorisnikServis(KorisnikService pKorisnikServis) {
		this.iKorisnikServis = pKorisnikServis;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView displayDashboard(HttpServletRequest pRequest, HttpServletResponse pResponse,
			Korisnik pKorisnik) {
		logger.info(AppConstants.APP_TAG + "Display admin CPanel.");

		List<Korisnik> tListaKorisnika = iKorisnikServis.getSveKorisnike();
		logger.info(AppConstants.APP_TAG + "lista Korisnika: " + tListaKorisnika.toString());
		ModelAndView model = new ModelAndView("admin\\admincp");
		model.addObject("listaKorisnika", tListaKorisnika);
		return model;

	}

}
