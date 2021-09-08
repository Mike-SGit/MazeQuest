package unsw.dungeon.Entity;

import java.util.ArrayList;
import java.util.List;

import unsw.dungeon.Dungeon;
import unsw.dungeon.MovingStragety;


/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Moveable implements Observable {

    private Dungeon dungeon;
    public ArrayList<Item> inventory;
    public String status; //alive, dead, invincible
    public int invincibleTime;
    public State playerState;
    public String lastmove;
    ArrayList<Observer> subscribers = new ArrayList<Observer>();
    
    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player( Dungeon dungeon, int x, int y) {
        super(x, y, dungeon, true);
        this.inventory = new ArrayList<>();
        this.status = "alive";
        this.invincibleTime = 0;
        this.playerState = new Alive(this);
    }
    
    public State getState(){
        return this.playerState;
    }
    public void add (Observer observer){
        subscribers.add(observer);
    }
	public void remove (Observer observer){
        subscribers.remove(observer);
    }
	public void notifyObservers(){
        for (Observer e : subscribers){
            e.update(this);
        }
    }
    public void setPlayerStatus(String status){
        this.status = status;
    }

    public String getPlayerStatus(){
        return this.status;
    }

    public ArrayList<Item> getPlayerInventory(){
        return this.inventory;
    }

    public void removeFromInvesntory(Item i){
        this.inventory.remove(i);
    }
    public State getPlayerState(){
        return this.playerState;
    }
    public void addToInvesntory(Item i){
        this.inventory.add(i);
    }

    public boolean checkInventory(Item i){
        ArrayList<Item> itemList = this.inventory;

        for (Item a : itemList){
            if (a.getClass() == i.getClass()){
                return true;
            }
        }
        return false;
    }
    


    //ushableBoulder(this.getY(), this.getX()+1, this.getY(), this.getX()+2);
    public boolean pushableBoulder(int newX, int newY, int emptySpaceX, int emptySpaceY){
        boolean pushable = false;
        boolean emptyspace = true;
        List <Entity> e1 = this.getDungeon().getEntitiesAtXY(emptySpaceX, emptySpaceY);
        for (Entity entity : e1) {
            //System.out.println("inloop");
			if (entity.getPassable() == false) {
                emptyspace = false;
            //System.out.println("emptyspace false");
                
			}
        }
        
        List <Entity> e0 = this.getDungeon().getEntitiesAtXY(newX, newY);
		for (Entity entity : e0) {
            //System.out.println("second loop");
            //System.out.println(entity.toString());
            //System.out.println(entity.getClass().toString());
            String temp = entity.getClass().toString();
			if (entity instanceof Boulder) {
                pushable = true;
                
			}
		}
        if (pushable == true && emptyspace == true){
            //System.out.println("returning pushable true");

            return true;
        }
        //System.out.println("returning pushable false");

        return false;

    }
    public void openabledoor(int newX, int newY){
        //public List<Entity> searchEntity(Class<?> cls){
        List <Entity> e0 = this.getDungeon().getEntitiesAtXY(newX, newY);
		for (Entity entity : e0) {
            String temp = entity.getClass().toString();
			if (entity instanceof Door) {
                if (getDungeon().getPlayer().checkInventory(new Key(1, 1, dungeon, true, 0))){
                    //Key k = (Key)thisItem;
                    Door newd = (Door)entity;
                    if (newd.getId() == 2) continue;
                    newd.open();
                }
			}
		}
        }


    public void playerInteract() {
        List <Entity> e0 = this.getDungeon().getEntitiesAtXY(this.getX(), this.getY());
        for (Entity entity : e0) {
            if (!(entity instanceof Player)){
                System.out.println("interacting with some entity" + entity.getClass());
                entity.interact(this);
            } else {
            }
        }
        return;

    }
    public void changeState(State state) {
        this.playerState = state;
    }

    public void interactFacing (){

    }

    @Override
    public void moveUp() {
        boolean blocked = isPathBlocked(this.getX(), this.getY()+1);
        boolean pushBoulder = pushableBoulder(this.getX(), this.getY()+1, this.getX(), this.getY()+2);
        if (pushBoulder == true){
            List <Entity> e0 = this.getDungeon().getEntitiesAtXY(this.getX(), this.getY()+1);
		    for (Entity entity : e0) {
			    if (entity instanceof Boulder){
                    Boulder a = (Boulder)entity;
                    a.deactivateSwitches();
                    entity.getCoordinate().setXY(entity.getCoordinate().getX(), entity.getCoordinate().getY()+1);
                    a.activateSwitches();
                    
                }
                this.getCoordinate().setXY(this.getCoordinate().getX(), this.getCoordinate().getY()+1);
                this.setY(this.getY()+1);

                return;
		    }
        }
        // boolean blocked = false;
        
		if (blocked == false){
            // this.getCoordinate().setXY(this.getCoordinate().getX(), this.getCoordinate().getY()+1);
            this.setY(this.getY()+1);
            playerInteract();
            // this.getDungeon().getPlayer().setY(this.dungeon.getPlayer().getY()-1);
        }
        getDungeon().trackGoal();
    }
    @Override
    public void moveLeft() {
        boolean blocked = isPathBlocked(this.getX()-1, this.getY());
        boolean pushBoulder = pushableBoulder(this.getY(), this.getX()-1, this.getY(), this.getX()-2);
        if (pushBoulder == true){
            List <Entity> e0 = this.getDungeon().getEntitiesAtXY(this.getX()-1, this.getY());
		    for (Entity entity : e0) {
			    if (entity instanceof Boulder){
                    Boulder a = (Boulder)entity;
                    a.deactivateSwitches();
                    entity.getCoordinate().setXY(entity.getCoordinate().getX()-1, entity.getCoordinate().getY());
                    a.activateSwitches();
                }
                // this.getCoordinate().setXY(this.getCoordinate().getX()-1, this.getCoordinate().getY());
                this.setX(this.getX()-1);

                return;
		    }
        }


		if (blocked == false){
            // this.getCoordinate().setXY(this.getCoordinate().getX()-1, this.getCoordinate().getY());
            this.setX(this.getX()-1);
            playerInteract();

        } else {
            System.out.println("blocked");
        }
        getDungeon().trackGoal();
    }
    @Override
    public void moveRight() {
        // System.out.println("moving from ");

        boolean blocked = isPathBlocked(this.getX()+1, this.getY());
        boolean pushBoulder = pushableBoulder(this.getX()+1, this.getY(), this.getX()+2, this.getY());
        // System.out.println("pushBolder returned..  " + pushBoulder);

        if (pushBoulder == true){
            // System.out.println("into if ");
            List <Entity> e0 = this.getDungeon().getEntitiesAtXY(this.getX()+1, this.getY());
		    for (Entity entity : e0) {
			    if (entity instanceof Boulder){
                    Boulder a = (Boulder)entity;
                    a.deactivateSwitches();
                    entity.getCoordinate().setXY(entity.getCoordinate().getX()+1, entity.getCoordinate().getY());
                    a.activateSwitches();
                    
                }
                this.setY(this.getX()+1);
                // this.getCoordinate().setXY(this.getCoordinate().getX()+1, this.getCoordinate().getY());

                return;
		    }
        }
        // System.out.println(blocked);
		if (blocked == false){
        
            this.setX(this.getX()+1);

            // this.getCoordinate().setXY(this.getCoordinate().getX()+1, this.getCoordinate().getY());
            
            // System.out.println("call interact");
            playerInteract();
        }
        getDungeon().trackGoal();
    }
    @Override
    public void moveDown() {

        boolean blocked = MovingStragety.checkBlocked(this.getCoordinate(), this.getDungeon(), "Down");
        boolean pushBoulder = pushableBoulder(this.getX(), this.getY()-1, this.getX(), this.getY()-2);

        if (pushBoulder == true){
            List <Entity> e0 = this.getDungeon().getEntitiesAtXY(this.getX(), this.getY()-1);
		    for (Entity entity : e0) {
			    if (entity instanceof Boulder){
                    Boulder a = (Boulder)entity;
                    a.deactivateSwitches();
                    entity.getCoordinate().setXY(entity.getCoordinate().getX(), entity.getCoordinate().getY()-1);
                    a.activateSwitches();
                }
                this.getCoordinate().setXY(this.getCoordinate().getX(), this.getCoordinate().getY()-1);

                return;
		    }
        }
		if (blocked == false){
            this.setY(this.getY()-1);
        } else {
            System.out.println("player is blocked");
        }
        getDungeon().trackGoal();
    }

    // public void playerInteraction(){
    //     List<Entity> e = this.getDungeon().getEntitiesAtXY(this.getX(), this.getY());

    //     for (Entity entity : e) {
	// 		if (entity.equals(this)) {
	// 			continue;
	// 		} else {
    //             item.itemInteract(this);
    //         }
			
    //     }
    //     return;
    // }

}


