package com.tutorial.appdemo.api.greske;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class KorisnikAdvice {

	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Poruka procesiranjeNullPointerException(NullPointerException pGreska) {
		Poruka tPoruka = new Poruka();

		tPoruka.setPoruka("Greška u requestu. Pokušajte ponovo kasnije.");
		tPoruka.setTip("ERROR");
		tPoruka.setKod(HttpStatus.BAD_REQUEST.value());
		return tPoruka;
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Poruka procesiranjeEmptyResultDataAccessException(EmptyResultDataAccessException pGreska) {
		Poruka tPoruka = new Poruka();

		tPoruka.setPoruka("Greška: Ne postoji korisnik!");
		tPoruka.setTip("ERROR");
		tPoruka.setKod(HttpStatus.NOT_FOUND.value());
		return tPoruka;
	}
}
