/**
 *
 */
package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import unsw.dungeon.Entity.Enemy;
import unsw.dungeon.Entity.Entity;
import unsw.dungeon.Entity.Hound;
import unsw.dungeon.Entity.Player;
import unsw.dungeon.Entity.Wall;
import unsw.dungeon.goals.Goal;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon {

    private int width, height;
    private List<Entity> entities;
    private Player player;
    private Goal goal;
    private StringProperty status;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
        this.status = new SimpleStringProperty("normal");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
    }

    public void setGoal(Goal g){
        this.goal = g;
    }

    public Goal getGoal(){
        return this.goal;
    }

    public StringProperty getStatus(){
        return this.status;
    }

    public void setStatus(String string){
        this.status.set(string);
    }

    public List<Entity> getEntityList(){
        return this.entities;
    }
    
    public Coordinate getPlayerPosition(){
        return getPlayer().getCoordinate();
    }

    public List<Entity> getEntitiesAtXY(int x, int y){
        Coordinate c = new Coordinate(x, y);
        return getEntities(c);
    }

    public List<Entity> getAdjacentEntities(Coordinate c) {
		List<Entity> l = new ArrayList<Entity>();
		for (Entity e : getEntityList()) {
			if (e != null && e.getCoordinate().nextTo(c)) {
				l.add(e);
			}
		}
		return l;
	}

    public List<Entity> getEntities(Coordinate coordinate){
        if (coordinate == null) return null;
        List<Entity> l = new ArrayList<Entity>();
        for(Entity e : getEntityList()){
            if(e.getCoordinate().getX() == coordinate.getX() && e.getCoordinate().getY() == coordinate.getY()){
                l.add(e);
            }
        }
        return l;
    }

    public List<Entity> getEntities(Coordinate coordinate, Class<?> cls){
        List<Entity> l = new ArrayList<Entity>();
        for(Entity e : getEntities(coordinate)){
            if(e != null && cls.isInstance(e)){
                l.add(e);
            }
        }
        return l;
    }

    public boolean checkOverlap(Entity e1, Entity e2){
        if(e1.getCoordinate().equals(e2.getCoordinate())){
            return true;
        }
        return false;
    }

    public List<Entity> searchEntity(Class<?> cls){
        List<Entity> l = new ArrayList<Entity>();
        for(Entity e : getEntityList()){
            if(cls.isInstance(e) && e != null){
                l.add(e);
            }
        }
        return l;
    }


    public void secTick(){
        List<Entity> enemiesList = this.searchEntity(Enemy.class);
        for (Entity e : enemiesList){
            e.interact(this.player);
        }
        if (player.getPlayerState().getStateName() != "Invincible"){
            setAllEnemy("Toward");
        }
        trackGoal();
        //System.out.print("Tick. " + player.getState().getStateName() );
        return;
    }

    public void halfTick(){
        List<Entity> enemiesList = this.searchEntity(Hound.class);
        for (Entity e : enemiesList){
            e.interact(this.player);
        }
        //System.out.print("Tick. " + player.getState().getStateName() );
        return;
    }
    // public ArrayList<Entity> EntitiesAtXY(int posX, int posY) {
    //     ArrayList<Entity> entityList = new ArrayList<Entity> ();
        
	// 	for (Entity e : getEntityList()) {
			
	// 		if (e.getX() == posX && e.getY() == posY) {
				
	// 			entityList.add(e);
	// 		}
	// 	}
			
	// 	return entityList;
    // }

    public void hideItem(Entity e){
        e.setX(1);
        e.setX(4);
        removeEntity(e);
    }

    public void setAllEnemy(String s){
        List<Entity> l  = searchEntity(Enemy.class);
        if(s == "Toward"){
            for(Entity e0 : l){
                Enemy ene = (Enemy)e0;
                ene.setBehaviour("Toward");
            }
        }else{
            for(Entity e0 : l){
                Enemy ene = (Enemy)e0;
                ene.setBehaviour("Away");
            }
        }
    }

    public void trackGoal(){
        if(getGoal() != null){
            getGoal().update();
            if(getGoal().isComplete() == true){
                setStatus("finish");
                System.out.println("trig win trackgoal");
            }
        }
    }



}
