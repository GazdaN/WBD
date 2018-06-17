package gui;

import entities.Kawiarnie;
import javafx.beans.property.SimpleStringProperty;

public class KawiarnieGui {
    private final SimpleStringProperty idKawiarni;
    private final SimpleStringProperty nazwa;
    private final SimpleStringProperty numerLokalu;
    private final SimpleStringProperty kodPocztowy;
    private final SimpleStringProperty numerTelefonu;
    private final SimpleStringProperty miejscowosc;
    private final SimpleStringProperty ulica;
    private final SimpleStringProperty email;

    public KawiarnieGui(SimpleStringProperty idKawiarni, SimpleStringProperty nazwa, SimpleStringProperty numerLokalu, SimpleStringProperty kodPocztowy, SimpleStringProperty numerTelefonu, SimpleStringProperty miejscowosc, SimpleStringProperty ulica, SimpleStringProperty email) {
        this.idKawiarni = idKawiarni;
        this.nazwa = nazwa;
        this.numerLokalu = numerLokalu;
        this.kodPocztowy = kodPocztowy;
        this.numerTelefonu = numerTelefonu;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.email = email;
    }

    public KawiarnieGui(Kawiarnie kawiarnie){
        this.idKawiarni = new SimpleStringProperty(kawiarnie.getIdKawiarni().toString());
        this.nazwa = new SimpleStringProperty(kawiarnie.getNazwa());
        this.numerLokalu = new SimpleStringProperty(kawiarnie.getNumerLokalu());
        this.kodPocztowy = new SimpleStringProperty(kawiarnie.getKodPocztowy());
        this.numerTelefonu = new SimpleStringProperty(kawiarnie.getNumerTelefonu());
        this.miejscowosc = new SimpleStringProperty(kawiarnie.getMiejscowosc());
        this.ulica = new SimpleStringProperty(kawiarnie.getUlica());
        this.email = new SimpleStringProperty(kawiarnie.getEmail());
    }

    public String getIdKawiarni() {
        return idKawiarni.get();
    }

    public SimpleStringProperty idKawiarniProperty() {
        return idKawiarni;
    }

    public void setIdKawiarni(String idKawiarni) {
        this.idKawiarni.set(idKawiarni);
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

    public String getNumerLokalu() {
        return numerLokalu.get();
    }

    public SimpleStringProperty numerLokaluProperty() {
        return numerLokalu;
    }

    public void setNumerLokalu(String numerLokalu) {
        this.numerLokalu.set(numerLokalu);
    }

    public String getKodPocztowy() {
        return kodPocztowy.get();
    }

    public SimpleStringProperty kodPocztowyProperty() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy.set(kodPocztowy);
    }

    public String getNumerTelefonu() {
        return numerTelefonu.get();
    }

    public SimpleStringProperty numerTelefonuProperty() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu.set(numerTelefonu);
    }

    public String getMiejscowosc() {
        return miejscowosc.get();
    }

    public SimpleStringProperty miejscowoscProperty() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc.set(miejscowosc);
    }

    public String getUlica() {
        return ulica.get();
    }

    public SimpleStringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
