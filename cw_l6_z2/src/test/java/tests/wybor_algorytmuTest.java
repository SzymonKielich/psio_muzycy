package tests;

import GUI.wybor_algorytmu;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import wyjatki.WyjatekNiepoprawnyBudzet;
import static org.junit.Assert.assertEquals;


public class wybor_algorytmuTest{

    @Test
    public void testValidateKwotaPoprawna() throws WyjatekNiepoprawnyBudzet,NumberFormatException {
        Assert.assertEquals(true, wybor_algorytmu.validateKwota("3500"));
    }
    @Test (expected = WyjatekNiepoprawnyBudzet.class)
    public void testValidateKwotaNegativeNumber() throws WyjatekNiepoprawnyBudzet,NumberFormatException{

        wybor_algorytmu.validateKwota("-900");
    }

    @Test (expected =WyjatekNiepoprawnyBudzet.class)
    public void testValidateKwotaNotDivisibleByOneHundred() throws WyjatekNiepoprawnyBudzet,NumberFormatException{
        wybor_algorytmu.validateKwota("1234");
    }

    @Test (expected =NumberFormatException.class)
    public void testValidateKwotaStringInput() throws WyjatekNiepoprawnyBudzet,NumberFormatException{
        wybor_algorytmu.validateKwota("test");
    }

    @Test (expected =NumberFormatException.class)
    public void testValidateKwotaEmptyInput() throws WyjatekNiepoprawnyBudzet,NumberFormatException{
        wybor_algorytmu.validateKwota("");
    }




}