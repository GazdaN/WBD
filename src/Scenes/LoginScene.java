package Scenes;

import entities.ElementyMenu;
import entities.Kawiarnie;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.DBService;
import sample.Main;

import java.util.List;

public class LoginScene extends Scene {
    protected Stage stage;
    VBox hBoxMain;
    TableView<KawiarnieGui> tableInfo = new TableView<>();
    TableView<ElementyMenuGui> tableMenu = new TableView<>();

    protected final ObservableList<KawiarnieGui> data2 = FXCollections.observableArrayList();
    protected final ObservableList<ElementyMenuGui> data3 = FXCollections.observableArrayList();


    public LoginScene(Group group, Stage stage) {
        super(group);
        this.stage = stage;
        BorderPane border = new BorderPane();
        hBoxMain = new VBox();
        hBoxMain.setSpacing(10);
        border.setCenter(hBoxMain);




        loginPanel();
//        adminPanel();
        ((Group) this.getRoot()).getChildren().addAll(hBoxMain);

    }

    public void loginPanel(){
        Text title = new Text("Aplikacja kawiarni: Logowanie");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        title.setTextAlignment(TextAlignment.CENTER);


        hBoxMain.getChildren().add(title);
        hBoxMain.setAlignment(Pos.CENTER);

        hBoxMain.setPrefSize(800,600);

        TextField loginTextField = new TextField();
        loginTextField.setPromptText("Wprowadz login");
        loginTextField.setMaxWidth(200);
        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Wprowadz haslo");
        passwordTextField.setMaxWidth(200);
        Button loginButton = new Button("Zaloguj");

        loginTextField.setAlignment(Pos.CENTER);
        passwordTextField.setAlignment(Pos.CENTER);

        hBoxMain.getChildren().add(loginTextField);
        hBoxMain.getChildren().add(passwordTextField);


        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBService dbService = new DBService();
                String rola = dbService.login(loginTextField.getText(), passwordTextField.getText());
                System.out.println(rola);
                if(rola.equals("admin")){
                    hBoxMain.getChildren().clear();
                    adminPanel();
                }

                if(rola.equals("user1")) {
                    hBoxMain.getChildren().clear();
                    UserScene userScene = new UserScene(new Group(), stage);
                    stage.setScene(userScene);
                    stage.show();
                }


            }
        });
        hBoxMain.getChildren().add(loginButton);


    }

    public void adminPanel(){

        hBoxMain.setAlignment(Pos.TOP_CENTER);
        hBoxMain.setSpacing(10);
        hBoxMain.setPadding(new Insets(5,5,5,5));

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
        Button editInfoButton = new Button("Edytuj Info");
        Button infoKawiarniaButton = new Button("Wyswietl Info o Kawiarni");
        Button menuInfoButton = new Button("Wyswietl Info o Menu");
        Button editMenuButton = new Button("Dodaj element Menu");




        logOutButton.setAlignment(Pos.TOP_RIGHT);
        logOutButton.setPadding(new Insets(10, 0,0,10));
        infoKawiarniaButton.setAlignment(Pos.TOP_RIGHT);


        vBoxButtons.getChildren().addAll(infoKawiarniaButton, editInfoButton);
        vBoxButtonsMenu.getChildren().addAll(menuInfoButton,editMenuButton);

        vBoxButtons.setSpacing(10);
        vBoxButtons.setAlignment(Pos.TOP_CENTER);
        vBoxButtonsMenu.setSpacing(10);
        vBoxButtonsMenu.setAlignment(Pos.TOP_CENTER);



        infoKawiarniaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                tableInfo.getItems().clear();
                DBService dbService = new DBService();
                List<Kawiarnie> kawiarnies = dbService.infoKAwiarniePobierz();
                for(Kawiarnie kawiarnie : kawiarnies){
                    KawiarnieGui kawiarnieGui = new KawiarnieGui(kawiarnie);
                    data2.add(kawiarnieGui);
                }
                tableInfo.setItems(data2);

                //tableInfoInit(hBoxTabelaInfo);
            }


        });

        menuInfoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tableMenu.getItems().clear();
                DBService dbService = new DBService();
                List<ElementyMenu> elementyMenus = dbService.elementyMenuPobierz();
                for(ElementyMenu elementyMenu : elementyMenus){
                    ElementyMenuGui elementyMenuGui = new ElementyMenuGui(elementyMenu);
                    data3.add(elementyMenuGui);
                }
                tableMenu.setItems(data3);

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


        editInfoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stageEdit = new Stage();
                stageEdit.setWidth(800);
                stageEdit.setHeight(600);
                stageEdit.setTitle("Edytuj informacje o kawiarni");
                EditInfoScene editInfoScene = new EditInfoScene(new Group(), stageEdit);
                stageEdit.setScene(editInfoScene);
                stageEdit.show();

            }
        });

        editMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stageEditMenu = new Stage();
                stageEditMenu.setWidth(800);
                stageEditMenu.setHeight(600);
                stageEditMenu.setTitle("Dodaj element Menu");
                EditMenuScene editMenuScene= new EditMenuScene(new Group(), stageEditMenu);
                stageEditMenu.setScene(editMenuScene);
                stageEditMenu.show();

            }
        });

        hBoxInfo.getChildren().addAll(hBoxTabelaInfo, vBoxButtons);
        hBoxMenu.getChildren().addAll(hBoxTabelaMenu, vBoxButtonsMenu);

        hBoxMain.getChildren().addAll(title1, hBoxInfo, title2, hBoxMenu, logOutButton);
    }

    private void tableMenuInit() {
        tableMenu.setEditable(true);
    }

    private void tableInfoInit(HBox hbox){

        tableInfo.setEditable(true);

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

        tableInfo.getColumns().addAll(idColumn, nazwaColumn, numerColumn, kodColumn, miastoColumn, ulicaColumn, emailColumn);

        hbox.getChildren().addAll(tableInfo);
    }

    private void tableMenuInit(HBox hbox){

        tableMenu.setEditable(true);

        TableColumn  idPozycjiColumn = new TableColumn("ID pozycji menu");
        idPozycjiColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenu, String>("idPozycjiMenu"));
        TableColumn nazwaPozycjiColumn = new TableColumn("Nazwa");
        nazwaPozycjiColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenu, String>("nazwa"));
        TableColumn dataColumn = new TableColumn("Data wprowadzenia");
        dataColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenu, String>("data_wprowadzenia"));
        TableColumn cenaColumn = new TableColumn("Cena");
        cenaColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenu, String>("cena"));
        TableColumn opisColumn = new TableColumn("Opis");
        opisColumn.setCellValueFactory(new PropertyValueFactory<ElementyMenu,String>("opis"));


        tableMenu.getColumns().addAll(idPozycjiColumn, nazwaPozycjiColumn, dataColumn, cenaColumn, opisColumn);

        hbox.getChildren().addAll(tableMenu);

    }




    }



