package ro.roxana.JUnit;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ro.roxana.licenta.Comanda;
import ro.roxana.licenta.ExceptieArgument;
import ro.roxana.licenta.PlanificareCultura;

public class TestPlanificareCultura extends TestCase {

	
	public TestPlanificareCultura(String name){
		super(name);
	}
	
	private PlanificareCultura planificare;
	@Before
	public void setUp(){
		 planificare =  new PlanificareCultura();
	}
	@Test
	public void testCalculeazaRandament() throws ExceptieArgument {
		try{
		double rezultat= planificare.calculeazaRandament(30, 1500.75);
		assertEquals(45022.5, rezultat, 0);}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testCalculeazaRandamentIncorect(){
		try{
			double rezultat=planificare.calculeazaRandament(-50, 1000);
			fail("Trebuia sa fie exceptie!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
