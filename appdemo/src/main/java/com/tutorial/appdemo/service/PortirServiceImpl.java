package com.tutorial.appdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.appdemo.dao.PortirDAO;
import com.tutorial.appdemo.model.Portir;

@Service("portirServis")
public class PortirServiceImpl implements PortirService {

	@Autowired
	private PortirDAO portirDao;

	@Override
	public Portir getPortirByName(String pKorisnickoIme) {
		return portirDao.getPortirByUsername(pKorisnickoIme);
	}

	@Override
	public void urediPortira(Portir pPortir, String pId) {
		portirDao.urediPortira(pPortir, pId);
	}

	@Override
	public String generirajToken(String pId) {
		// TODO Auto-generated method stub
		return portirDao.generirajToken(pId);
	}

	@Override
	public List<Portir> getSvePortire() {
		// TODO Auto-generated method stub
		return portirDao.getSvePortire();
	}

	@Override
	public boolean prijaviSe(String pKorisnickoIme, String pLozinka) {
		return portirDao.prijaviSe(pKorisnickoIme, pLozinka);
	}

}
