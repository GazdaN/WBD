package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ELEMENTY_MENU", schema = "NATALIAGAZDA", catalog = "")
public class ElementyMenu {
    private Long idPozycjiMenu;
    private String nazwa;
    private Date dataWprowadzenia;
    private Long cena;
    private String opis;
    private Long idMenu =234567L;

    public ElementyMenu(){
    }

    public ElementyMenu(Long idPozycjiMenu, String nazwa, Date dataWprowadzenia, Long cena, String opis, Long idMenu) {
        this.idPozycjiMenu = idPozycjiMenu;
        this.nazwa = nazwa;
        this.dataWprowadzenia = dataWprowadzenia;
        this.cena = cena;
        this.opis = opis;
        this.idMenu = idMenu;
    }

    @Id
    @Column(name = "ID_POZYCJI_MENU", nullable = false, precision = 0)
    public Long getIdPozycjiMenu() {
        return idPozycjiMenu;
    }

    public void setIdPozycjiMenu(Long idPozycjiMenu) {
        this.idPozycjiMenu = idPozycjiMenu;
    }

    @Column(name = "ID_MENU", nullable = false, precision = 0)
    public Long getIdMenu() {return idMenu;};

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    @Basic
    @Column(name = "NAZWA", nullable = false, length = 80)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "DATA_WPROWADZENIA", nullable = false)
    public Date getDataWprowadzenia() {
        return dataWprowadzenia;
    }

    public void setDataWprowadzenia(Date dataWprowadzenia) {
        this.dataWprowadzenia = dataWprowadzenia;
    }

    @Basic
    @Column(name = "CENA", nullable = false, precision = 2)
    public Long getCena() {
        return cena;
    }

    public void setCena(Long cena) {
        this.cena = cena;
    }

    @Basic
    @Column(name = "OPIS", nullable = true, length = 800)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementyMenu that = (ElementyMenu) o;
        return Objects.equals(idPozycjiMenu, that.idPozycjiMenu) &&
                Objects.equals(nazwa, that.nazwa) &&
                Objects.equals(dataWprowadzenia, that.dataWprowadzenia) &&
                Objects.equals(cena, that.cena) &&
                Objects.equals(opis, that.opis)&&
                Objects.equals(idMenu, that.idMenu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPozycjiMenu, nazwa, dataWprowadzenia, cena, opis, idMenu);
    }
}
