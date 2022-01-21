package database;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

class TextIOTest {

	@Test
	void testPliku() throws ClassNotFoundException, IOException {
		
		TextIO io = new TextIO();
		Object[] liczby = {2,4,6};
		
		io.TextIO_zapiszDoPliku(liczby, "test.ser");
		liczby = null;
		liczby = io.TextIO_odczytajZPliku("test.ser");
		
		assertNotNull(liczby);
		assertEquals(2, liczby[0]);
		assertEquals(4, liczby[1]);
		assertEquals(6, liczby[2]);
	}
	
	@Test
	void randomSave() throws ClassNotFoundException, IOException {
		
		TextIO io = new TextIO();
		Object[] test = new Object[100000];
		Random generator = new Random();
		for(int i = 0; i < test.length; i++) {
			test[i] = generator.nextInt();
		}
		io.TextIO_zapiszDoPliku(test, "test.ser");
		
		List<Object> testArrayList = Arrays.asList(test);
		
		List<Object> resultArrayList = Arrays.asList(io.TextIO_odczytajZPliku("test.ser"));
		
		assertEquals(testArrayList.toString(), resultArrayList.toString());
		
	}

}
