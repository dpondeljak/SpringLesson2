package com.tutorial.appdemo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.appdemo.dao.PortirDAO;
import com.tutorial.appdemo.model.Portir;

public class PortirServiceImpl implements PortirService {

	@Autowired
	private PortirDAO iPortirDao;

	@Override
	public Portir getPortirByName(String pKorisnickoIme) {
		return iPortirDao.getPortirByUsername(pKorisnickoIme);
	}

}
