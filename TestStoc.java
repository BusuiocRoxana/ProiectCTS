package ro.roxana.JUnit;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ro.roxana.licenta.IStoc;
import ro.roxana.licenta.StocFactory;

public class TestStoc  extends TestCase{
	
	public TestStoc (String name){
		super(name);
	}

	private StocFactory stocFactory;
	IStoc stocRecolta;
	IStoc stocResursaExterna;
	@Before
	public void setUp() throws Exception {
		 stocFactory= new StocFactory();
		 stocRecolta=stocFactory.getStoc("Recolta");
		 stocResursaExterna = stocFactory.getStoc("ResursaExterna");
	}

	@Test
	public void testAdaugaRecoltaCorect() {
		try{
			
			assertEquals(200,stocRecolta.adauga(200),0);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	@Test 
	public void testAdaugaRecoltaIncorect(){
		try{
			stocRecolta.adauga(-200);
			fail("Trebuia sa fie exceptie!");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Test
	public void testCantitateVandutaCorect(){
		try{
			assertEquals(-5000,stocRecolta.scade(5000),0);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test 
	public void testCantitateVandutaIncorect(){
		try{
			stocRecolta.scade(-200);
			fail("Trebuia sa fie exceptie!");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test
	public void testCantitateUtilizataCorect(){
		try{
			assertEquals(100,stocResursaExterna.scade(100),0);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test 
	public void testCantitateUtilizataIncorect(){
		try{
			
			stocResursaExterna.scade(-200);
			fail("Trebuia sa fie exceptie!");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test
	public void testCantitateAchizitionataCorect(){
		try{
			assertEquals(100,stocResursaExterna.adauga(100),0);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Test 
	public void testCantitateAchizitionataIncorect(){
		try{
			
			stocResursaExterna.adauga(-200);
			fail("Trebuia sa fie exceptie!");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
