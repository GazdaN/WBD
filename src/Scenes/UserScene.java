package Scenes;

import entities.ElementyMenu;
import entities.Kawiarnie;
import entities.Menu;
import gui.ElementyMenuGui;
import gui.KawiarnieGui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.DBService;

import java.util.List;


public class UserScene extends Scene {

    protected Stage stage;
    VBox vBoxMain = new VBox();
    TableView<ElementyMenuGui> tableMenu= new TableView<>();
    TableView<KawiarnieGui> tableKAwiarnie = new TableView<>();


    protected final ObservableList<ElementyMenuGui> dataMenu = FXCollections.observableArrayList();
    protected final ObservableList<KawiarnieGui> dataInfo = FXCollections.observableArrayList();

    public UserScene(Group group, Stage stage){
        super(group);
        this.stage = stage;
        BorderPane border = new BorderPane();
        border.setCenter(vBoxMain);
        stworzGuiUser();
        ((Group) this.getRoot()).getChildren().addAll(vBoxMain);
    }

    private void stworzGuiUser() {
        vBoxMain.setAlignment(Pos.TOP_CENTER);
        vBoxMain.setSpacing(10);
        vBoxMain.setPadding(new Insets(5,5,5,5));

        Text title1 = new Text("Panel infromacji o kawiarni");
        title1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Text title2 = new Text("Panel infromacji o Menu");
        title2.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        HBox hBoxInfo = new HBox();
        HBox hBoxMenu = new HBox();

        HBox hBoxTabelaInfo = new HBox();
        VBox vBoxButtons = new VBox();
        hBoxTabelaInfo.setAlignment(Pos.TOP_LEFT);

        tableInfoInit(hBoxTabelaInfo);
        HBox hBoxTabelaMenu = new HBox();
        tableMenuInit(hBoxTabelaMenu);
        VBox vBoxButtonsMenu = new VBox();
        hBoxTabelaMenu.setAlignment(Pos.TOP_LEFT);



        hBoxInfo.setAlignment(Pos.TOP_CENTER);
        hBoxInfo.setSpacing(10);
        hBoxMenu.setAlignment(Pos.BOTTOM_CENTER);
        hBoxMenu.setSpacing(10);


        Button logOutButton = new Button("Wyloguj");
        Button infoKawiarniaButton = new Button("Wyswietl Info o Kawiarni");
        Button menuInfoButton = new Button("Wyswietl Info o Menu");

        menuInfoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBService dbService = new DBService();
                List<ElementyMenu> elementyMenus = dbService.elementyMenuPobierz();
                for(ElementyMenu elementyMenu : elementyMenus){
                    ElementyMenuGui elementyMenuGui = new ElementyMenuGui(elementyMenu);
                    dataMenu.add(elementyMenuGui);
                }
                tableMenu.setItems(dataMenu);

                //tableInfoInit(hBoxTabelaInfo);
            }

        });

        infoKawiarniaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBService dbService = new DBService();
                List<Kawiarnie> kawiarnies = dbService.infoKAwiarniePobierz();
                for(Kawiarnie kawiarnie : kawiarnies){
                    KawiarnieGui kawiarnieGui = new KawiarnieGui(kawiarnie);
                    dataInfo.add(kawiarnieGui);
                }
                tableKAwiarnie.setItems(dataInfo);
            }
        });

        logOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginScene loginScene = new LoginScene(new Group(), stage);
                stage.setScene(loginScene);
                stage.show();
            }
        });

        logOutButton.setAlignment(Pos.TOP_RIGHT);
        logOutButton.setPadding(new Insets(10, 0,0,10));
        infoKawiarniaButton.setAlignment(Pos.TOP_RIGHT);


        vBoxButtons.getChildren().addAll(infoKawiarniaButton);
        vBoxButtonsMenu.getChildren().addAll(menuInfoButton);

        vBoxButtons.setSpacing(10);
        vBoxButtons.setAlignment(Pos.TOP_CENTER);
        vBoxButtonsMenu.setSpacing(10);
        vBoxButtonsMenu.setAlignment(Pos.TOP_CENTER);
        hBoxInfo.getChildren().addAll(hBoxTabelaInfo, vBoxButtons);
        hBoxMenu.getChildren().addAll(hBoxTabelaMenu, vBoxButtonsMenu);

        vBoxMain.getChildren().addAll(title1, hBoxInfo, title2, hBoxMenu, logOutButton);


    }

    private void tableMenuInit(HBox hBox) {
        tableMenu.setEditable(true);

        TableColumn  idPozycjiColumn = new TableColumn("ID pozycji menu");
        idPozycjiColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui,String>("idPozycjiMenu"));
        TableColumn nazwaPozycjiColumn = new TableColumn("Nazwa");
        nazwaPozycjiColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui,String>("nazwa"));
        TableColumn dataColumn = new TableColumn("Data wprowadzenia");
        dataColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui, String>("data_wprowadzenia"));
        TableColumn cenaColumn = new TableColumn("Cena");
        cenaColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui, String>("cena"));
        TableColumn opisColumn = new TableColumn("Opis");
        opisColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui, String>("opis"));


        tableMenu.getColumns().addAll(idPozycjiColumn, nazwaPozycjiColumn, dataColumn, cenaColumn, opisColumn);

        hBox.getChildren().addAll(tableMenu);
    }

    private void tableInfoInit(HBox hBox) {
        tableKAwiarnie.setEditable(true);


        TableColumn idColumn = new TableColumn("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<Kawiarnie,String>("idKawiarni"));
        TableColumn nazwaColumn = new TableColumn("Nazwa");
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<KawiarnieGui,String>("nazwa"));

        TableColumn numerColumn = new TableColumn("Numer lokalu");
        numerColumn.setCellValueFactory(new PropertyValueFactory<Kawiarnie,String>("numerLokalu"));

        TableColumn kodColumn = new TableColumn("Numer telefonu");
        kodColumn.setCellValueFactory(new PropertyValueFactory<Kawiarnie,String>("numerTelefonu"));

        TableColumn miastoColumn = new TableColumn("Miejscowosc");
        miastoColumn.setCellValueFactory(new PropertyValueFactory<Kawiarnie,String>("miejscowosc"));

        TableColumn ulicaColumn = new TableColumn("Ulica");
        ulicaColumn.setCellValueFactory(new PropertyValueFactory<Kawiarnie,String>("ulica"));

        TableColumn emailColumn = new TableColumn("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<Kawiarnie,String>("email"));

        tableKAwiarnie.getColumns().addAll(idColumn, nazwaColumn, numerColumn, kodColumn, miastoColumn, ulicaColumn, emailColumn);
        //tableInfo.setItems(data2);

        hBox.getChildren().addAll(tableKAwiarnie);
    }


}
