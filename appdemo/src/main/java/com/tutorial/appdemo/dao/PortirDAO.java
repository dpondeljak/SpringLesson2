package com.tutorial.appdemo.dao;

import com.tutorial.appdemo.model.Portir;

public interface PortirDAO {
	public Portir getPortirById(String pId);

	public Portir getPortirByUsername(String pKorisnickoIme);

	public void spremiPortira(Portir pPortir);

	public void brisiPortira(String pId);

	public void urediPortira(Portir pPortir, String pId);

	/**
	 * Generiranje korisnickog tokena za session ( MD5 Hash )
	 * <p>
	 * datum u trenutku generiranja + korisnicko ime + lozinka
	 * 
	 * @param pId
	 * @return String
	 */
	public String generirajToken(String pId);

}
