package com.tutorial.lekcija48.controller.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tutorial.lekcija48.dto.PorukaDTO;

@RestControllerAdvice
public class ProizvodAdvice {

	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)

	public PorukaDTO procesiranjeNullPointerException(NullPointerException exception) {
		
		PorukaDTO poruka = new PorukaDTO();
		poruka.setPoruka("Greška u requestu, pokušajte ponovo kasnije!");
		poruka.setTip ("ERROR");
		
		return poruka;
	}
	
	
}
