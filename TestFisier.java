package ro.roxana.JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.roxana.licenta.Teren;


public class TestFisier extends TestCase {
	
	public TestFisier(String name){
		super(name);
	}
	
	static BufferedReader bf;
	static FileReader reader;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Preparing...setUp before");
		reader=new FileReader(new File("terenuri"));
		bf=new BufferedReader(reader);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bf.close();
		
	}
	@Before
	public void setUp() throws Exception {
		System.out.println("Preparing setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After - tearDown");
	}
	
	@Test
	public void testCitireDinFisier() {
	
		Teren teren= new Teren();
		try{
			reader= new FileReader("terenuri");
			bf= new BufferedReader(reader);
			
			String inreg=bf.readLine();
			while((inreg!=null) && inreg.length()!=0){
				
				String[] valori=inreg.split(",");
				int cod_teren=Integer.parseInt(valori[0]);
				String localizare=valori[1];
				float suprafata=Float.parseFloat(valori[2]);
				float suprafataArabila=Float.parseFloat(valori[3]);
				teren.setSuprafata(suprafata);
				System.out.println("Teren:"+cod_teren+" din "+localizare+
						" ,suprafata totala : "+suprafata+" si suprafata arabila:"+suprafataArabila);
				assertEquals(suprafataArabila, teren.calculeazaSuprafataArabila(),0);
				
				inreg=bf.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}

	@Test
public void testFisierSuprafataArabila(){
		Teren teren = new Teren();
		try{
			String inreg =  bf.readLine();
			while(inreg!=null)
			{
				String[] inregistrari= inreg.split(",");
				int cod_teren=Integer.parseInt(inregistrari[0]);
				String localizare=inregistrari[1];
				float suprafata=Float.parseFloat(inregistrari[2]);
				float suprafataArabila=Float.parseFloat(inregistrari[3]);
				teren.setSuprafata(suprafata);
				assertTrue(teren.verificaCalculSuprafataArabila(suprafataArabila));
				inreg=bf.readLine();
				
				
			}
		
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	}
	@Test
	public void testFisierSuprafataArabilaIncorect(){
			Teren teren = new Teren();
			try{
				String inreg =  bf.readLine();
				while(inreg!=null)
				{
					String[] inregistrari= inreg.split(",");
					int cod_teren=Integer.parseInt(inregistrari[0]);
					String localizare=inregistrari[1];
					float suprafata=Float.parseFloat(inregistrari[2]);
					float suprafataArabila=Float.parseFloat(inregistrari[3]);
					teren.setSuprafata(suprafata);
					assertFalse(!(teren.verificaCalculSuprafataArabila(suprafataArabila)));
					inreg=bf.readLine();
					
					
				}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		}

}
