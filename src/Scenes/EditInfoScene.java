package Scenes;

import entities.Kawiarnie;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
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

public class EditInfoScene extends Scene {

    Stage stage;
    String idKAwiarni;
    String nazwa;
    String numerLokalu;
    String kod;
    String telefon;
    String miasto;
    String ulica;
    String email;

    Text idKaw = new Text();
    Text nazwaLok = new Text(nazwa);
    Text numerLok = new Text(numerLokalu);
    Text kodLok = new Text(kod);
    Text telefonLok = new Text(telefon);
    Text miastoLok = new Text(miasto);
    Text ulicaLok = new Text(ulica);
    Text emailLok = new Text(email);

    protected final ObservableList<KawiarnieGui> data2 = FXCollections.observableArrayList();
    Alert alert = new Alert (Alert.AlertType.CONFIRMATION,"Zapisano zmiany!", ButtonType.OK);

    TextField idTextField = new TextField();

    TextField nazwaTextField = new TextField();
    TextField mailTextField = new TextField();
    TextField telefonTextField = new TextField();
    TextField numerTextField = new TextField();
    TextField kodTextField = new TextField();
    TextField ulicaTextField = new TextField();
    TextField miastoTextField = new TextField();
    DBService dbService = new DBService();
    List<Kawiarnie> kawiarnies = dbService.infoKAwiarniePobierz();

    public EditInfoScene(Group group, Stage stage) {
        super(group);
        this.stage = stage;
        BorderPane border = new BorderPane();

        VBox vBoxMain = new VBox();
        vBoxMain.setSpacing(10);
        vBoxMain.setPadding(new Insets(10, 10, 10, 10));

        Text title = new Text("Aplikacja kawiarni: Edycja Informacjo o Kawiarni");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        title.setTextAlignment(TextAlignment.LEFT);

        HBox editHbox = new HBox();
        editPanel(editHbox);

        Button zapiszButton = new Button("Zakoncz edycje");
        zapiszButton.setAlignment(Pos.BOTTOM_CENTER);
        zapiszButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        vBoxMain.getChildren().addAll(title, editHbox, zapiszButton);
        border.setCenter(vBoxMain);


        ((Group) this.getRoot()).getChildren().addAll(vBoxMain);

    }

    public void editPanel(HBox hbox) {

        VBox nazwaVbox = new VBox();
        VBox obecneVbox = new VBox();
        VBox noweVbox = new VBox();
        VBox przyciskiVbox = new VBox();

        nazwaParametry(nazwaVbox);
        obecneParametry(obecneVbox);
        noweParametry(noweVbox);
        przyciski(przyciskiVbox);


        hbox.getChildren().addAll(nazwaVbox, obecneVbox, noweVbox, przyciskiVbox);


    }

    public void nazwaParametry(VBox vBox) {

        vBox.setSpacing(20);

        Text title = new Text("Parametr");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        title.setTextAlignment(TextAlignment.LEFT);

        Text idText = new Text("Id Kawiarni:");
        Text nazwaText = new Text("Nazwa:");
        Text mailText = new Text("Email:");
        Text telefonText = new Text("Telefon:");
        Text numerText = new Text("Numer lokalu:");
        Text ulicaText = new Text("Ulica:");
        Text miastoText = new Text("Miejscowosc");
        Text kodText = new Text("Kod Pocztowy");

        vBox.getChildren().addAll(title, idText, nazwaText, mailText, telefonText, numerText, ulicaText, miastoText, kodText);


    }

    public void obecneParametry(VBox vbox) {

        vbox.setSpacing(20);
        vbox.setPadding(new Insets(0, 0, 0, 10));

        Text title = new Text("Obecne parametry");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        title.setTextAlignment(TextAlignment.LEFT);



        idKAwiarni = kawiarnies.get(0).getIdKawiarni().toString();
         idKaw =  new Text(idKAwiarni);

        nazwa = kawiarnies.get(0).getNazwa();
         nazwaLok = new Text(nazwa);

        numerLokalu = kawiarnies.get(0).getNumerLokalu();
        numerLok = new Text(numerLokalu);

        kod = kawiarnies.get(0).getKodPocztowy();
         kodLok = new Text(kod);

        telefon = kawiarnies.get(0).getNumerTelefonu();
         telefonLok = new Text(telefon);

        miasto = kawiarnies.get(0).getMiejscowosc();
         miastoLok = new Text(miasto);

        ulica = kawiarnies.get(0).getUlica();
         ulicaLok = new Text(ulica);

        email = kawiarnies.get(0).getEmail();
         emailLok = new Text(email);


        vbox.getChildren().addAll(title, idKaw, nazwaLok, emailLok, telefonLok, numerLok, ulicaLok, miastoLok, kodLok);


    }

