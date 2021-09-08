package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
//import screens now
import javafx.stage.Stage;



public class LevelsScreenController {
    private Stage stage;

    public LevelsScreenController(Stage stage){
		this.stage = stage;
	}
	public LevelsScreenController( ){

	}


    @FXML
    private Pane pane;

    // @FXML
    // private grid squares;

    @FXML
    private Button maze1Btn;

    @FXML
    private Button maze2Btn;

    @FXML
    private Button maze3Btn;

    @FXML
    private Button maze4Btn;

    @FXML
    private Button switchEnemiesBtn;
    @FXML
    private Button exitEnemiesTreasureBtn;


    @FXML
    private Button custom1Btn;
    @FXML
    private Button custom2Btn;
    @FXML
    private Button custom3Btn;
    @FXML
    private Button custom4Btn;

    // @FXML
	// public void handleBackBtn(ActionEvent event) {
		
    // }


    public void enterDungeon(String path) throws IOException {

        FXMLLoader newDungeonView = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        DungeonControllerLoader dloaderCont = new DungeonControllerLoader(path);
        DungeonController newcont = dloaderCont.loadController();
        System.out.println(path);

        newcont.stage = this.stage;
        newDungeonView.setController(newcont);

		
        Parent pane = newDungeonView.load();
		Scene scene = new Scene(pane);
        pane.requestFocus();
  		this.stage.setScene(scene);
        this.stage.show();

    }

    @FXML
	public void handleMaze1Btn(ActionEvent event) throws IOException {
        System.out.print("maze1Btn");

        String path = "maze.json";
    	// DungeonScreen dungeonScreen = new DungeonScreen(startScreen.getStage(), "Dungeon-?? (SWITCH CONDITION)", path);
    	// dungeonScreen.getController().setDungeonScreen(dungeonScreen);
    	// dungeonScreen.getController().setLevelScreen(levelScreen);
        // dungeonScreen.start();
        enterDungeon(path);
        // DungeonControllerLoader dloaderCont = new DungeonControllerLoader(path);
        // DungeonLoader dloader = new DungeonLoader(path);
        // DungeonController newcont = new DungeonController(this.stage);


		// FXMLLoader aaa = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
		// aaa.setController(newcont);
		// Parent pane = aaa.load();
		// Scene scene = new Scene( pane );

  		// this.stage.setScene(scene);

        
    }

    @FXML
	public void handleMaze2Btn(ActionEvent event) throws IOException {
		System.out.print("maze2Btn");
        String path = "killEnemy.json";
        enterDungeon(path);
        
    }
    
    @FXML
	public void handleMaze3Btn(ActionEvent event) throws IOException {
		System.out.print("maze2Btn");
        String path = "boulders.json";
        enterDungeon(path);
		
    }

    @FXML
	public void handleMaze4Btn(ActionEvent event) throws IOException {
                    System.out.print("custom2Btn");
        String path = "collectTreasure.json";
        enterDungeon(path);
    }

    @FXML
	public void handleSwitchEnemiesBtn(ActionEvent event) throws IOException {
		System.out.print("custom2Btn");
        String path = "enemiesSwitch.json";
        enterDungeon(path);
    }

    @FXML
	public void handleExitEnemiesTreasureBtn(ActionEvent event) throws IOException {
        //handleExitEnemiesTreasureBtn
        System.out.print("custom2Btn");
        String path = "exitEnemyTreasure.json";
        enterDungeon(path);
		
    }

    @FXML
	public void handleCustom1Btn(ActionEvent event) throws IOException {
		System.out.print("custom1Btn");
        String path = "CustomMaze0.json";
        enterDungeon(path);
    }

    @FXML
	public void handleCustom2Btn(ActionEvent event) throws IOException {
		System.out.print("custom2Btn");
        String path = "CustomMaze1.json";
        enterDungeon(path);
    }
    @FXML
	public void handleCustom3Btn(ActionEvent event) throws IOException {
		System.out.print("custom3Btn");
        String path = "CustomMaze2.json";
        enterDungeon(path);
    }
    
    @FXML
	public void handleCustom4Btn(ActionEvent event) throws IOException {
		System.out.print("custom4Btn");
        String path = "CustomMaze3.json";
        enterDungeon(path);
    }




    

    
}