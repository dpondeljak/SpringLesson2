package com.tutorial.appdemo.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LozinkeTest {

	// Lozinka za test
	private String iLozinka = "admin123!";

	/**
	 * 
	 * Lozinke i hashevi generirani na http://www.free-online-web-tools.com/tool/md5
	 * test u tri varijante, samo MD5, zacinjen s fiksnim zacinom, i zacinjena s
	 * korisnickim zacinom
	 * 
	 */

	// admin123!
	private String lozinkaHash1 = "10c4981bb793e1698a83aea43030a388";
	// admin123! + APP-SkElEtOn123!
	private String lozinkaHash2 = "878c119f656cb97542b0ca6be770f0d2";
	// admin123! + zacin123!
	private String lozinkaHash3 = "4ad9ed97c5a4a505d802bac5542a20fc";

	@Test
	public void testLozinka() {

		Lozinka tLozinka = new Lozinka(iLozinka);
		String kreiranaLozinka = tLozinka.getZacinjenuLozinku();

		assertNotNull(kreiranaLozinka);
		assertEquals(lozinkaHash2, kreiranaLozinka);
	}

	@Test
	public void testMd5() {

		String tGenerirano = Lozinka.MD5(iLozinka);

		assertNotNull(tGenerirano);
		assertEquals(lozinkaHash1, tGenerirano);
	}

	@Test
	public void testKreirajZacinjenuLozinku() {

		String tGenerirano = Lozinka.kreirajZacinjenuLozinku(iLozinka, "zacin123!");

		assertNotNull(tGenerirano);
		assertEquals(lozinkaHash3, tGenerirano);

	}

}