    public void noweParametry(VBox vbox) {

        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0, 0, 0, 10));

        Text title = new Text("Wprowadz nowy");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        title.setTextAlignment(TextAlignment.LEFT);

        idTextField.setPromptText("6 cyfrowe ID");
        nazwaTextField.setPromptText("nazwa");
        mailTextField.setPromptText("mail");
        telefonTextField.setPromptText("telefon(9cyfr)");
        numerTextField.setPromptText("numer lokalu");
        ulicaTextField.setPromptText("ulica");
        miastoTextField.setPromptText("miasto");
        kodTextField.setPromptText("kod(5cyfr)");


        vbox.getChildren().addAll(title, idTextField, nazwaTextField, mailTextField, telefonTextField, numerTextField, ulicaTextField, miastoTextField, kodTextField);


    }

    public void przyciski(VBox vBox) {

        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0, 0, 0, 10));

        Text title = new Text("Kliknij by zmienic");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        title.setTextAlignment(TextAlignment.LEFT);

        Button zmienIDButton = new Button("Zmien");
        zmienIDButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String noweID = idTextField.getText();
                przekazID(noweID, "ID_KAWIARNI");
                wyswietlDialog();
                idKaw.setText(noweID);
            }
        });

        Button zmienNazweButton = new Button("Zmien");
        zmienNazweButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nowaNazwa = nazwaTextField.getText();
                przekazTekst(nowaNazwa, "NAZWA");
                wyswietlDialog();
                nazwaLok.setText(nowaNazwa);
            }
        });

        Button zmienMailButton = new Button("Zmien");
        zmienMailButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nowyMail = mailTextField.getText();
                przekazTekst(nowyMail,"EMAIL");
                wyswietlDialog();
                emailLok.setText(nowyMail);
            }
        });

        Button zmienTelefonButton = new Button("Zmien");
        zmienTelefonButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nowyTelefon = telefonTextField.getText();
                przekazTekst(nowyTelefon, "NUMER_TELEFONU");
                wyswietlDialog();
                telefonLok.setText(nowyTelefon);
            }
        });

        Button zmienNumerButton = new Button("Zmien");
        zmienNumerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nowyNumer = numerTextField.getText();
                przekazTekst(nowyNumer, "NUMER_LOKALU");
                wyswietlDialog();
                numerLok.setText(nowyNumer);
            }
        });

        Button zmienKodButton = new Button("Zmien");
        zmienKodButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nowyKod = kodTextField.getText();
                przekazTekst(nowyKod, "KOD_POCZTOWY");
                wyswietlDialog();
                kodLok.setText(nowyKod);
            }
        });

        Button zmienUliceButton = new Button("Zmien");
        zmienUliceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nowaUlica = ulicaTextField.getText();
                przekazTekst(nowaUlica, "ULICA");
                wyswietlDialog();
                ulicaLok.setText(nowaUlica);
            }
        });

        Button zmienMiastoButton = new Button("Zmien");
        zmienMiastoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String noweMiasto = miastoTextField.getText();
                przekazTekst(noweMiasto, "MIEJSCOWOSC");
                wyswietlDialog();
                miastoLok.setText(noweMiasto);
            }
        });

        vBox.getChildren().addAll(title, zmienIDButton, zmienNazweButton, zmienMailButton, zmienTelefonButton, zmienNumerButton, zmienUliceButton, zmienMiastoButton, zmienKodButton);

    }

    private void wyswietlDialog() {
        alert.show();

    }

    public void przekazTekst(String tekst, String parametr){
        dbService.wpiszDoBazy(tekst, parametr);

    }

    public void przekazID(String tekst, String parametr){
        dbService.wpiszDoBazyID(tekst, parametr);
    }




}
