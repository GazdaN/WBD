package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Kawiarnie {
    private Long idKawiarni;
    private String nazwa;
    private String numerLokalu;
    private String kodPocztowy;
    private String numerTelefonu;
    private String miejscowosc;
    private String ulica;
    private String email;

    @Id
    @Column(name = "ID_KAWIARNI", nullable = false, precision = 0)
    public  Long getIdKawiarni() {
        return idKawiarni;
    }

    public void setIdKawiarni(Long idKawiarni) {
        this.idKawiarni = idKawiarni;
    }

    @Basic
    @Column(name = "NAZWA", nullable = false, length = 30)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "NUMER_LOKALU", nullable = false, length = 5)
    public String getNumerLokalu() {
        return numerLokalu;
    }

    public void setNumerLokalu(String numerLokalu) {
        this.numerLokalu = numerLokalu;
    }

    @Basic
    @Column(name = "KOD_POCZTOWY", nullable = false, length = 6)
    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Basic
    @Column(name = "NUMER_TELEFONU", nullable = false, length = 12)
    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    @Basic
    @Column(name = "MIEJSCOWOSC", nullable = false, length = 30)
    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    @Basic
    @Column(name = "ULICA", nullable = false, length = 30)
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kawiarnie kawiarnie = (Kawiarnie) o;
        return Objects.equals(idKawiarni, kawiarnie.idKawiarni) &&
                Objects.equals(nazwa, kawiarnie.nazwa) &&
                Objects.equals(numerLokalu, kawiarnie.numerLokalu) &&
                Objects.equals(kodPocztowy, kawiarnie.kodPocztowy) &&
                Objects.equals(numerTelefonu, kawiarnie.numerTelefonu) &&
                Objects.equals(miejscowosc, kawiarnie.miejscowosc) &&
                Objects.equals(ulica, kawiarnie.ulica) &&
                Objects.equals(email, kawiarnie.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idKawiarni, nazwa, numerLokalu, kodPocztowy, numerTelefonu, miejscowosc, ulica, email);
    }
}
