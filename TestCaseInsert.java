package ro.roxana.JUnit;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;

import ro.roxana.licenta.Angajat;
import ro.roxana.licenta.Client;
import ro.roxana.licenta.ConexiuneBD;
import ro.roxana.licenta.Furnizor;
import ro.roxana.licenta.Teren;

public class TestCaseInsert extends TestCase{
	
	public TestCaseInsert(String name){
		super(name);
	}
	
	private Angajat angajat;
	private Client client; 
	private Furnizor furnizor; 
	private Teren teren;
	ConexiuneBD conexiune;
	
	@After
	public void setUp(){
		
		conexiune = ConexiuneBD.getConnection();
	}

	
	
	@Test
	public void testInserareAngajat() throws SQLException {
		angajat= new Angajat();
		try{
		angajat.insereazaAngajat("Andreea", "andreea@yahoo.com", "07879887", "Targoviste", "111");
		ArrayList<Angajat> angajati = angajat.selecteazaAngajati("Andreea");
		for(Angajat a:angajati)
		{
			System.out.println(a.getNume());
		}
		
		} catch(Exception ex){
			conexiune.connection.rollback();
			//conexiune.connection.close();
			ex.printStackTrace();
		}
		
	}
	
	@Test
	public void testInserareClient() throws SQLException {
		client= new Client();
		try{
		client.insereazaClient("Panapan","RO86934", "Bucuresti","panepan@yahoo.com", "07879887");
		ArrayList<Client> clienti= client.selecteazaClient("Panapan");
		for(Client c:clienti)
		{
			System.out.println(c.getDenumire());
		}
		
		} catch(Exception ex){
			//conexiune.connection.rollback();
			//conexiune.connection.close();
			ex.printStackTrace();
		}
		
	}
	@Test
	public void testInserareFurnizor() throws SQLException {
		furnizor= new Furnizor();
		try{
		furnizor.insereazaFurnizor("SC AGRO SRL","RO86563", "Bucuresti","AGRO@yahoo.com", "079999887");
		ArrayList<Furnizor> furnizori= furnizor.selecteazaFurnizor("SC AGRO SRL");
		for(Furnizor f:furnizori)
		{
			System.out.println(f.getDenumire());
		}
		
		} catch(Exception ex){
			conexiune.connection.rollback();
			//conexiune.connection.close();
			ex.printStackTrace();
		}
		
	}
	@Test
	public void testInsereazaTeren() throws SQLException {
		teren= new Teren();
		try{			
			teren = teren.insereazaTeren("Ilfov",1000);
			ArrayList<Teren> terenuri= teren.selecteazaTerenuri("Ilfov",1000);
			for(Teren t:terenuri)
			{
				System.out.println(t.getCod_teren()+"-"+t.getLocalizare()+"-"+t.getSuprafata());
			}
			
			} catch(Exception ex){
				conexiune.connection.rollback();
				//conexiune.connection.close();
				ex.printStackTrace();
			}
			
		}
}
