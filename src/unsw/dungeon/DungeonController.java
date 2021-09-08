package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Entity.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.io.File;
import java.io.IOException;

/**
 * A JavaFX controller for the dungeon.
 * 
 * @author Robert Clifton-Everest
 *
 */
public class DungeonController {

    @FXML
    private Pane pane;

    @FXML
    private GridPane squares;

    private Timeline timeline;
    private Timeline timeline1;


    private List<ImageView> initialEntities;

    private Player player;

    private Image playerImage;

    private Dungeon dungeon;

    public Stage stage;

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.initialEntities = new ArrayList<>(initialEntities);

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                dungeon.secTick();
            }
        };
        KeyFrame playFrame = new KeyFrame(Duration.millis(500), onFinished);
        timeline.getKeyFrames().add(playFrame);
        timeline.play();

        timeline1 = new Timeline();
        timeline1.setCycleCount(Timeline.INDEFINITE);
        EventHandler<ActionEvent> onFinished1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                dungeon.halfTick();
            }
        };
        KeyFrame playFrame1 = new KeyFrame(Duration.millis(500), onFinished1);
        timeline1.getKeyFrames().add(playFrame1);
        timeline1.play();
    }

    // timeline = new Timeline(
    // new KeyFrame(Duration.seconds(0.5), e-> {
    // System.out.println("Tick0.5! from cont");
    // //dungeon.halfTick();
    // }),
    // new KeyFrame(Duration.seconds(1.0), e -> {
    // System.out.println("Tick! from cont");
    // this.dungeon.secTick();
    // //updateLabels();
    // })

    // );
    // timeline.setCycleCount(Timeline.INDEFINITE);

    @FXML
    public void initialize() {
        Image ground = new Image((new File("images/dirt_0_new.png")).toURI().toString());

        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
        }

        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);

        dungeon.getStatus().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("finish")) {
                    try {
                        win();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    try {
                        lose();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        // timeline = new Timeline(
        // new KeyFrame(Duration.seconds(0.5), e-> {
        // //dungeon.halfTick();
        // }),
        // new KeyFrame(Duration.seconds(1.0), e -> {
        // dungeon.secTick();
        // //updateLabels();
        // })

        // );
        // timeline.setCycleCount(Timeline.INDEFINITE);

    }

    @FXML
    public void handleKeyPress2(KeyEvent event) {
        // System.out.println("key pressed2");
        // this.dungeon.getPlayer().setY(this.dungeon.getPlayer().getY()-1);
        handleKeyPress(event);
    }

    public void win() throws IOException {
        FXMLLoader winView = new FXMLLoader(getClass().getResource("WinScreen.fxml"));
        WinScreenController controller = new WinScreenController(stage);
        winView.setController(controller);

        Parent root = winView.load();
        Scene scene = new Scene( root );

        this.stage.setScene(scene);

    }

    public void lose() throws IOException {
        FXMLLoader loseView = new FXMLLoader(getClass().getResource("LostScreen.fxml"));
        LoseScreenController controller = new LoseScreenController(stage);
        loseView.setController(controller);

        Parent root = loseView.load();
        Scene scene = new Scene(root);   
        this.stage.setScene(scene);

    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        
        System.out.println(player.getState().getStateName());
        switch (event.getCode()) {
        case UP:
            player.getState().moveDown();
            break;
        case DOWN:
            player.getState().moveUp();
            break;
        case LEFT:
            player.getState().moveLeft();
            break;
        case RIGHT:
            player.getState().moveRight();
            break;
        case ENTER:
            player.interactFacing();
            break;
        default:
            break;
        }
       
        // this.dungeon.getPlayer().setY(this.dungeon.getPlayer().getY()-1);

    }

    @FXML
    public void handleResetBtn(ActionEvent event) {
        return;
    }

    @FXML
    public void handleExitBtn(ActionEvent event) {
        return;
    }

    @FXML
    public void handleMC(MouseEvent event) {
        // this.dungeon.getPlayer().setY(this.dungeon.getPlayer().getY()-1);
        return;
    }

  

}

