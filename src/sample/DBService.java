package sample;

import entities.ElementyMenu;
import entities.Kawiarnie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entities.Login;

import java.awt.event.KeyAdapter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    boolean canLogin;
    private static String hql = "FROM entities.Kawiarnie";
    private static String hql2 = "FROM entities.ElementyMenu";

    public String login(String userName, String password2) {
        System.out.println("Dane wejściowe" + userName + " " + password2);
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Login.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Login login = session.get(Login.class, userName);
        System.out.println("Dane z bazy" + login.getPassword());


        canLogin = (login.getPassword().equals(password2));
        session.close();
        if (canLogin) {
            return login.getUprawnienia();

        }

        return "null";
    }

    public List<Kawiarnie> infoKAwiarniePobierz(){
        List<Kawiarnie> kawiarnies = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Kawiarnie.class).buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            org.hibernate.query.Query query = session.createQuery(hql);
            List infoList = ((org.hibernate.query.Query) query).list();
            session.getTransaction().commit();
            for (Object o :infoList){
                Kawiarnie kawiarnie = (Kawiarnie) o;
                kawiarnies.add(kawiarnie);
            }
            //return infoList;
        }catch(HibernateException he){
            he.printStackTrace();
        }
        return kawiarnies;
    }

    public List <ElementyMenu> elementyMenuPobierz(){

        List<ElementyMenu> elementyMenus = new ArrayList<>();
        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ElementyMenu.class).buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            org.hibernate.query.Query query = session.createQuery(hql2);
            List infoList = ((org.hibernate.query.Query) query).list();
            session.getTransaction().commit();
            for (Object o :infoList){
                ElementyMenu elementyMenu = (ElementyMenu) o;
                elementyMenus.add(elementyMenu);
            }
            //return infoList;
        }catch(HibernateException he){
            he.printStackTrace();
        }
        return elementyMenus;

    }

    public void wpiszDoBazy(String wartosc, String parametr){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Kawiarnie.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Kawiarnie kawiarnie = session.load(Kawiarnie.class);
        org.hibernate.query.Query query = session.createQuery("UPDATE Kawiarnie set "+ parametr+ " = " + "'" +wartosc + "'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    public void wpiszDoBazyID(String wartosc, String parametr){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Kawiarnie.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Kawiarnie kawiarnie = session.load(Kawiarnie.class);
        org.hibernate.query.Query query = session.createQuery("UPDATE Kawiarnie set "+ parametr+ " = " +wartosc);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    public void dodajElementMenu(String idPozycji, String nazwa, String data, String cena, String opis, String idMenu){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ElementyMenu.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ElementyMenu elementyMenu = new ElementyMenu(new Long(idPozycji), nazwa, Date.valueOf(data), new Long(cena), opis, new Long(idMenu));
        session.save(elementyMenu);
//        org.hibernate.query.Query query = session.createQuery("INSERT INTO ElEMENTY_MENU (ID_POZYCJI_MENU, NAZWA, DATA_WPROWADZENIA, CENA, OPIS, ID_MENU) VALUES ("+ idPozycji +",'"+nazwa+"'," +"'"+data+"'," +"'"+cena+"'," +"'"+opis+"', 234567");

//        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
