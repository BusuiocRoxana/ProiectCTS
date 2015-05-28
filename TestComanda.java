package ro.roxana.JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ro.roxana.licenta.Comanda;
import ro.roxana.licenta.ExceptieArgument;

public class TestComanda extends TestCase{

	public TestComanda (String name){
		super(name);
	}
	
	private Comanda comanda;
	
	@Before
	public void setUp(){
		comanda= new Comanda();
	}
	
	@Test
	public void testCalculeazaValoareComanda() {
		//Comanda comanda= new Comanda();
		double rezultat= comanda.calculeazaValoareComanda(25, 1000, "PJ");
		assertEquals(6000, rezultat, 0);
	}
	
	@Test
	public void testVerificaProcentCorect() throws ExceptieArgument{
		try{
		double valoareComanda = comanda.calculeazaValoareComanda(25, 200, "PJ");
		double procent= comanda.verificaValoareComanda(valoareComanda);
		assertEquals("Valoare procent",0.1,procent,0);}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test
	public void testVerificaValoareComandaZero() throws ExceptieArgument{
		try{
		double valoareComanda = comanda.calculeazaValoareComanda(25, -200, "PJ");
		comanda.verificaValoareComanda(valoareComanda);
		fail("Trebuia sa fie exceptie!");}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test
	public void testVerificaValoareComandaMinus() throws ExceptieArgument{
		try{
		double valoareComanda = comanda.calculeazaValoareComanda(25, 0, "PJ");
		comanda.verificaValoareComanda(valoareComanda);
		fail("Trebuia sa fie exceptie!");}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test
	public void testVerificaTipClientCorect(){
		try{
			comanda.setTipClient("PJ");
			assertEquals("PJ",comanda.getTipClient());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test
	public void testVerificaTipClientIncorect(){
		try{
			comanda.setTipClient("PJjjj");
			fail("Trebuia sa fie exceptie!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*
	@Test
	public void testComandaWeekend() throws ExceptieArgument{
			
		try{
			Calendar myCal  = Calendar.getInstance();
			myCal.set(Calendar.YEAR, 2015);
			myCal.set(Calendar.MONTH, 5);
			myCal.set(Calendar.DAY_OF_MONTH, 5);
			Date theDate = myCal.getTime();//.getDay();
		
			comanda = new Comanda();
			comanda.setData(theDate);
			assertEquals(comanda.extrageZiuaPtTest(theDate),comanda.getData().getDay());
			//Date data = new Date();
		
		//int ziua = this.comanda.extrageZiua(data);
			
		//assertEquals(ziua, 5);
			}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	 @Test
	public void testComandaWeekend2() throws ExceptieArgument{
		try{
		Date data = new Date();
		
		int ziua = this.comanda.extrageZiuaPtTest(data);
		assertEquals(ziua, 5);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
