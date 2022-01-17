package tests;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import database.Dane;
import generator.Generator;
import muzycy.Muzyk;
import muzycy.Osoba;
import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;


public class CzyKazdyMuzykMaWszystkieKryteria {
	

	Dane dane;
	database.TextIO textio;
	List<Object> muzycy;
	ArrayList<Pianista> pianisci;
	ArrayList<Wokalista> wokalisci;
	ArrayList<Saksofonista> saksofonisci;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		
		
		textio = new database.TextIO();
		dane = new Dane();
		muzycy = textio.TextIO_pobierzMuzykow();
		
		pianisci = new ArrayList<Pianista>();
		wokalisci = new ArrayList<Wokalista>();
		saksofonisci = new ArrayList<Saksofonista>();
		
//		for(int i = 0; i < muzycy.size(); i++) {
//			
//			if(muzycy.get(i) instanceof Wokalista) {
//				wokalisci.add((Wokalista) muzycy.get(i));
//			} else if (muzycy.get(i) instanceof Saksofonista) {
//				saksofonisci.add((Saksofonista) muzycy.get(i));
//			} else if (muzycy.get(i) instanceof Pianista) {
//				pianisci.add((Pianista) muzycy.get(i));
//			} else {
//				System.out.println("Niekompatybilna klasa w bazie muzyków.");
//			}
//			
//			
//		}
//		
//		System.out.println(wokalisci);
//		System.out.println(saksofonisci);
//		System.out.println(pianisci);
		
		
	}

	@Test
	public void testDane_initializeDatabase() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class c = null; //klasa przechowująca informację o obiekcie który chcemy zbadać
		Class temp = null; //klasa odpowiadająca za dostarczanie metod z klas nadrzędnych
		ArrayList<String> requiredFields = new ArrayList<String>();
		Method method = null;
		
		for(int i = 0; i < muzycy.size(); i++) {
			
			if(muzycy.get(i) instanceof Wokalista) {
				c = Wokalista.class;
			} else if (muzycy.get(i) instanceof Saksofonista) {
				c = Saksofonista.class;
			} else if (muzycy.get(i) instanceof Pianista) {
				 c = Pianista.class;
			} else {
				fail("Niekompatybilna klasa w bazie muzyków.");
			}
			System.out.println("Sprawdzam " + muzycy.get(i));
			
			assertNotNull(c);
			

			requiredFields = getFieldsWithSuper(c);
//			System.out.println(requiredFields);
			
			for(int j = 0; j < requiredFields.size(); j++) {
				
				temp = c;
				
				System.out.println(requiredFields.get(j));
				while(method == null) {
					
					try {
						if(requiredFields.get(j).contains("czy")) {
							method = temp.getDeclaredMethod("is" + makeFirstLetterBig(requiredFields.get(j)));
						} else {
						 method = temp.getDeclaredMethod("get" + makeFirstLetterBig(requiredFields.get(j)));
						}
						 
						} catch (NoSuchMethodException e) {
							temp = temp.getSuperclass();
							System.out.println("Przelaczam na " + temp.getSimpleName());
						}
				}
				
				
				
				System.out.println(method.invoke(muzycy.get(i)));
				assertNotNull(method.invoke(muzycy.get(i)));
				method = null;
//				assertFalse(method.invoke(muzycy.get(i).toString() == "0"));

			}
			
			
			
			requiredFields.clear();
		}
		
		
		
	
		
	}
	
	public static String makeFirstLetterBig(String string) {
		StringBuilder stringbuilder = new StringBuilder(string);
		stringbuilder.setCharAt(0, Character.toUpperCase(string.charAt(0)));
		return stringbuilder.toString();
	}
	
	
    public static ArrayList<String> getFieldsWithSuper(Class<?> c) {
    	
    	ArrayList<String> result = new ArrayList<String>();
    	ArrayList requiredFields = new ArrayList();
    	

    		requiredFields = new ArrayList(Arrays.asList(muzycy.Osoba.class.getDeclaredFields()));
 
//		System.out.println(c.getSimpleName() + " simple name");

		requiredFields.addAll(Arrays.asList(c.getDeclaredFields()));
		
 //   	System.out.println("wymagane pole: " + requiredFields);
    	String field = null;
    	
    	
		// zbieranie potrzebnych parametrów
		for(int i = 0; i < requiredFields.size(); i++) {
			
			
			
			//pełna nazwa zawarta w arrayliście zawiera pakiet, typ zmiennej. rozdziel stringa i uzyskaj tylko końcową informację o zmiennej
//			System.out.println(requiredFields.get(i));
			
			if(requiredFields.get(i).toString().contains("serialVersionUID")) {
				continue;
			}
			
			if(requiredFields.get(i).toString().contains("java.lang.String") || requiredFields.get(i).toString().contains("mikro") 
					|| requiredFields.get(i).toString().contains("Pianista") || requiredFields.get(i).toString().contains("Saksofonista")){
				
				//najpierw oddzielamy na 3 substringi ze względu na spacje, potem 3 substring rozdzielamy ze względu na kropki (TYP pakiet.Klasa.Skladowa)
				String split[] = requiredFields.get(i).toString().split(" ");
				String split2[] = split[2].split("\\.");
				//field = split[2];
				field = split2[2];
				
			} else {
				String split[] = requiredFields.get(i).toString().split("\\.");
				field = split[2];
			}
    	
    	
			result.add(field);
		}
    		
    	
			return result;	
    	
    }

}
