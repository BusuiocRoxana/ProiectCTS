package ro.roxana.JUnit;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import ro.roxana.licenta.Achizitie;


public class TestAchizitie extends TestCase {

	public TestAchizitie(String name){
		super(name);
	}
	@Test
	public void testValoareAchizitie() {
		Achizitie achizitie = new Achizitie();
		float rezultat = achizitie.calculeazaValoareAchizitie(200, 100) ;
		assertEquals(20000, rezultat, 0);
	}

}
