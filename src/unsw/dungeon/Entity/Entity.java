package unsw.dungeon.Entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.dungeon.Coordinate;
import unsw.dungeon.Dungeon;

/**
 * An entity in the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public abstract class Entity {

    // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private Coordinate coordinate;
    private Dungeon dungeon;
    public boolean passable;
    //private boolean visibility;

    /**
     * Create an entity positioned in square (x,y)
     * @param x
     * @param y
     */
    //public Entity(int x, int y,Dungeon dungeon, boolean passable, boolean visibility) {
    public Entity(int x, int y,Dungeon dungeon, boolean passable) {
        this.coordinate = new Coordinate(x, y);
        this.dungeon = dungeon;
        this.passable = passable;
        //this.visibility = visibility;
    }

    public Entity(int x, int y, Dungeon dungeon) {
        this.coordinate = new Coordinate(x, y);
        this.dungeon = dungeon;
    }

    public Entity(int x, int y) {
        this.coordinate = new Coordinate(x, y);
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public IntegerProperty y() {
        return this.coordinate.y();
    }

    public IntegerProperty x() {
        return this.coordinate.x();
    }

    public int getX(){
        return x().get();
    }

    public int getY(){
        return y().get();
    }

    public void setX(int x){
        x().set(x);
    }

    public void setY(int y ){
        y().set(y);
    }

    public void setXY(int x, int y){
        setX(x);
        setY(y);
    }

    public boolean getPassable() {
        return this.passable;
    }


    public Dungeon getDungeon() {
    	return this.dungeon;
    }

    
    public void interact(Player p) {
        // if (p.getPlayerState().name != "Invincible"){

        // }
        return;
    }
}
