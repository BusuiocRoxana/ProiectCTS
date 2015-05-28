package ro.roxana.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Observer;

import junit.framework.TestCase;

import org.junit.Test;

import ro.roxana.licenta.Activitate;
import ro.roxana.licenta.Angajat;

public class TestActivitate extends TestCase{
	
	public TestActivitate(String name){
		super(name);
	}
//test daca setStatusActivitate seteaza corect atributul "status"

	@Test
	public void testStatusIncorect() {
		Activitate activitate= new Activitate();
		try{
		activitate.setStatusActivitate("inceputtt");
		fail("Trebuia sa fie exceptie!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	@Test
	public void testStatusCorect() {
		Activitate activitate= new Activitate();
		try{
		activitate.setStatusActivitate("inceput");
		assertEquals("inceput", activitate.getStatusActivitate());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
