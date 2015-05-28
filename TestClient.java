package ro.roxana.JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.junit.Test;

import ro.roxana.licenta.Client;



public class TestClient extends TestCase {

	public TestClient(String name){
		super(name);
	}
	private Client client; 
	

	@Test
	public void testNumarTelefonIncorect()  {
		client =  new Client();	
		try {
			
			client.setNumarTelefon("7777uu");
		
			fail("Exceptie!");
			assertNull(client.getNumarTelefon());
			}
			
		 catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
	}
	@Test
	public void testNumarTelefonCorect()  {
			client =  new Client();	
		try {
			client.setNumarTelefon("777777");
		
			assertEquals("777777",client.getNumarTelefon());
			}
			
		 catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
	}
	
	
	
	@Test
	public void testSetEmailIncorect() {
		client=new Client();
		
		try{
			client.setEmail("roxana9595gmail"); 
			fail("trebuia sa fie exceptie setEmail");	
			assertNull(client.getEmail());
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testSetEmailCorect() {
		try{
		 client = new Client("Roxana","RO555","Bucuresti","roxana@gmail.com","072777788");
		assertEquals("Email valid","roxana@gmail.com", client.getEmail());
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

}
	@Test
	public void testCUICorect(){
		client = new Client();
		try{
			client.setCUI("RO546955");
			assertEquals("RO546955", client.getCUI());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test
	public void testCUIIncorect(){
		client = new Client();
		try{
			client.setCUI("");
			fail("Exceptie!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testDenumireIncorect(){
		client = new Client();
		try{
			client.setDenumire("");
			fail("Exceptie!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test
	public void testDenumireCorect(){
		client = new Client();
		try{
			client.setDenumire("SC Paneton SRL");
			assertEquals("SC Paneton SRL", client.getDenumire());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
