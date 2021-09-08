package unsw.dungeon.DungeonMaker;

import java.io.IOException;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class DungeonMakerController {

    @FXML
    private Pane pane;

    @FXML
    private CheckBox mazeGoal;

    @FXML
    private CheckBox boulderGoal;

    @FXML
    private CheckBox enemiesGoal;

    @FXML
    private CheckBox treasureGoal;

    @FXML
    private GridPane squares;

    @FXML
    private Button saveBtn;

    @FXML
    private Button exitBtn;


    private DungeonMaker maker;
	private Timeline timeline;
    

    public DungeonMakerController() {
        maker = new DungeonMaker();
        
    }

    // @FXML
    // public void handleTick(ActionEvent event) {
    // Random rand = new Random();
    // gol.ensureAlive(((rand.nextInt((9 + 0) + 1) + 0)), ((rand.nextInt((9 + 0) +
    // 1) + 0)));
    // }

    // @FXML
    // public void handleSaveBtn(ActionEvent event) {
    //     System.out.println("in handleSave func");   
    // }
    @FXML
    public void handleExitBtn(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    public void handleSaveBtn(ActionEvent event) {
        System.out.println("in handleSave func");
        Node result = null;
        ObservableList<Node> childrens = squares.getChildren();
        String text = "";
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                maker.setCell(i, j, "empty");
            }
        }
        
        for (Node node : childrens) {
            int x = squares.getRowIndex(node);
            int y = squares.getColumnIndex(node);
            if (node instanceof ChoiceBox) {
                ChoiceBox a = (ChoiceBox) node;
                text = (String) a.getValue();
            }
            // String value = (String) choiceBox.getValue();

            maker.setCell(y, x, text);
        }
        if (mazeGoal.isSelected())
            maker.mazeGoal = 1;
        if (boulderGoal.isSelected())
            maker.boulderGoal = 1;
        if (enemiesGoal.isSelected())
            maker.enemiesGoal = 1;
        if (treasureGoal.isSelected())
            maker.treasureGoal = 1;

        try {
            System.out.println("going to save func");
            maker.save();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("fin contsave func");

        
	}

    //// 0 = nothing, 1 = wall, 2 = player, 3 = enemy
    // 4 = boulder, 5 = door, 6 = exit, 7 = invincPotion
    // 8 = key, 9 = dexPotion, 10 = portal, 11 = switch
    // 12 = sword, 13 = treasure,

    @FXML
    public void initialize() {

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), e-> {
                    //dungeon.halfTick();
                }),
                new KeyFrame(Duration.seconds(1.0), e -> {
                    //dungeon.secTick();
                    //updateLabels();
                })

            );
    timeline.setCycleCount(Timeline.INDEFINITE);


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ChoiceBox thisbox = new ChoiceBox<>();
                
                thisbox.getItems().add("empty");
                thisbox.setValue("empty");
                thisbox.getItems().add("wall");
                thisbox.getItems().add("player");
                thisbox.getItems().add("enemy");
                thisbox.getItems().add("boulder");
                thisbox.getItems().add("invincibility");
                thisbox.getItems().add("key");
                thisbox.getItems().add("dexPotion");
                thisbox.getItems().add("portal");
                thisbox.getItems().add("switch");
                thisbox.getItems().add("sword");
                thisbox.getItems().add("treasure");
                thisbox.getItems().add("exit");

                // thisbox.selectionModelProperty()
                squares.add(thisbox, i, j);
			}
		}
//		squares.setAlignment(Pos.TOP_CENTER);
	}
}