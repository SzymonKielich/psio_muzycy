package tests;

import static org.junit.Assert.*;

import javax.xml.crypto.Data;

import org.junit.Before;
import org.junit.Test;

import database.Dane;
import database.TextIO;
import generator.Generator;
import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;

public class Generator_SeePriceTest {
	
	Pianista pianista;
	Saksofonista saksofonista;
	Wokalista wokalista;
	
	
	@Before
	public void setUp() {
		
		Dane.Dane_initializeDatabase();		
//		TextIO.TextIO_zresetujDane();	
		TextIO.TextIO_zresetujDane();
		
	}
	

	@Test
	public void GenerateBandTest() {
		
		pianista = (Pianista) Generator.Generator_generateMuzyk("class muzycy.Pianista");
		saksofonista = (Saksofonista) Generator.Generator_generateMuzyk("class muzycy.Saksofonista");
		wokalista = (Wokalista) Generator.Generator_generateMuzyk("class muzycy.Wokalista");
		
		assertEquals(pianista.getClass(), Pianista.class);
		assertEquals(saksofonista.getClass(), Saksofonista.class);
		assertEquals(wokalista.getClass(), Wokalista.class);
		
	
		
		
	}
	
	@Test
	public void seePriceTest() {
		
		pianista = (Pianista) Generator.Generator_generateMuzyk("class muzycy.Pianista");
		saksofonista = (Saksofonista) Generator.Generator_generateMuzyk("class muzycy.Saksofonista");
		wokalista = (Wokalista) Generator.Generator_generateMuzyk("class muzycy.Wokalista");
		
		
		assertEquals(Generator.Generator_seePrice(wokalista, pianista, saksofonista),
				pianista.getStawka()+saksofonista.getStawka()+wokalista.getStawka());
		
		
		
	}
	
	@Test
	public void seePriceWithPredefinedObjectsTest() {
		
		pianista = new Pianista();
		saksofonista = new Saksofonista();
		wokalista = new Wokalista();
		
		pianista.setStawka(30000);
		saksofonista.setStawka(2800);
		wokalista.setStawka(1000);
		
		assertEquals(Generator.Generator_seePrice(wokalista, pianista, saksofonista), 33800);
		
		
	}

}
