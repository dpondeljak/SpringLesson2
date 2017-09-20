package com.tutorial.lekcija48;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tutorial.lekcija48.model.Proizvod;
import com.tutorial.lekcija48.repository.ProizvodRepository;



@SpringBootApplication
public class Lekcija48Application implements CommandLineRunner {

	private ProizvodRepository proizvodRepository;
	
	@Autowired	
	public void proizvodRepository(ProizvodRepository proizvodRepository) {
		this.proizvodRepository = proizvodRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lekcija48Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Proizvod testProizvod = new Proizvod();
		testProizvod.setNaziv("Test Proizvod");
		testProizvod.setKategorija("SPECIAL");
		testProizvod.setOpis("Opis Test proizvoda");
		testProizvod.setTip("CUSTOM");
		
		proizvodRepository.save(testProizvod);

	}


}
