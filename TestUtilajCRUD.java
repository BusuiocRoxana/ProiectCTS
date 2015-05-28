package ro.roxana.JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ro.roxana.licenta.ConexiuneBD;
import ro.roxana.licenta.ExceptieArgument;
import ro.roxana.licenta.Utilaj;

public class TestUtilajCRUD extends TestCase{
	
	public TestUtilajCRUD(String name){
		super(name);
	}

	ConexiuneBD conexiune= ConexiuneBD.getConnection();
	//conexiune.setAutocommit(false);
	private Utilaj utilaj;
	private Utilaj utilaj2;
	@Before
	public void setUp(){
		System.out.println("Pregatire test - creare obiecte!");
		utilaj =  new Utilaj();
		 utilaj2= new Utilaj("bormasina","III","MVG",2011,"Dedeman");
	}
	
	@Test
	public void testInserareUtilaj() throws SQLException {
		try{
		utilaj.insereazaUtilaj("combina","II","MCV",2010,"Practiker");
		ArrayList<Utilaj> utilaje = utilaj.selecteazaUtilaje("combina");
		for(Utilaj j:utilaje)
		{
			System.out.println(j.getDenumire());
		}
		
		} catch(Exception ex){
			//conexiune.connection.rollback();
			//conexiune.connection.close();
			ex.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testGasesteUtilaj() throws SQLException, ExceptieArgument {
		
		Utilaj utilaj = new Utilaj();
		ArrayList<Utilaj> utilaje =  utilaj.selecteazaUtilaje("tractor");
			
		assertEquals("tractor",utilaje.get(0).getDenumire());
		for(Utilaj j:utilaje)
		{
			System.out.println(j.getDenumire());
		}
	
	}
	
	@Test
	public void testGasesteUtilajNuExista() throws SQLException, ExceptieArgument {
		
		Utilaj utilaj = new Utilaj();
		try{
			ArrayList<Utilaj> utilaje =  utilaj.selecteazaUtilaje("buldozer");
			assertTrue(utilaje.isEmpty());
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
					
	}
	
	
	
	
	/*
	@Test
	public void testCategorieUtilajValida(){
		Utilaj utilaj= new Utilaj();
		try{
			utilaj.setCategorie("mare");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/

}
