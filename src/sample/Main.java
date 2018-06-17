package sample;

import Scenes.LoginScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Kawiarnia");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        primaryStage.setMaxWidth(1000);
        primaryStage.setMaxHeight(1000);

        LoginScene loginScene = new LoginScene(new Group(), primaryStage);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
