package unsw.dungeon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class DungeonApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Dungeon application");

        // FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
        FXMLLoader startLoader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
        StartScreenController  startcont = new StartScreenController(primaryStage);
        startLoader.setController(startcont);
        
        Parent root = startLoader.load();
        Scene scene = new Scene(root);
        // setRoot();
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
