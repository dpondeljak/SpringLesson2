package com.tutorial.lekcija48.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.lekcija48.model.Proizvod;
import com.tutorial.lekcija48.service.ProizvodService;

@RestController
@RequestMapping(path="/api/products/")
public class ProizvodController {

	private ProizvodService proizvodService;

	@Autowired
	public void setProizvodService(ProizvodService proizvodService) {
		this.proizvodService = proizvodService;
	}


	/**
	 * Dohvat proizvoda 
	 * 
	 * @param id 
	 * @return Proizvod Objekt konvertiran u JSON
	 */
	@RequestMapping(path="{id}", method=RequestMethod.GET)
	public Proizvod getProizvod(@PathVariable(name="id") String id) {
		return proizvodService.getProizvod(id);
	}
	
	
	/**
	 * Spremanje proizvoda u bazu
	 * 
	 * @param proizvodZaSpremanje
	 * @return spremljeni proizvod 
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Proizvod spremiProizvod(@RequestBody Proizvod proizvodZaSpremanje) {
		return proizvodService.saveProizvod(proizvodZaSpremanje);
	}

	
	/**
	 * Uređivanje proizvoda po ID-u 
	 * 
	 * @param proizvodZaUpdate
	 * @param id
	 * @return uređeni Proizvod 
	 */
	@RequestMapping(path = "{id}", method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Proizvod updateProizvod(@RequestBody Proizvod proizvodZaUpdate, @PathVariable(name="id") String id) {
		return proizvodService.urediProizvod(proizvodZaUpdate, id);
	}
	
	/**
	 * brisanje proizvoda 
	 * 
	 * @param id
	 */
	@RequestMapping(path="{id}", method=RequestMethod.DELETE)
	public void brisanjeProizvoda(@PathVariable(name="id") String id) {
		proizvodService.deleteProizvod(id);
	}
	
}
