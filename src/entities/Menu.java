package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Menu {
    private Long idMenu;
    private String nazwaMenu;

    @Id
    @Column(name = "ID_MENU", nullable = false, precision = 0)
    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    @Basic
    @Column(name = "NAZWA_MENU", nullable = false, length = 100)
    public String getNazwaMenu() {
        return nazwaMenu;
    }

    public void setNazwaMenu(String nazwaMenu) {
        this.nazwaMenu = nazwaMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(idMenu, menu.idMenu) &&
                Objects.equals(nazwaMenu, menu.nazwaMenu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMenu, nazwaMenu);
    }
}
