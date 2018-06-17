package gui;
import entities.ElementyMenu;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ElementyMenuGui {

    private final SimpleStringProperty idPozycjiMenu;
    private final SimpleStringProperty nazwa;
    private final SimpleStringProperty data_wprowadzenia;
    private final SimpleStringProperty cena;
    private final SimpleStringProperty opis;

    public ElementyMenuGui(SimpleStringProperty idPozycjiMenu, SimpleStringProperty nazwa, SimpleStringProperty data_wprowadzenia, SimpleStringProperty cena, SimpleStringProperty opis){

        this.idPozycjiMenu = idPozycjiMenu;
        this.nazwa = nazwa;
        this. data_wprowadzenia = data_wprowadzenia;
        this. cena = cena;
        this.opis = opis;

    }

    public ElementyMenuGui(ElementyMenu elementyMenu){

        this.idPozycjiMenu = new SimpleStringProperty(elementyMenu.getIdPozycjiMenu().toString());
        this.nazwa = new SimpleStringProperty(elementyMenu.getNazwa());
        this.data_wprowadzenia = new SimpleStringProperty(elementyMenu.getDataWprowadzenia().toString());
        this.cena = new SimpleStringProperty(elementyMenu.getCena().toString());
        this.opis = new SimpleStringProperty(elementyMenu.getOpis());

    }

    public String getIdPozycjiMenu() {
        return idPozycjiMenu.get();
    }

    public SimpleStringProperty idPozycjiMenuProperty() {
        return idPozycjiMenu;
    }

    public void setIdPozycjiMenu(String idPozycjiMenu) {
        this.idPozycjiMenu.set(idPozycjiMenu);
    }

    public String getNazwa() {
        return nazwa.get();
    }

    public SimpleStringProperty nazwaProperty() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa.set(nazwa);
    }

    public String getData_wprowadzenia() {
        return data_wprowadzenia.get();
    }

    public SimpleStringProperty data_wprowadzeniaProperty() {
        return data_wprowadzenia;
    }

    public void setData_wprowadzenia(String data_wprowadzenia) {
        this.data_wprowadzenia.set(data_wprowadzenia);
    }

    public String getCena() {
        return cena.get();
    }

    public SimpleStringProperty cenaProperty() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena.set(cena);
    }

    public String getOpis() {
        return opis.get();
    }

    public SimpleStringProperty opisProperty() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis.set(opis);
    }
}
