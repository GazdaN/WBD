//package Scenes;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextArea;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//public class AdminScene extends Scene {
//    Stage stage;
//    //TableView<Kawiarnie> table = new TableView<Kawiarnie>();
//
//
//    public AdminScene(Group group, Stage stage){
//
//        super(group);
//        this.stage = stage;
//
//        HBox hboxMain = new HBox(50);
//        hboxMain.setAlignment(Pos.CENTER);
//
//
//        HBox hBoxInfo = new HBox();
//        HBox hBoxMenu = new HBox();
//
//        hBoxInfo.setAlignment(Pos.TOP_CENTER);
//        hBoxMenu.setAlignment(Pos.BOTTOM_CENTER);
//
//        Text title1 = new Text("Panel infromacji o kawiarni");
//        Text title2 = new Text("Panel infromacji o Menu");
//        Button logOutButton = new Button("Wyloguj");
//        Button infoKawiarniaButton = new Button("Wyswietl Info o Kawiarni");
//
//        title1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//        title2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//
//
//        hBoxInfo.getChildren().add(title1);
//        hBoxInfo.getChildren().add(logOutButton);
//        hBoxInfo.getChildren().add(infoKawiarniaButton);
//
//        hBoxMenu.getChildren().add(title2);
//
//        infoKawiarniaButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                //TODO wyswietlanie informacji o kawiarni z bazy danych
//            }
//        });
//
//        logOutButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Stage loginStage = new Stage();
//                AdminScene adminScene = new AdminScene(new Group(),loginStage);
//                loginStage.setScene(adminScene);
//                loginStage.show();
//            }
//        });
//
//
//        hboxMain.getChildren().addAll(hBoxInfo,hBoxMenu);
//    }
//}
