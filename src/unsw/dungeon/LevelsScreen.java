package unsw.dungeon;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import unsw.dungeon.LevelsScreenController;


public class LevelsScreen {
    
    private Stage stage;
    private LevelsScreenController levelsScreenController;
    private Scene scene;

    public LevelsScreen(Stage stage) throws IOException{
        this.stage = stage;
        levelsScreenController = new LevelsScreenController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LevelsScreen.fxml"));
        loader.setController(levelsScreenController);
        Parent root = loader.load();
        scene = new Scene(root);

    }

    public LevelsScreen() {
       

    }

    public void start(){
            stage.show();
            // stage.setScene(scene);
        }

    public LevelsScreenController getLevelsScreenController(){
        return levelsScreenController;
    }


}