package GUI.PanelAdministracyjny;

import GUI.PanelAdministracyjny.Operacje.Dodaj.DodajPianiste;
import GUI.PanelAdministracyjny.Operacje.Dodaj.DodajSaksofoniste;
import GUI.PanelAdministracyjny.Operacje.Dodaj.DodajWokaliste;
import GUI.PanelAdministracyjny.Operacje.Dodaj.JakiMuzyk;

public class Administracja {

    private AdministracjaGUI GUI;
    private JakiMuzyk wybor;

    public Administracja() {
        GUI = new AdministracjaGUI();
    }

    public AdministracjaGUI getGUI() {
        return GUI;
    }

    public JakiMuzyk getWybor() {
        return wybor;
    }

    public void setWyborWokalista() {
        wybor = new DodajWokaliste();
    }

    public void setWyborPianista() {
        wybor = new DodajPianiste();
    }

    public void setWyborSaksofonista() {
        wybor = new DodajSaksofoniste();
    }

}
