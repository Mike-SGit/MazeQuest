package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import unsw.dungeon.StartScreenController;

public class StartScreen {

    private Scene scene;
    private StartScreenController controller;
    private Stage stage;


    public StartScreen(Stage stage) throws IOException{

        this.stage = stage;
        controller = new StartScreenController(stage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        scene = new Scene(root);

    }

    public void start(){
        stage.show();
    }

    public Stage getstage(){
        return stage;
    }

    public StartScreenController getController(){
        return controller;
    }

    


}

