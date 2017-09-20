package com.tutorial.lekcija48.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.lekcija48.controller.ProizvodController;
import com.tutorial.lekcija48.model.Proizvod;
import com.tutorial.lekcija48.repository.ProizvodRepository;

@Service
public class ProizvodService {
	
	private ProizvodRepository proizvodRepository;

	private Logger LOG = LoggerFactory.getLogger(ProizvodController.class);
	
	@Autowired
	public void setProizvodRepository(ProizvodRepository proizvodRepository) {
		this.proizvodRepository = proizvodRepository;
	}

	public Proizvod getProizvod(String id) {
		LOG.info("Dohvat proizvoda sa id: " + id );
		return proizvodRepository.findOne(id);
	}
	
	public Proizvod saveProizvod(Proizvod proizvod) {
		Proizvod proizvodZaSpremiti;
		try {
			LOG.info("Spremanje proizvoda...");
			proizvodZaSpremiti = proizvodRepository.save(proizvod);
			return proizvodZaSpremiti;
		} catch (Exception e) {
			LOG.error("Greška kod spremanja proizvoda: " + e.getMessage());
		}
		return new Proizvod();
	}
	
	public Proizvod urediProizvod(Proizvod proizvod, String id) {
		Proizvod nadjeniProizvod = proizvodRepository.findOne(id);
		try {
			nadjeniProizvod.setNaziv(proizvod.getNaziv());
			nadjeniProizvod.setOpis(proizvod.getOpis());
			nadjeniProizvod.setTip(proizvod.getTip());
			nadjeniProizvod.setKategorija(proizvod.getKategorija());
			return proizvodRepository.save(nadjeniProizvod);
			
		} catch (Exception e) {
			LOG.error("Greška kod uređivanja proizvoda: " + e.getMessage());
		}
		return proizvod;
	}
	
	public void deleteProizvod(String id) {
		try {
			proizvodRepository.delete(id);
		} catch (Exception e) {
			LOG.error("Greška kod brisanja proizvoda: " + e.getMessage());
		}
		
	}
	
	
}
