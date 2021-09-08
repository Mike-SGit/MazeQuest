package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;
import unsw.dungeon.LevelsScreen;
// import unsw.dungeon.DungeonMaker.DungeonMakerController;
import unsw.dungeon.DungeonMaker.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WinScreenController {
	
	private Stage stage;

	@FXML
    private Button exitBtn;
    
    @FXML
	private Button menuBtn;

	@FXML
	private Pane pane;

	private LevelsScreen levelsScreen;



	/**
	 * goto level screen
	 * 
	 * @param event
	 */

	public WinScreenController(Stage stage){
		this.stage = stage;
	}
	

	// @FXML
	// public void init() {

	// }

	@FXML
	public void handleMenuBtn(ActionEvent event) throws IOException {
		// this.levelsScreen.start();
		System.out.println("menu pressed, going to main menu");
		LevelsScreenController newcont = new LevelsScreenController(stage);
		FXMLLoader aaa = new FXMLLoader(getClass().getResource("LevelsScreen.fxml"));
		aaa.setController(newcont);
		Parent pane = aaa.load();
		Scene scene = new Scene( pane );
  		this.stage.setScene(scene);

	}

	@FXML
	public void handleExitBtn(ActionEvent event) {
		// this.levelsScreen.start();
        System.out.println("exit button pressed, going to main menu");
        System.exit(0);
	}


	/**
	 * @param levelScreen the levelScreen to set
	 */
	public void setLevelsScreen(LevelsScreen levelsScreen) {
		this.levelsScreen = levelsScreen;
	}

	
}	
	
