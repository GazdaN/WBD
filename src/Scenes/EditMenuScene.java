package Scenes;

import entities.ElementyMenu;
import gui.ElementyMenuGui;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DBService;

import java.util.List;

public class EditMenuScene extends Scene {

    Stage stage;
    TableView<ElementyMenuGui> tableMenu = new TableView<>();
    protected final ObservableList<ElementyMenuGui> dataMenu = FXCollections.observableArrayList();
    VBox vBoxMain;
    VBox tableMenuVBox;
    HBox textsHbox;
    DBService dbService = new DBService();

    private String idPozycjiMenu;
    private String nazwa;
    private String dataWprowadzenia;
    private String cena;
    private String opis;
    private String idMenu ="234567";


    TextField idTextField;
    TextField nazwaTextField ;
    TextField dataWprowadzeniaTextField;
    TextField cenaTextField ;
    TextField opisTextField;



    public EditMenuScene(Group group, Stage stage) {
        super(group);
        this.stage = stage;
        BorderPane border = new BorderPane();
        border.setCenter(vBoxMain);


        vBoxMain = new VBox();
        tableMenuVBox = new VBox();
        textsHbox = new HBox();



        tableMenu.setEditable(true);

        TableColumn idPozycjiColumn = new TableColumn("ID pozycji menu");
        idPozycjiColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui, String>("idPozycjiMenu"));
        TableColumn nazwaPozycjiColumn = new TableColumn("Nazwa");
        nazwaPozycjiColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui, String>("nazwa"));
        TableColumn dataColumn = new TableColumn("Data wprowadzenia");
        dataColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui, String>("data_wprowadzenia"));
        TableColumn cenaColumn = new TableColumn("Cena");
        cenaColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui, String>("cena"));
        TableColumn opisColumn = new TableColumn("Opis");
        opisColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenuGui, String>("opis"));


        tableMenu.getColumns().addAll(idPozycjiColumn, nazwaPozycjiColumn, dataColumn, cenaColumn, opisColumn);

        dbService = new DBService();
        List<ElementyMenu> elementyMenus = dbService.elementyMenuPobierz();
        for (ElementyMenu elementyMenu : elementyMenus) {
            ElementyMenuGui elementyMenuGui = new ElementyMenuGui(elementyMenu);
            dataMenu.add(elementyMenuGui);
        }
        tableMenu.setItems(dataMenu);

        tableMenuVBox.getChildren().addAll(tableMenu);

        idTextField = new TextField();
        idTextField.setPromptText("ID (6 unikatowych cyfr)");
        nazwaTextField = new TextField();
        nazwaTextField.setPromptText("Nazwa");
        dataWprowadzeniaTextField = new TextField();
        dataWprowadzeniaTextField.setPromptText("data: YYYY-MM-DD");
        cenaTextField = new TextField();
        cenaTextField.setPromptText("cena");
        opisTextField = new TextField();
        opisTextField.setPromptText("opis");

        Button dodajButton = new Button("Dodaj element");

        Text title1 = new Text("Wprowadz informacje o nowym elemencie menu:");

        textsHbox.getChildren().addAll(idTextField,nazwaTextField,dataWprowadzeniaTextField, cenaTextField, opisTextField);



        dodajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                idPozycjiMenu=idTextField.getText();
                nazwa=nazwaTextField.getText();
                dataWprowadzenia = dataWprowadzeniaTextField.getText();
                cena = cenaTextField.getText();
                opis = opisTextField.getText();
                Alert alert = new Alert (Alert.AlertType.CONFIRMATION,"Dodano element!", ButtonType.OK);
                alert.show();
                dbService.dodajElementMenu(idPozycjiMenu, nazwa, dataWprowadzenia, cena, opis, idMenu);
                stage.close();


            }
        });

        vBoxMain.getChildren().addAll(tableMenuVBox, title1, textsHbox,dodajButton);
        border.setCenter(vBoxMain);
        ((Group) this.getRoot()).getChildren().addAll(vBoxMain);


    }

}
