package com.tutorial.appdemo.service;

import java.util.List;

import com.tutorial.appdemo.model.Portir;

public interface PortirService {
	public Portir getPortirByName(String pKorisnickoIme);

	public void urediPortira(Portir pPortir, String pId);

	public String generirajToken(String pId);

	public List<Portir> getSvePortire();

	boolean prijaviSe(String pKorisnickoIme, String pLozinka);
}
