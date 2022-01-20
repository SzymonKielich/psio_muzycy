package database;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

}
