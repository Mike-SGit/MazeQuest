package unsw.dungeon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import unsw.dungeon.Entity.Boulder;
import unsw.dungeon.Entity.DexterityPotion;
import unsw.dungeon.Entity.Door;
import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.Entity.Entity;
import unsw.dungeon.Entity.Exit;
import unsw.dungeon.Entity.Hound;
import unsw.dungeon.Entity.InvincibilityPotion;
import unsw.dungeon.Entity.Key;
import unsw.dungeon.Entity.Portal;
import unsw.dungeon.Entity.Switch;
import unsw.dungeon.Entity.Sword;
import unsw.dungeon.Entity.Treasure;
import unsw.dungeon.Entity.Wall;

import java.io.File;

/**
 * A DungeonLoader that also creates the necessary ImageViews for the UI,
 * connects them via listeners to the model, and creates a controller.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonControllerLoader extends DungeonLoader {

    private List<ImageView> entities;

    //Images
    private Image playerImage;
    private Image wallImage;
    private Image boulderImage;
    private Image doorImage;
    private Image exitImage;
	private Image enemyImage;
    private Image keyImage;
    private Image openDoorImage;
    private Image portalImage;
	private Image switchImage;
	private Image swordImage;
    private Image treasureImage;
    private Image invincibilityPotionImage;
    private Image houndImage;
    private Image dexterityPotionImage;
	

    public DungeonControllerLoader(String filename)
            throws FileNotFoundException {
        super(filename);
        entities = new ArrayList<>();
        playerImage = new Image((new File("images/human_new.png")).toURI().toString());
        wallImage = new Image((new File("images/brick_brown_0.png")).toURI().toString());
        
        boulderImage = new Image((new File("images/boulder.png")).toURI().toString());
        doorImage = new Image((new File("images/closed_door.png")).toURI().toString());
		switchImage = new Image((new File("images/pressure_plate.png")).toURI().toString());
        exitImage = new Image((new File("images/exit.png")).toURI().toString());
        enemyImage = new Image((new File("images/deep_elf_master_archer.png")).toURI().toString());
        keyImage = new Image((new File("images/key.png")).toURI().toString());
		openDoorImage = new Image((new File("images/open_door.png")).toURI().toString());
		treasureImage = new Image((new File("images/gold_pile.png")).toURI().toString());
        swordImage = new Image((new File("images/greatsword_1_new.png")).toURI().toString());
        portalImage = new Image((new File("images/portal.png")).toURI().toString());
        invincibilityPotionImage = new Image((new File("images/brilliant_blue_new.png")).toURI().toString());
        dexterityPotionImage = new Image((new File("images/dexterity_potion.png").toURI().toString()));
        houndImage = new Image((new File("images/hound.png").toURI().toString()));
		
		
    }

    @Override
    public void onLoad(Entity player) {
        ImageView view = new ImageView(playerImage);
        addEntity(player, view);
    }

    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }

    @Override
    public void onLoad(Boulder boulder) {
        ImageView view = new ImageView(boulderImage);
        addEntity(boulder, view);
    }


    @Override
    public void onLoad(Door door) {
        ImageView view = new ImageView(doorImage);
        addEntity(door, view);
    }

    @Override
    public void onLoadOpenDoor(Door door) {
        ImageView view = new ImageView(openDoorImage);
        addEntity(door, view);
    }

   

    @Override
    public void onLoad(Exit exit) {
        ImageView view = new ImageView(exitImage);
        addEntity(exit, view);
    }

    @Override
    public void onLoad(DexterityPotion dp) {
        ImageView view = new ImageView(dexterityPotionImage);
        addEntity(dp, view);
    }

    @Override
    public void onLoad(Enemy enemy) {
        ImageView view = new ImageView(enemyImage);
        addEntity(enemy, view);
    }

    @Override
    public void onLoad(InvincibilityPotion ip ) {
        ImageView view = new ImageView(invincibilityPotionImage);
        addEntity(ip, view);
    }

    @Override
    public void onLoad(Key key) {
        ImageView view = new ImageView(keyImage);
        addEntity(key, view);
    }
    
    @Override
    public void onLoad(Portal portal) {
        ImageView view = new ImageView(portalImage);
        System.out.print("trying to load portal 148 dungcontloader");
        addEntity(portal, view);
    }

   

    @Override
    public void onLoad(Sword sword) {
        ImageView view = new ImageView(swordImage);
        addEntity(sword, view);
    }

    @Override
    public void onLoad(Treasure treasure) {
        ImageView view = new ImageView(treasureImage);
        addEntity(treasure, view);
        
    }

    @Override
    public void onLoad(Switch swi) {
        ImageView view = new ImageView(switchImage);
        System.out.print("trying to load SWITCH 155 dungcontloader");

        addEntity(swi, view);
    }

    public void onLoad(Hound hound){
        ImageView view = new ImageView(houndImage);
        addEntity(hound, view);
    }


    private void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        entities.add(view);
    }

    /**
     * Set a node in a GridPane to have its position track the position of an
     * entity in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the
     * model will automatically be reflected in the view.
     * @param entity
     * @param node
     */
    
    private void trackPosition(Entity entity, Node node) {
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        entity.getCoordinate().x().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                        if ((oldValue == (Number)1) && (newValue == (Number)4)){
                            node.setVisible(false);
                            return;
                        }
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        });
        entity.getCoordinate().y().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                        if ((oldValue == (Number)1) && (newValue == (Number)4)){
                            node.setVisible(false);
                            return;
                        }
                GridPane.setRowIndex(node, newValue.intValue());
            }
        });
    }

    // private void trackPosition(Entity entity, Node node) {
    //     GridPane.setColumnIndex(node, entity.getX());
    //     GridPane.setRowIndex(node, entity.getY());
    //     entity.x().addListener(new ChangeListener<Number>() {
    //         @Override
    //         public void changed(ObservableValue<? extends Number> observable,
    //                 Number oldValue, Number newValue) {
    //             GridPane.setColumnIndex(node, newValue.intValue());
    //         }
    //     });
    //     entity.y().addListener(new ChangeListener<Number>() {
    //         @Override
    //         public void changed(ObservableValue<? extends Number> observable,
    //                 Number oldValue, Number newValue) {
    //             GridPane.setRowIndex(node, newValue.intValue());
    //         }
    //     });
    // }
    // this.getCoordinate().setXY(this.getCoordinate().getX(), this.getCoordinate().getY()-1);
  
    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController() throws FileNotFoundException {
        return new DungeonController(load(), entities);
    }


}
