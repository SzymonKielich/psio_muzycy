import GUI.LogowanieGUI;
import administracja.User;
import database.Dane;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LogowanieTest {

    @Mock
    LogowanieGUI tester;
    
    /*
    # --add-opens has the following syntax: java.base/java.lang=ALL-UNNAMED
    java --add-opens java.base/java.lang=ALL-UNNAMED
    */


    public LogowanieTest() {

        /*mockDane = (Dane) mock(Dane.class);
        ArrayList<User> lista = new ArrayList<>();
        lista.add(new User("admin", "admin"));
        lista.add(new User("jakislogin", "jakieshaslo"));
        when(Dane.getUzytkownicy()).thenReturn(lista);*/

    }

    //login correct, password correct

    @Test
    public void ActionPerformedTest_loginCorrect_passwordCorrect_1() {
        when(tester.getLogin()).thenReturn("admin");
        when(tester.getHaslo()).thenReturn("admin");

        tester.procesLogowania();

        assertEquals(tester.getKomunikat(),"poprawne logowanie");
    }

 /*   @Test
    public void ActionPerformedTest_loginCorrect_passwordCorrect_2() {
        when(tester.getLogin()).thenReturn("jakislogin");
        when(tester.getHaslo()).thenReturn("jakieshaslo");

        tester.procesLogowania();

        assertEquals(tester.getKomunikat(),"poprawne logowanie");
    }


    //login incorrect, password correct

    @Test
    public void ActionPerformedTest_loginIncorrect_passwordCorrect_1() {
        when(tester.getLogin()).thenReturn("admin1");
        when(tester.getHaslo()).thenReturn("admin");

        tester.procesLogowania();

        assertEquals(tester.getKomunikat(),"Uzytkownik admin1 nie jest zarejestrowany!");
    }

    @Test
    public void ActionPerformedTest_loginIncorrect_passwordCorrect_2() {
        when(tester.getLogin()).thenReturn("login");
        when(tester.getHaslo()).thenReturn("jakieshaslo");

        tester.procesLogowania();

        assertEquals(tester.getKomunikat(),"Uzytkownik login nie jest zarejestrowany!");
    }


    //login correct, password incorrect

    @Test
    public void ActionPerformedTest_loginCorrect_passwordIncorrect_1() {
        when(tester.getLogin()).thenReturn("admin");
        when(tester.getHaslo()).thenReturn("jakieshaslo");

        tester.procesLogowania();

        assertEquals(tester.getKomunikat(),"Nieprawidlowe haslo dla admin");
    }

    @Test
    public void ActionPerformedTest_loginCorrect_passwordIncorrect_2() {
        when(tester.getLogin()).thenReturn("jakislogin");
        when(tester.getHaslo()).thenReturn("jakieshaslo1");

        tester.procesLogowania();

        assertEquals(tester.getKomunikat(),"Nieprawidlowe haslo dla jaksilogin");
    }


    //login incorrect, password incorrect

    @Test
    public void ActionPerformedTest_loginIncorrect_passwordIncorrect_1() {
        when(tester.getLogin()).thenReturn("admin1");
        when(tester.getHaslo()).thenReturn("admin2");

        tester.procesLogowania();

        assertEquals(tester.getKomunikat(),"Uzytkownik admin1 nie jest zarejestrowany!");
    }

    @Test
    public void ActionPerformedTest_loginIncorrect_passwordIncorrect_2() {
        when(tester.getLogin()).thenReturn("login");
        when(tester.getHaslo()).thenReturn("password");

        tester.procesLogowania();

        assertEquals(tester.getKomunikat(),"Uzytkownik login nie jest zarejestrowany!");
    }


  */
}